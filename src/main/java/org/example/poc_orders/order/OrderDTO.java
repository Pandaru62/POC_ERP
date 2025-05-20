package org.example.poc_orders.order;

import org.example.poc_orders.orderItem.OrderItemDTO;

import java.util.List;

public class OrderDTO {
    private List<OrderItemDTO> items;
    private String customerName;

    // Getters et setters
    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
