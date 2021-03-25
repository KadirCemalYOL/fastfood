package com.kcy.cashier.controller;

import messageobject.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachierController {

    @Autowired
    MenuList menuList;

    @GetMapping("/getMenuList")
    public ResponseEntity getMenuList() {
        return ResponseEntity.ok(menuList);
    }

    @GetMapping("/giveOrder")
    public ResponseEntity order() {

        // Take order from customer, Send it to the cook over work pool.
        return ResponseEntity.ok("t");
    }

    // Get ready order with order id from cache.
    @GetMapping("/getProduct")
    public ResponseEntity getProduct() {
        return ResponseEntity.ok("product.");
    }
}
