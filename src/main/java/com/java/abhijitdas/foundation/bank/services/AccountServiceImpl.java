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
        System.out.println("Account : " + account);
        accountRepository.save(account);
        return null;
    }

    @Override
    public Optional<Account> findAccountByNumber(Integer accNumber) {

        return accountRepository.findAccountByNumber(accNumber);
    }


    @Override
    public void deleteAccountById(Integer accountNumber) {

        accountRepository.deleteById(accountNumber);
    }

    @Override
    public void updateAccountByAccountNumber(Integer accountNumber) {
        // accountRepository.
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public String transferFunds(int from, int to, double amount) {
        return null;
    }

    @Override
    public Account getBalanceOf(int accountNumber) {
        return null;
    }

    public void deleteAccountByAccountNumber(Integer accountNumber) {
        accountRepository.deleteAccountByAccountNumber(accountNumber);
    }

}
