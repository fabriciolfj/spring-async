package com.everis.designpatterns.infrastructure.repositories;

import com.everis.designpatterns.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
