package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.OrderService;
import com.tecnocampus.erjose.application.dto.OrderCreateDTO;
import com.tecnocampus.erjose.application.dto.OrderDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Tag(name = "6. Order", description = "Controller to manage orders")
@RestController
@RequestMapping("/orders")
@SecurityRequirement(name = "BearerAuth")
public class OrderRestController {
    private final OrderService orderService;
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('CREATE_ORDER')")
    @Operation(summary = "Create an order")
    public OrderDTO createOrder(@Valid @RequestBody OrderCreateDTO orderCreateDTO) {
        return orderService.createOrder(orderCreateDTO);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('READ_ORDER')")
    @Operation(summary = "Get all orders")
    public List<OrderCreateDTO> getOrders() {
        return orderService.getOrders();
    }

}
