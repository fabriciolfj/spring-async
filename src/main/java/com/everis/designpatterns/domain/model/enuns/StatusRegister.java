package com.everis.designpatterns.domain.model.enuns;

import lombok.Getter;

@Getter
public enum StatusRegister {

    ATIVE("ative"), INATIVE("inative");

    private String description;

    StatusRegister(String description) {
        this.description = description;
    }

}
