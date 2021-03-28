package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.entity.FundTransfer;
import com.java.abhijitdas.foundation.bank.entity.Transaction;
import com.java.abhijitdas.foundation.bank.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/app/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    // -------------------Retrieve All Accounts---------------------------------------------
    /**
     * Get all accounts details
     *
     * @return List of accounts
     */
    @GetMapping("/accounts")
    public List<Account> getAccounts() {

        return accountService.getAllAccounts();
    }
    // -------------------Retrieve an account details for an account number------------------
    /**
     * Get an account details for an account number.
     *
     * @param accountNumber
     * @return
     */
    @GetMapping(value = "/accounts/{accountNumber}")
    public Account getAccount(@PathVariable Integer accountNumber) {
        Account account = accountService.findAccountByNumber(accountNumber);
        if (account == null) {
            throw new EntityNotFoundException("Invalid Account id : " + accountNumber);
        }
        return account;
    }
    // -------------------Create an account---------------------------------------------------
    /**
     * Add/Create a new account.
     *
     * @param account
     * @return
     */
    @PostMapping(value = "/accounts")
    public String addAccount(@RequestBody Account account) {
        try {
            accountService.addAccount(account);
            return "Account is created successfully with Account Id :" + account.getAccountId();
        } catch (Exception e) {
            throw new EntityNotFoundException("Customer Id " + account.getCustomerId() + " is not valid.");
        }
    }

    /**
     * TODO : Not needed, as account details will be deleted by customer only
     * Delete an account based on account number.
     * @param accountNumber
     */
   /* @RequestMapping(value = "/accounts/{accountNumber}", method = RequestMethod.DELETE)
    public void deleteAccountById(@PathVariable Integer accountNumber) {
        accountService.deleteAccountByAccountNumber(accountNumber);
    }*/


    /**
     * Update an account based on Account number.
     *
     * @param accountNumber
     */
    @PutMapping("/accounts/{accountNumber}")
    public ResponseEntity<Account> updateAccountByAccountNumber(@PathVariable Integer accountNumber,
                                                                @RequestBody Account account) {

        Account updatedAccount = accountService.updateAccountByAccountNumber(accountNumber, account);
        return ResponseEntity.ok(updatedAccount);
    }

    /**
     * Get All account details for a customer id.
     *
     * @param customerId
     * @return
     */
    @GetMapping(value = "/accounts/customers/{customerId}")
    public List<Account> getAccountsForCustomer(@PathVariable Integer customerId) {
        System.out.println("Customer id : " + customerId);
        List<Account> listOfAccounts = accountService.findAccountsByCustomerId(customerId);
        if (listOfAccounts.size() < 1) {
            System.out.println("No accounts details found for the customer id. " + customerId);
        }
        return listOfAccounts;
    }

    /**
     * Fund transfer for account 1 to account 2.
     * @param fundTransfer
     * @return
     */
    @PostMapping(value = "/accounts/fundTransfer")
    public Transaction fundTransfer(@RequestBody FundTransfer fundTransfer){

        Transaction transaction = accountService.fundTransfer(fundTransfer);
        return transaction;
    }

}
