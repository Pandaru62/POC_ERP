package org.example.poc_orders.order;

import jakarta.persistence.*;
import org.example.poc_orders.orderItem.OrderItem;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate orderDate;

    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderItem> items;


    private double calculateTotalAmount() {
        double total = 0;
        for(OrderItem item : items) {
            total += (item.getProduct().getPrice().toBigInteger().doubleValue() * item.getQuantity());
        }
        return total;
    }

    public Order(int id, List<OrderItem> items, String customerName) {
        this.id = id;
        this.items = items;
        this.orderDate = LocalDate.now();
        this.customerName = customerName;
    }

    public Order() {
        this.orderDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format(
                "Order #%d | Customer: %s | Items: %s | Total: €%.2f",
                id, customerName, items, calculateTotalAmount()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }


}
