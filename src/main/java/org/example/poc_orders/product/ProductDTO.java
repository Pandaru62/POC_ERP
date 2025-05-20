package org.example.poc_orders.product;

import java.math.BigDecimal;

public class ProductDTO {

    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantityInStock;

    // Getters and setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public int getQuantityInStock() {return quantityInStock;}
    public void setQuantityInStock(int quantityInStock) {this.quantityInStock = quantityInStock;}

}
