package com.everis.designpatterns.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private String describe;
    private Long amountItems;
    private String statusOrder;
    private Long customerId;
    List<OrderItemDto> orderItems;
}
