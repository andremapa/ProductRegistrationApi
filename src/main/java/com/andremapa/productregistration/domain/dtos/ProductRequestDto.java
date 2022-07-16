package com.andremapa.productregistration.domain.dtos;

import com.andremapa.productregistration.domain.entities.Product;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;

public class ProductRequestDto {

    @NotEmpty
    @Size(min = 3, max = 30)
    private String name;
    @Size(max = 100)
    private String description;
    @NotNull
    @Min(value = 1)
    private Double price;
    @NotNull
    @Min(value = 1)
    private Integer quantity;

    public ProductRequestDto(String name, String description, Double price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product convertModel(){
        return new Product(this.name, this.description, this.price, this.quantity);
    }
}
