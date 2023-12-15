package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.application.dto.OrderDTO;
import com.tecnocampus.erjose.domain.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<OrderDTO> getAllBy(Pageable pageable);
}
