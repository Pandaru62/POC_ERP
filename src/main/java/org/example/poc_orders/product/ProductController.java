package org.example.poc_orders.product;

import org.example.poc_orders.stockMovement.ProductStockDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getProducts();
    }

    @GetMapping("/stock")
    public List<ProductStockDto> getProductsWithStock() {
        return productService.getProductsWithStock();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductDTO productDTO) {
        productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        productService.removeProductById(id);
        return ResponseEntity.noContent().build();
    }

}