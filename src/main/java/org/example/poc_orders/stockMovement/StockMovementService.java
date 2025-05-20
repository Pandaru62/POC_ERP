package org.example.poc_orders.stockMovement;

import org.example.poc_orders.product.Product;
import org.example.poc_orders.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class StockMovementService {

    private final StockMovementRepository stockMovementRepository;
    private final ProductRepository productRepository;

    public StockMovementService(StockMovementRepository stockMovementRepository, ProductRepository productRepository) {
        this.stockMovementRepository = stockMovementRepository;
        this.productRepository = productRepository;
    }

    public void createStockMovement(StockMovementDTO stockMovementDTO) {
        Product product = productRepository.findById(stockMovementDTO.getProductId())
                .orElseThrow(() -> new NoSuchElementException("Product with id" + stockMovementDTO.getProductId() + " not found"));

        System.out.println("Old Quantity: " + product.getQuantityInStock());
        product.setQuantityInStock(product.getQuantityInStock() + stockMovementDTO.getQuantity());
        productRepository.save(product);
        System.out.println("New Quantity: " + product.getQuantityInStock());

        StockMovement movement = new StockMovement();
        movement.setProduct(product);
        movement.setQuantity(stockMovementDTO.getQuantity());
        movement.setReason(stockMovementDTO.getReason());
        stockMovementRepository.save(movement);
    }

}
