package com.everis.designpatterns.domain.process;

import com.everis.designpatterns.api.dto.ProductDto;
import com.everis.designpatterns.domain.facade.create.ProductCreate;
import com.everis.designpatterns.domain.facade.fetcher.ProductFetcher;
import com.everis.designpatterns.domain.facade.patcher.ProductPatcher;
import com.everis.designpatterns.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductProcessImpl implements ProductProcess {

    private final ProductCreate productCreate;
    private final ProductFetcher productFetcher;
    private final ProductPatcher productPatcher;

    @Override
    public Product save(ProductDto dto) {
        return productCreate.create(dto);
    }

    @Override
    public void update(ProductDto dto, Long id) {
        productPatcher.update(dto, id);
    }

    @Override
    public void delete(Long id) {
        productPatcher.delete(id);
    }

    @Override
    public List<Product> findAll() {
        return productFetcher.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productFetcher.findById(id);
    }
}
