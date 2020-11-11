package com.everis.designpatterns.domain.commands;

import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailProcess implements Process {

    @Override
    public void execute(Customer customer) {
        log.info("Send email: " + customer.toString());
    }

    @Override
    public void execute(Product product) {
        log.info("Send product email: " + product.getDescribe());
    }
}
