package com.everis.designpatterns.api.mapper;

import com.everis.designpatterns.api.dto.ProductDto;
import com.everis.designpatterns.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toModel(final ProductDto dto);
    ProductDto toDto(final Product product);
}
