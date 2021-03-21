package com.kcy.cashier.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CachierController {

    @GetMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("t");
    }
}
