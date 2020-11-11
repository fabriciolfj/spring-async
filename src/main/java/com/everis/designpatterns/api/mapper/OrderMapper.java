package com.everis.designpatterns.api.mapper;

import com.everis.designpatterns.api.dto.OrderDto;
import com.everis.designpatterns.domain.model.Order;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@DecoratedWith(OrderDecorator.class)
public interface OrderMapper {

    OrderDto toDto(final Order order);

}
