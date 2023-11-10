package com.tecnocampus.erjose.persistence;

import com.tecnocampus.erjose.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
