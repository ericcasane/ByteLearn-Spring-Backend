package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.OrderService;
import com.tecnocampus.erjose.application.dto.OrderDTO;
import com.tecnocampus.erjose.domain.UserSecurity;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
    private final OrderService orderService;
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public OrderDTO getOrder() {
        return orderService.createOrder(new OrderDTO(null, null));
    }

}
