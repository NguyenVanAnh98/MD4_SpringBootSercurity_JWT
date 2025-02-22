package com.example.md4_springbootjwt.controller;

import com.example.md4_springbootjwt.model.Customer;
import com.example.md4_springbootjwt.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> finOne(@PathVariable Long id) {
        Customer c = customerService.findOne(id);
        return new ResponseEntity<>(customerService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        customerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<?> update(@PathVariable Long id, @RequestBody Customer customer) {
        customerService.update(id, customer);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
