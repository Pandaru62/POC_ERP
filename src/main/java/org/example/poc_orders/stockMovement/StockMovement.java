package org.example.poc_orders.stockMovement;

import jakarta.persistence.*;
import org.example.poc_orders.product.Product;

import java.time.LocalDateTime;

@Entity
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private String reason;

    private LocalDateTime timestamp;

    public StockMovement() {
        this.timestamp = LocalDateTime.now();
    }

    public StockMovement(int id, Product product, int quantity, String reason) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.reason = reason;
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Product getProduct() {return product;}
    public void setProduct(Product product) {this.product = product;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public String getReason() {return reason;}
    public void setReason(String reason) {this.reason = reason;}
    public LocalDateTime getTimestamp() {return timestamp;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}
}
