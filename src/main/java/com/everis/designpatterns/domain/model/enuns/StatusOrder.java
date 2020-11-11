package com.everis.designpatterns.domain.model.enuns;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum StatusOrder {

    PENDING(1, "Pending"), PROCESSED(2,"Processed"), CANCELED(3, "Canceled"), REFUSED(4, "Refused");

    private String describe;
    private Integer code;

    StatusOrder(final Integer code, final String describe) {
        this.code = code;
        this.describe = describe;
    }

    private static StatusOrder toEnum(final Integer code) {
        return Arrays.stream(StatusOrder.values()).filter(status -> status.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Code invalid: " + code));
    }
}
