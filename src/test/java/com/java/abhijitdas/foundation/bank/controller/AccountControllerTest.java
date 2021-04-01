package com.java.abhijitdas.foundation.bank.controller;


import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.services.AccountServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

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
    void getAccountsTest() {

        Account account1 =  new Account(101, 12345, "savings",
                5000, "savings", 100);
        Account account2 =  new Account(102, 34567, "savings",
                5000, "savings", 100);
        Account account3 =  new Account(103, 456789, "savings",
                5000, "savings", 100);

        List<Account> listOfAccount;
        listOfAccount = new ArrayList<>();
        listOfAccount.add(account1);
        listOfAccount.add(account2);
        listOfAccount.add(account3);

        when(accountService.getAllAccounts()).thenReturn(listOfAccount);

        List<Account> accountList = accountController.getAccounts();

        assertThat(accountList.size()).isEqualTo(3);
        assertThat(accountList.get(1).getAccountNumber()).isEqualTo(34567);
    }

    @Test
    void getAccount() {

    }

    @Test
    void addAccountTest() {
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
