package com.java.abhijitdas.foundation.bank.services;

import com.java.abhijitdas.foundation.bank.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    // This method is expected to return all Customers details
    // including account details
    public List<Customer> getAllCustomers();


    public Optional<Customer> getCustomerById(Integer customerId);

    public  void deleteCustomerById(Integer customerId);

    public void getAllCustomersWithAccounts();
}
