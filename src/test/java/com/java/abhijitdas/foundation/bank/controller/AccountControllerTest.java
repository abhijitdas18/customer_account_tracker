package com.java.abhijitdas.foundation.bank.controller;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.services.AccountServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {

    @InjectMocks
    AccountController accountController;
    @Mock
    private AccountServiceImpl accountService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAccounts() {
    }

    @Test
    void getAccount() {
    }

    @Test
    void addAccount() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        String res = "Account is created successfully with Account Id :";

        when(accountService.addAccount(any(Account.class))).thenReturn(new Account());

        Account account =  new Account(101, 12345, "savings",
                5000, "savings", 100);
        String result = accountController.addAccount(account);

        assertEquals("Account is created successfully with Account Id :" + 101, result);


    }

    @Test
    void updateAccountByAccountNumber() {
    }

    @Test
    void getAccountsForCustomer() {
    }

    @Test
    void fundTransfer() {
    }

    @Test
    void getBalanceOf() {
    }
}