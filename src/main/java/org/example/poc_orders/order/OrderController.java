package org.example.poc_orders.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody OrderDTO orderDTO) {
        System.out.println("New order from controller");
        orderService.addOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        orderService.removeOrderById(id);
        return ResponseEntity.noContent().build();
    }

}