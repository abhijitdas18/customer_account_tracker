package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.entity.Customer;
import com.java.abhijitdas.foundation.bank.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> listOfCustomer = customerService.getAllCustomers();
        if(listOfCustomer.isEmpty() || listOfCustomer.size() == 0){
            System.out.println("No Customer found.");
        }
        return listOfCustomer;
    }

    /**
     * Get customer for id.
     * @param customerId
     * @return
     */
    @GetMapping(value = "/customers/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable Integer customerId) {
        Optional<Customer> customer = customerService.getCustomerById(customerId);
        if (customer.isEmpty() || customer.equals(null)) {
            throw new EntityNotFoundException(("Invalid Customer id. " + customerId));
        }
        return customer;
    }

    @PostMapping(value =  "/customers")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

    /**
     *
     * @param customerId
     */
    @DeleteMapping(value = "/customers/{customerId}")
    public String deleteCustomerById(@PathVariable Integer customerId) {

        try {
            customerService.deleteCustomerById(customerId);
            return "Customer details successfully deleted.";
        }catch(EmptyResultDataAccessException ex) {
            throw new EntityNotFoundException(("Invalid Customer id. " + customerId));
        }
    }



}
