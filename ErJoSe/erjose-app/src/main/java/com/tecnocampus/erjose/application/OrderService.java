package com.tecnocampus.erjose.application;

import com.tecnocampus.erjose.application.dto.OrderDTO;
import com.tecnocampus.erjose.domain.Order;
import com.tecnocampus.erjose.persistence.OrderRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order = new Order(orderDTO);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Principal principal = securityContext.getAuthentication();

        orderRepository.save(order);
        return new OrderDTO(order);
    }

}
