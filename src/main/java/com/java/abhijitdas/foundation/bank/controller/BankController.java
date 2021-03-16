package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/app")
public class BankController {

//    @Autowired
//    private AccountService accountService;

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/account")
    public void getAccounts() {
        accountService.getAllAccounts();
    }

    @GetMapping(value = "/accounts/{id}")
    public Optional<Account> getAccount(@PathVariable Integer id) {
        return  accountService.getAccount(id);
    }

    @PostMapping(value = "/accounts")
    public String addAccount(Account account){
        return null;
    }
}
