package org.example.poc_orders.product;

import org.example.poc_orders.stockMovement.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final StockMovementRepository stockMovementRepository;

    public ProductService(ProductRepository productRepository,  StockMovementRepository stockMovementRepository) {
        this.productRepository = productRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setQuantityInStock(productDTO.getQuantityInStock());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<ProductStockDto> getProductsWithStock() {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);

        return productRepository.findAll().stream().map(product -> {
            List<StockMovementResponseDTO> recent = product.getStockMovements().stream()
                    .filter(m -> m.getTimestamp().isAfter(sevenDaysAgo.atStartOfDay()))
                    .map(m -> new StockMovementResponseDTO(m.getQuantity(), m.getReason(), m.getTimestamp().toLocalDate())).toList();

            ProductStockDto dto = new ProductStockDto();
            dto.setId(product.getId());
            dto.setName(product.getName());
            dto.setQuantityInStock(product.getQuantityInStock());
            dto.setRecentMovements(recent);

            return dto;
        }).toList();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(()->new NoSuchElementException("Product not found"));
    }

    public void removeProductById(int id) {
        productRepository.deleteById(id);
    }

}
