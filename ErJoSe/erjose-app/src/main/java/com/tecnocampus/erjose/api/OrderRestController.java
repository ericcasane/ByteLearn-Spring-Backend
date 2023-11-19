package com.tecnocampus.erjose.api;

import com.tecnocampus.erjose.application.OrderService;
import com.tecnocampus.erjose.application.dto.OrderDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Tag(name = "Order Controller", description = "Controller to manage orders")
@RestController
@RequestMapping("/orders")
public class OrderRestController {
    private final OrderService orderService;
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO orderDTO, Principal principal) {
        System.out.println("Principal: " + principal.getName());
        return orderService.createOrder(orderDTO);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_STUDENT')")
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }

}
