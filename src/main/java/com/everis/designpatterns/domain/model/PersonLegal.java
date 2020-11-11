package com.everis.designpatterns.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "1")
public class PersonLegal extends Customer {

    private String cnpj;
}
