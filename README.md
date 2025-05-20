# ERP POC – Orders & Stock Management (Spring Boot)

This is a **Proof of Concept (POC)** for a simple ERP system built using **Java**, **Spring Boot**, **Spring Data JPA**, and **H2 database**.  
It includes basic inventory and order management functionality without a front-end, designed as a technical showcase.

Built by Loris Buchelet as part of a technical showcase / interview preparation.

---

## 🚀 Features

### ✅ Product Management
- Products have a name, price, and quantity in stock.
- Stock is automatically adjusted when:
  - An order is placed.
  - A stock movement is manually created.

### ✅ Order Management
- Orders contain customer name, date (automatically generated), and a list of items.
- Each `OrderItem` includes a product and quantity.
- Stock is validated before confirming an order.
- When placing an order:
  - The product's stock is reduced.
  - A `StockMovement` is created with a negative quantity and reason `"Order #ID"`.

### ✅ Stock Movements
- Track inventory changes independently of product state.
- Manual adjustments allowed via the `POST /stock-movements` endpoint.
- Each movement has:
  - Product reference
  - Quantity (+/-)
  - Reason
  - Date

---

## 📦 Tech Stack

| Layer         | Technology            |
|---------------|------------------------|
| Backend       | Java, Spring Boot      |
| Data Access   | Spring Data JPA        |
| Database      | H2 (in-memory or file) |
| Build Tool    | Maven                  |

---

## 🔧 Endpoints

### 🛒 Order

- `POST /orders`  
  Create a new order. Automatically updates stock and logs a stock movement.

```json
{
  "customerName": "Alice",
  "items": [
    { "productId": 1, "quantity": 2 },
    { "productId": 3, "quantity": 1 }
  ]
}
```

### 📦 Stock Movement
- `POST /stock-movements`
  Manually adjust product stocks

```json
{
  "productId": 1,
  "quantity": 5,
  "reason": "Initial stock"
}
```

### 📋 Product & Stock Overview
- `GET /products/stock`
  Get all products with their current stock and recent stock movements (last 7 days).

```json
[
  {
    "id": 1,
    "name": "Keyboard",
    "quantityInStock": 10,
    "recentMovements": [
      { "quantity": -2, "reason": "Order #42", "date": "2025-05-19" },
      { "quantity": 5, "reason": "Initial stock", "date": "2025-05-18" }
    ]
  }
]
```

## 🛠️ Run Locally

```
mvn spring-boot:run
```

- App runs on [http://localhost:8080]
- H2 Console: [http://localhost:8080/h2-console]
(JDBC URL/File: jdbc:h2:file:./data/demo)

## 🧪 Testing & Future Improvements

> Add unit & integration tests
> Add update operations
> Add filtering on endpoints (e.g., recent orders, low stock)
> Add front-end (based on React)

