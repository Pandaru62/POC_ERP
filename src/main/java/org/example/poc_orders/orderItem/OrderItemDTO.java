package org.example.poc_orders.orderItem;

public class OrderItemDTO {
    private int productId;
    private int quantity;

    // Getters et setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
