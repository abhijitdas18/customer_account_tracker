package com.java.abhijitdas.foundation.bank.repository;

import com.java.abhijitdas.foundation.bank.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void createCustomer(){
        Customer cust1 = new Customer();
        cust1.setCustomerId(1001);
        cust1.setFirstName("Mathew");
        cust1.setLastName("David");
        cust1.setEmail("mathew@outlook.com");
        customerRepository.save(cust1);

        Customer cust2 = new Customer();
        cust2.setCustomerId(1002);
        cust2.setFirstName("Richard");
        cust2.setLastName("Mike");
        cust2.setEmail("mike@outlook.com");
        customerRepository.save(cust2);

        Customer cust3 = new Customer();
        cust3.setCustomerId(1003);
        cust3.setFirstName("Stephen");
        cust3.setLastName("Phillips");
        cust3.setEmail("phillips@outlook.com");
        customerRepository.save(cust3);

        Customer cust4 = new Customer();
        cust4.setCustomerId(1004);
        cust4.setFirstName("Jim");
        cust4.setLastName("Carter");
        cust4.setEmail("carter@outlook.com");
        customerRepository.save(cust4);
    }

    @Test
    public void findCustomer(){
        Optional<Customer> customers = customerRepository.findById(1001);
        Customer customer = customers.get();
        System.out.println("First name :" + customer.getFirstName() + " Last name :" + customer.getLastName());
    }
}
