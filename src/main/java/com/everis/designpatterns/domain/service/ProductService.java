package com.everis.designpatterns.domain.service;

import com.everis.designpatterns.domain.event.ProductEvent;
import com.everis.designpatterns.domain.model.Product;
import com.everis.designpatterns.infrastructure.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ApplicationEventPublisher publisher;
    private final ProductRepository productRepository;

    public Product save(final Product product) {
        Product entity = productRepository.save(product);
        publisher.publishEvent(new ProductEvent(entity));
        return entity;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(final Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }

    public void delete(final Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {}
    }

    public void update(final Product product, final Long id) {
        productRepository.findById(id)
                .map(p -> {
                    p.setDescribe(product.getDescribe());
                    p.setPrice(product.getPrice());
                    return save(p);
                })
                .orElseThrow(() -> new RuntimeException("Product not found: " + id));
    }
}
