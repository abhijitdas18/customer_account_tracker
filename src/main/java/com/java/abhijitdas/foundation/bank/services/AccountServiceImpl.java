package com.java.abhijitdas.foundation.bank.services;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.entity.Customer;
import com.java.abhijitdas.foundation.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public String addAccount(Account account) {
        return null;
    }

    @Override
    public Optional<Account> getAccount(Integer accNumber) {

        return accountRepository.findById(accNumber);
    }


    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public String transferFunds(int from, int to, double amount) {
        return null;
    }

    @Override
    public Account getBalanceOf(int accountNumber) {
        return null;
    }
}
