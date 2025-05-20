package org.example.poc_orders.stockMovement;

import java.time.LocalDate;

public class StockMovementResponseDTO {

    private int quantity;
    private String reason;
    private LocalDate date;

    public StockMovementResponseDTO(int quantity, String reason, LocalDate date) {
        this.quantity = quantity;
        this.reason = reason;
        this.date = date;
    }

    public int getQuantity() {return quantity;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public String getReason() {return reason;}
    public void setReason(String reason) {this.reason = reason;}
    public  LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}

}
