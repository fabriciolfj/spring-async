package com.everis.designpatterns.domain.event;

import com.everis.designpatterns.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductEvent {

    private Product product;

}
