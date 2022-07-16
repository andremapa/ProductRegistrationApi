package com.andremapa.productregistration.domain.services;

import com.andremapa.productregistration.domain.entities.Product;
import com.andremapa.productregistration.domain.repositories.ProductRepository;
import com.andremapa.productregistration.domain.services.interfaces.ProductService;
import com.andremapa.productregistration.domain.dtos.ProductRequestDto;
import com.andremapa.productregistration.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public Product save(ProductRequestDto request){
        Product model = request.convertModel();
        Optional<Product> optional = repository.findByName(model.getName());
        if (optional.isEmpty()) {
            return repository.save(model);
        }
        Product product = optional.get().addQuantity(model.getQuantity());
        return repository.save(product);
    }

    public Product update(Long id, ProductRequestDto request){
        Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        BeanUtils.copyProperties(request, product);
        return repository.save(product);
    }
}
