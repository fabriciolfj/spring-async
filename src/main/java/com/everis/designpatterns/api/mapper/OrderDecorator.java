package com.everis.designpatterns.api.mapper;

import com.everis.designpatterns.api.dto.OrderDto;
import com.everis.designpatterns.api.dto.OrderItemDto;
import com.everis.designpatterns.domain.model.Order;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class OrderDecorator implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        List<OrderItemDto> items = order.getOrderItems().stream().map(i ->  OrderItemDto
                            .builder()
                            .productId(i.getProduct().getId())
                            .quantity(i.getQuantity())
                            .total(i.getTotal())
                            .build())
                .collect(Collectors.toList());

        OrderDto dto = OrderDto
                .builder()
                .orderItems(items)
                .amountItems(order.getAmountItems())
                .describe(order.getDescribe())
                .customerId(order.getCustomer().getId())
                .statusOrder(order.getStatusOrder().getDescribe())
                .id(order.getId())
                .build();

        return dto;
    }
}
