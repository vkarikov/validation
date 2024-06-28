package ru.vkarikov.validation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vkarikov.validation.entity.Customer;

@RestController
public class CustomerController {
    @PostMapping("/customers")
    ResponseEntity<String> addUser(@Validated @RequestBody Customer customer) {
        // persisting the user
        return ResponseEntity.ok("Customer is valid");
    }
}
