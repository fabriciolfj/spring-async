package com.everis.designpatterns.domain.service;

import com.everis.designpatterns.domain.commands.Process;
import com.everis.designpatterns.domain.model.Address;
import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.infrastructure.repositories.AddressRepository;
import com.everis.designpatterns.infrastructure.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final List<Process> process;
    private final CustomerRepository customerRepository;

    public void execute(final Customer customer) {
        CompletableFuture.runAsync(() -> customerRepository.save(customer))
                .whenCompleteAsync((c, t) -> {
                    if (t != null) {
                        throw new RuntimeException("Fail save customer");
                    }

                    process.stream().forEach(p -> p.execute(customer));
                });
    }

    public Customer getById(final Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not localized, id: " + id));
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}