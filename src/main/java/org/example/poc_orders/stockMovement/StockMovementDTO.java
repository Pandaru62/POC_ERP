package org.example.poc_orders.stockMovement;

public class StockMovementDTO {

    private int productId;
    private int quantity;
    private String reason;

    public StockMovementDTO(int productId, int quantity, String reason) {
        this.productId = productId;
        this.quantity = quantity;
        this.reason = reason;
    }

    public int getProductId() {return productId;}
    public void setProductId(int productId) {this.productId = productId;}
    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public String getReason() {return reason;}
    public void setReason(String reason) {this.reason = reason;}

}
