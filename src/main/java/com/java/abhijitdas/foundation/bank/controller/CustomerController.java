package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.entity.Customer;
import com.java.abhijitdas.foundation.bank.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    /**
     * Get all customers
     *
     * @return
     */
    @GetMapping("/")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     *
     * @param customerId
     * @return
     */
    @GetMapping(value = "/customers/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable Integer customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if (customer.isEmpty() || customer.equals(null)) {
            throw new EntityNotFoundException(("Invalid Customer id."));
        }
        return customer;
    }

    /**
     *
     * @param customerId
     */
    @DeleteMapping(value = "/customers/{customerId}")
    public void deleteCustomerById(@PathVariable Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }

}
