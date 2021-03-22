package com.java.abhijitdas.foundation.bank.services;

import com.java.abhijitdas.foundation.bank.entity.Customer;
import com.java.abhijitdas.foundation.bank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer customerId) {

        return customerRepository.findById(customerId);
    }

    @Override
    public void deleteCustomerById(Integer customerId) {

        customerRepository.deleteById(customerId);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
