package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.OrderDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User userId;

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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Order() {
    }

    public Order(OrderDTO orderDTO){
        this.total = orderDTO.total();
        this.purchasedCourses = orderDTO.purchasedCourses();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    
    public List<Course> getPurchasedCourses() {
        return purchasedCourses;
    }

    public void setPurchasedCourses(List<Course> purchasedCourses) {
        this.purchasedCourses = purchasedCourses;
    }
}
