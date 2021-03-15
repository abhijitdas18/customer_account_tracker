package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class BankController {

    @Autowired
    private AccountService accountService;
    @GetMapping("/account")
    public void getAccounts() {
        accountService.getAllAccounts();
    }
}
