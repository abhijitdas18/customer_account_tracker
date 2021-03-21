package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityNotFoundException;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping(value = "/app/bank")
public class BankController {

//    @Autowired
//    private AccountService accountService;

    @Autowired
    private AccountServiceImpl accountService;

    /**
     * Get all accounts details
     * @return List of accounts
     */
    @GetMapping("/account")
    public List<Account> getAccounts() {

        return accountService.getAllAccounts();
    }

    /**
     * Get an account details for an account number.
     * @param accountNumber
     * @return
     */
    @GetMapping(value = "/accounts/{accountNumber}")
    public Optional<Account> getAccount(@PathVariable Integer accountNumber) {
        Optional<Account> res = accountService.findAccountByNumber(accountNumber);

        if(res.equals(null) || res.isEmpty()) {
            throw new EntityNotFoundException("Invalid Account id : " + accountNumber);
        }
        return res;
    }

    /**
     * Add a new account
     * @param account
     * @return
     */
    @PostMapping(value = "/accounts")
    public String addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return null;
    }

    /**
     * Delete an account based on account number.
     * @param accountNumber
     */
    @RequestMapping(value = "/accounts/{accountNumber}", method = RequestMethod.DELETE)
    public void deleteAccountById(@PathVariable Integer accountNumber) {
        accountService.deleteAccountByAccountNumber(accountNumber);
    }


    /**
     * Update an account based on Account number
     * @param accountNumber
     */
    @PutMapping("/accounts/{accountNumber}")
    public void updateAccountByAccountNumber(@PathVariable Integer accountNumber) {

    }


}
