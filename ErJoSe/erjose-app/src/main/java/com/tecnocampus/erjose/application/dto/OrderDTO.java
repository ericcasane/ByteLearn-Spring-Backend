package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO (
        BigDecimal total,
        List<Course> purchasedCourses
){
    public OrderDTO(Order order) {
        this(order.getTotal(), order.getPurchasedCourses());
    }
}
