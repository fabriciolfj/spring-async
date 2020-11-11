package com.everis.designpatterns.domain.facade.fetcher;

import com.everis.designpatterns.domain.model.Product;
import com.everis.designpatterns.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductFetcher {

    private final ProductService productService;

    public List<Product> findAll() {
        return productService.findAll();
    }

    public Product findById(final Long id) {
        return productService.findById(id);
    }
}
