package com.kcy.cashier.controller;

import com.kcy.cashier.dto.OrderDTO;
import com.kcy.cashier.service.CacheService;
import com.kcy.cashier.service.CashierService;
import commonobject.Product;
import messageobject.Menu;
import messageobject.Order;
import constants.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CashierController {

    @Autowired
    Menu menu;

    @Autowired
    CacheService cacheService;

    @Autowired
    CashierService cashierService;

    @GetMapping("/getMenu")
    public ResponseEntity getMenu() {
        return ResponseEntity.ok(menu);
    }

    @PostMapping("/giveOrder")
    public ResponseEntity order(@RequestBody OrderDTO payload) {
        Order order = cashierService.processOrder(payload.getItemIdList());

        return ResponseEntity.ok(order.getOrderId());
    }

    // Get ready order with order id from cache.
    @GetMapping("/getProduct")
    public ResponseEntity getProduct(@RequestParam UUID orderId) {

        Product product = cashierService.getProductFromCache(orderId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found with the given orderId.");
        } else {
            return ResponseEntity.ok(product);
        }
    }

    @GetMapping("/getOrderStatus")
    public ResponseEntity getOrderStatus(@RequestParam UUID orderId) {
        OrderStatus status = cashierService.getOrderStatus(orderId);

        if (status == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You do not have an order with requested orderId.");
        }

        if (status.equals(OrderStatus.IN_THE_QUEUE)) {
            return ResponseEntity.ok("Your product is going to be prepared as soon as a cook gets available.");
        }

        if (status.equals(OrderStatus.BEING_PREPARED)) {
            return ResponseEntity.ok("Your product is being prepared.");
        }

        if (status.equals(OrderStatus.READY)) {
            return ResponseEntity.ok("Your product is ready.");
        }

        if (status.equals(OrderStatus.DELIVERED)) {
            return ResponseEntity.ok("Your product is delivered.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}