package org.example.poc_orders.stockMovement;

import java.util.List;

public class ProductStockDto {

    private int id;
    private String name;
    private int quantityInStock;
    private List<StockMovementResponseDTO> recentMovements;

    public ProductStockDto(int id, String name, int quantityInStock, List<StockMovementResponseDTO> recentMovements) {
        this.id = id;
        this.name = name;
        this.quantityInStock = quantityInStock;
        this.recentMovements = recentMovements;
    }

    public ProductStockDto() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getQuantityInStock() {return quantityInStock;}
    public void setQuantityInStock(int quantityInStock) {this.quantityInStock = quantityInStock;}
    public List<StockMovementResponseDTO> getRecentMovements() {return recentMovements;}
    public void setRecentMovements(List<StockMovementResponseDTO> recentMovements) {this.recentMovements = recentMovements;}

}
