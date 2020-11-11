package com.everis.designpatterns.api.controller;

import com.everis.designpatterns.api.dto.CustomerDto;
import com.everis.designpatterns.domain.core.abstractfactory.CustomerFactory;
import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    private final CustomerFactory factory;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CustomerDto customerDto) {
        service.execute(factory.createCustomer(customerDto));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CustomerDto findById(@PathVariable("id") Long id) {
        Customer customer = service.getById(id);
        return factory.createCustomerDto(customer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<CustomerDto> findAll() {
        return service.findAll().stream().map(c -> factory.createCustomerDto(c)).collect(Collectors.toList());
    }
}
