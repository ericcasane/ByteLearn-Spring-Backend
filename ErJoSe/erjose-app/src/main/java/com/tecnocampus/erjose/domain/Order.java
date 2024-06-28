package com.tecnocampus.erjose.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User userId;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be greater than 0")
    private BigDecimal total;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    @ManyToMany
    @JoinTable(
            name = "order_courses",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> purchasedCourses;

    public Order() {

    }

    public Order(User userId, List<Course> purchasedCourses) {
        this.userId = userId;
        this.purchasedCourses = purchasedCourses;
        this.total = purchasedCourses.stream().map(Course::getCurrentPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getOrderId() {
        return String.format("#%05d", this.id);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getTotalFormatted() {
        return total.toString() + "€";
    }

    public List<Course> getPurchasedCourses() {
        return purchasedCourses;
    }
}
