package com.everis.designpatterns.domain.facade.patcher;

import com.everis.designpatterns.api.dto.ProductDto;
import com.everis.designpatterns.api.mapper.ProductMapper;
import com.everis.designpatterns.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPatcher {

    private final ProductService productService;
    private final ProductMapper mapper;

    public void update(final ProductDto dto, final Long id) {
        productService.update(mapper.toModel(dto), id);
    }

    public void delete(final Long id) {
        productService.delete(id);
    }
}
