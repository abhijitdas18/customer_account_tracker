package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< Updated upstream
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
>>>>>>> Stashed changes

@RestController
@RequestMapping(value = "/app")
public class BankController {

    @Autowired
    private AccountService accountService;
    @GetMapping("/account")
    public List<Account> getAccounts() {

       return  accountService.getAllAccounts();
    }
<<<<<<< Updated upstream
=======

    @GetMapping(value = "/accounts/{id}")
    public Optional<Account> getAccount(@PathVariable Integer id) {
        return  accountService.getAccount(id);
    }

    @PostMapping(value = "/accounts")
    public String addAccount(@RequestBody Account account){
        accountService.addAccount(account);
        return null;
    }

    @RequestMapping(value = "/accounts/{accountNumber}", method = RequestMethod.DELETE)
    public void deleteAccountById(@PathVariable Integer accountNumber) {
        accountService.deleteAccountByAccountNumber(accountNumber);
    }


>>>>>>> Stashed changes
}
