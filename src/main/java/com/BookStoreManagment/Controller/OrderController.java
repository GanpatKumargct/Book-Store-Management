package com.BookStoreManagment.Controller;

import com.BookStoreManagment.Entity.Order;
import com.BookStoreManagment.Entity.OrderRequest;
import com.BookStoreManagment.Service.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderManagement orderManagement;

    // ✅ Place a new order
    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@RequestBody OrderRequest request) {
        try {
            Order savedOrder = orderManagement.placeorder(request);
            return ResponseEntity.ok(savedOrder); // return 200 OK with order
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to place order: " + e.getMessage());
        }
    }

    // 2️⃣ Get all orders (Admin)
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderManagement.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // 3️⃣ Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable int id) {
        try {
            Order order = orderManagement.getOrderById(id);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Order not found with ID: " + id);
        }
    }

    // 4️⃣ Update order status (Admin)
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int id, @RequestBody String newStatus) {
        String result = orderManagement.updateOrderStatus(id, newStatus);
        return ResponseEntity.ok(result);
    }
}
