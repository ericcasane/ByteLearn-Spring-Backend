package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Order;

import java.math.BigDecimal;
import java.util.List;

public record OrderDTO (
        List<String> coursesIds
){
    public OrderDTO(Order order) {
        this(order.getPurchasedCourses().stream().map(Course::getId).toList());
    }
}
