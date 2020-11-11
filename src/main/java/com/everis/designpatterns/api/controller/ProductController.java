package com.everis.designpatterns.api.controller;

import com.everis.designpatterns.api.dto.ProductDto;
import com.everis.designpatterns.domain.model.Product;
import com.everis.designpatterns.domain.process.ProductProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductProcess productProcess;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Product> findAll() {
        return productProcess.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Product findAll(@PathVariable("id") final Long id) {
        return productProcess.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody final ProductDto dto, @PathVariable final Long id) {
        productProcess.update(dto, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody final ProductDto dto) {
        return productProcess.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) {
        productProcess.delete(id);
    }

}
