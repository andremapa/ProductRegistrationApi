package com.andremapa.productregistration.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "table_product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @Column
    private double totalValueOnStock;

    /**
     *  Constructor default for hibernate
     */
    public Product() {
    }

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.totalValueOnStock = price*quantity;
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

    public Product addQuantity(int value){
        this.quantity += value;
        this.totalValueOnStock = quantity * price;
        return this;
    }

    public double getTotalValueOnStock() {
        return totalValueOnStock;
    }
}
