package com.BookStoreManagment.Controller;

import com.BookStoreManagment.Entity.Order;
import com.BookStoreManagment.Entity.OrderRequest;
import com.BookStoreManagment.Service.OrderManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderManagement orderManagement;

    // 1. Place Student
    @PostMapping("/placeorder")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest){
        String placeorder = orderManagement.placeorder(orderRequest);
        return ResponseEntity.ok(placeorder);

    }

    // 2️⃣ Get all orders (Admin)
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderManagement.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // 3️⃣ Get order by ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable int id) {
        Order order = orderManagement.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // 4️⃣ Update order status (Admin)
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int id, @RequestBody String newStatus) {
        String result = orderManagement.updateOrderStatus(id, newStatus);
        return ResponseEntity.ok(result);
    }
}
