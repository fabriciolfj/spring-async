package com.everis.designpatterns.infrastructure.repositories;

import com.everis.designpatterns.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
