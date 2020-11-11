package com.everis.designpatterns.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDto {

    private String describe;
    private BigDecimal price;
}
