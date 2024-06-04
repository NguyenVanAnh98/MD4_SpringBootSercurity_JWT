package com.example.md4_springbootjwt.service;

import com.example.md4_springbootjwt.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    void save(Customer customer);

    void deleteById(Long id);

    void update(Long id, Customer customer);
}
