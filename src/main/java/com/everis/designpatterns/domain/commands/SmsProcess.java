package com.everis.designpatterns.domain.commands;

import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.domain.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsProcess implements Process {

    @Override
    public void execute(final Customer customer) {
        log.info("Send sms: " + customer.toString());
    }

    @Override
    public void execute(final Product product) {
        log.info("Send product sms: " + product.getDescribe());
    }
}
