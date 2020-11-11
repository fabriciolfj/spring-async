package com.everis.designpatterns.infrastructure.repositories;

import com.everis.designpatterns.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
