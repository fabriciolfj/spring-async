package com.everis.designpatterns.domain.commands;

import com.everis.designpatterns.domain.model.Customer;
import com.everis.designpatterns.domain.model.Product;

public interface Process {

    void execute(final Customer customer);

    void execute(final Product product);
}
