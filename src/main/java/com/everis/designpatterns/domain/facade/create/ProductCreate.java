package com.everis.designpatterns.domain.facade.create;

import com.everis.designpatterns.api.dto.ProductDto;
import com.everis.designpatterns.api.mapper.ProductMapper;
import com.everis.designpatterns.domain.model.Product;
import com.everis.designpatterns.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCreate {

    private final ProductService productService;
    private final ProductMapper mapper;

    public Product create(final ProductDto dto) {
        return productService.save(mapper.toModel(dto));
    }


}
