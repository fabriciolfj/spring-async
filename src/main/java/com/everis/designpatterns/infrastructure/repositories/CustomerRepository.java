package com.everis.designpatterns.infrastructure.repositories;

import com.everis.designpatterns.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
