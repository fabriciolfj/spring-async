package com.everis.designpatterns.domain.model.enuns;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum TypeCustomer {

    LEGAL_PERSON(1, "legal_person"), PHYSICAL_PERSON(2, "physical_person");

    private String describe;
    private Integer code;

    TypeCustomer(final Integer code, final String describe) {
        this.describe = describe;
        this.code = code;
    }

    public static TypeCustomer toEnum(final String describe) {
        return Arrays.stream(TypeCustomer.values()).filter(type -> type.getDescribe().equals(describe)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Code invalid: " + describe));
    }
}
