package com.tecnocampus.erjose.application.dto;

import com.tecnocampus.erjose.domain.Order;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record OrderDTO(
        String orderId,
        String total,
        String purchasedAt,
        List<CourseDTO> purchasedCourses)
{
    private static final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.of("Europe/Madrid"));
    public OrderDTO(Order order) {
        this(order.getOrderId(), order.getTotalFormatted(), formatter.format(order.getCreatedAt()), order.getPurchasedCourses().stream().map(CourseDTO::new).toList());
    }
}