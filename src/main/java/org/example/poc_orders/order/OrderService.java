package org.example.poc_orders.order;

import org.example.poc_orders.orderItem.OrderItem;
import org.example.poc_orders.orderItem.OrderItemDTO;
import org.example.poc_orders.product.Product;
import org.example.poc_orders.product.ProductRepository;
import org.example.poc_orders.stockMovement.StockMovementDTO;
import org.example.poc_orders.stockMovement.StockMovementService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final StockMovementService stockMovementService;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, StockMovementService stockMovementService) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.stockMovementService = stockMovementService;
    }

    public void addOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerName(orderDTO.getCustomerName());
        order.setOrderDate(LocalDate.now());

        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDTO itemDTO : orderDTO.getItems()) {
            Product product = productRepository.getReferenceById(itemDTO.getProductId());

            if (product.getQuantityInStock() < itemDTO.getQuantity()) {
                throw new IllegalArgumentException("This product has a stock limit of " + product.getQuantityInStock());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());

            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        orderRepository.save(order);

        for (OrderItem item : order.getItems()) {
            stockMovementService.createStockMovement(
                    new StockMovementDTO(item.getProduct().getId(), -item.getQuantity(), "Order #" + order.getId())
            );
        }
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return  orderRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Order with id " + id + " does not exist"));
    }

    public void removeOrderById(int id) {
        orderRepository.deleteById(id);
    }

}
