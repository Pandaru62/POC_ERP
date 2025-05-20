package org.example.poc_orders;

import org.example.poc_orders.order.OrderService;
import org.example.poc_orders.product.Product;
import org.example.poc_orders.product.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PocOrdersApplication {

    public static void main(String[] args) {

         SpringApplication.run(PocOrdersApplication.class, args);


    }

}
