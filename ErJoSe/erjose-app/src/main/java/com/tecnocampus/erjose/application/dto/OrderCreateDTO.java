package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Course;
import com.tecnocampus.erjose.domain.Order;

import java.util.List;

public record OrderCreateDTO(
        List<String> coursesIds
){
    public OrderCreateDTO(Order order) {
        this(order.getPurchasedCourses().stream().map(Course::getId).toList());
    }
}
