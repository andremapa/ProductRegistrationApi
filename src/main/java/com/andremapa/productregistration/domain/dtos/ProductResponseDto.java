package com.andremapa.productregistration.domain.dtos;

import com.andremapa.productregistration.domain.entities.Product;
import org.springframework.hateoas.RepresentationModel;

public class ProductResponseDto extends RepresentationModel<ProductResponseDto> {

    private final long id;
    private final String name;
    private final String description;
    private final double price;
    private final int quantity;
    private final double totalValueOnStock;

    public ProductResponseDto(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.totalValueOnStock = product.getTotalValueOnStock();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValueOnStock() {
        return totalValueOnStock;
    }

}
