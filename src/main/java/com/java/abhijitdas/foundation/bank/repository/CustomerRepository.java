package com.java.abhijitdas.foundation.bank.repository;

import com.java.abhijitdas.foundation.bank.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
