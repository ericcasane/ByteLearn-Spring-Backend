package com.tecnocampus.erjose.domain;

import com.tecnocampus.erjose.application.dto.OrderDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
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
    private LocalDate creationDate;
    private LocalDate modifiedDate;
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
        this.creationDate = LocalDate.now();
        this.modifiedDate = null;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<Course> getPurchasedCourses() {
        return purchasedCourses;
    }

    public void setPurchasedCourses(List<Course> purchasedCourses) {
        this.purchasedCourses = purchasedCourses;
    }
}
