package com.everis.designpatterns.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")
public class PersonPhysical extends Customer {

    private String cpf;
}
