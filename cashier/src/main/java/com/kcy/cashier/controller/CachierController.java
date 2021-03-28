package com.kcy.cashier.controller;

import com.kcy.cashier.dto.OrderDTO;
import com.kcy.cashier.service.ProductService;
import messageobject.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CachierController {

    @Autowired
    Menu menu;

    @Autowired
    ProductService productService;

    @GetMapping("/getMenu")
    public ResponseEntity getMenu() {
        return ResponseEntity.ok(menu);
    }

    @PostMapping("/giveOrder")
    public ResponseEntity order(@RequestBody OrderDTO payload) {
        // Take order from customer, Send it to the cook through work pool.
        UUID orderId = productService.sendOrderRequestToCooks(payload.getItemIdList());

        //Return use requestId.
        return ResponseEntity.ok(orderId);
    }

    // Get ready order with order id from cache.
    @GetMapping("/getProduct")
    public ResponseEntity getProduct(@RequestParam UUID orderId) {

        // TODO Check cache with orderId
        // TODO If product is ready return it, else return meaningful error?

        return ResponseEntity.ok("product.");
    }
}
