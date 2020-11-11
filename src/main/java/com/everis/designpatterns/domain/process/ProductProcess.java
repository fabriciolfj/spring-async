package com.everis.designpatterns.domain.process;

import com.everis.designpatterns.api.dto.ProductDto;
import com.everis.designpatterns.domain.model.Product;

import java.util.List;

public interface ProductProcess {

    Product save(final ProductDto dto);
    void update(final ProductDto dto, final Long id);
    void delete(final Long id);
    List<Product> findAll();
    Product findById(final Long id);
}
