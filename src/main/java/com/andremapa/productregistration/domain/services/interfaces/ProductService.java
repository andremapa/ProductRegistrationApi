package com.andremapa.productregistration.domain.services.interfaces;

import com.andremapa.productregistration.domain.entities.Product;
import com.andremapa.productregistration.domain.dtos.ProductRequestDto;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id);
    Product save(ProductRequestDto request);
    Product update(Long id, ProductRequestDto request);
}
