package com.andremapa.productregistration.controllers;

import com.andremapa.productregistration.domain.entities.Product;
import com.andremapa.productregistration.domain.services.interfaces.ProductService;
import com.andremapa.productregistration.domain.dtos.ProductRequestDto;
import com.andremapa.productregistration.domain.dtos.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAll(){
        List<Product> all = service.findAll();
        List<ProductResponseDto> reponseWithHateaos = all.stream()
                .map(ProductResponseDto::new)
                .peek(response ->
                        response.add(linkTo(methodOn(ProductController.class)
                                .findById(response.getId())).withSelfRel())).toList();
        return new ResponseEntity<>(reponseWithHateaos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Long id){
        Product byId = service.findById(id);
        return new ResponseEntity<>(
                new ProductResponseDto(byId)
                        .add(linkTo(methodOn(ProductController.class).findAll()).withRel("Product List"))
                , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> save(@RequestBody @Valid ProductRequestDto request){
        Product save = service.save(request);
        return new ResponseEntity<>(
                new ProductResponseDto(save)
                        .add(linkTo(methodOn(ProductController.class).findAll()).withRel("Product List")),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id,
                                                     @RequestBody @Valid ProductRequestDto request){
        Product update = service.update(id, request);
        return new ResponseEntity<>(new ProductResponseDto(update), HttpStatus.OK);
    }
}
