package com.java.abhijitdas.foundation.bank.service;


import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.repository.AccountRepository;
import com.java.abhijitdas.foundation.bank.services.AccountServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;
    //accountRepository = mock(AccountRepository)

    @Test
    @Order(1)
    public void addAccountTest(){
       Account account = new Account();
       account.setAccountNumber(12345);
       account.setAccountType("savings");
       account.setAccountName("sav");
       account.setBalance(10000);
       account.setCustomerId(101);

        Account mockAccount = new Account();
        mockAccount.setAccountNumber(12121);
        mockAccount.setAccountType("savings");
        mockAccount.setAccountName("sav");
        mockAccount.setBalance(8000);
        mockAccount.setCustomerId(101);

        when(accountRepository.save(account)).thenReturn(mockAccount);
        Account act = accountService.addAccount(account);
        System.out.println(act.toString());

        Mockito.verify(accountRepository, atLeastOnce()).save(account);
        assertEquals(12121, act.getAccountNumber());
    }

    @Test
    @Order(2)
    public void findAccountByNumberTest(){

        Optional<Account> accounts = Optional.of(new Account(101,12345,
                "saving", 4000,"sav", 101));

        when(accountRepository.findByAccountNumber(any(Integer.class))).thenReturn(accounts);
        Account account = accountService.findAccountByNumber(105);

        Account savedAccount = accounts.get();

        System.out.println(savedAccount.getAccountNumber() + "\t" + savedAccount.getAccountName());
        assertEquals(12345, account.getAccountNumber());
    }

    @Order(3)
    @Test
    public void getAllAccountsTest(){
        List<Account> accountList = new ArrayList<>();
        accountList.add((new Account(101,12345,
                "saving", 4000,"sav", 101) ));

        accountList.add((new Account(102,23456,
                "current", 24000,"cur", 102) ));

        accountList.add((new Account(103,34567,
                "saving", 6000,"sav", 101) ));

        when(accountRepository.findAll()).thenReturn(accountList);
        List<Account> accounts = accountService.getAllAccounts();

        for(Account account : accounts) {
            System.out.println(account.getAccountId() + "\t" + account.getAccountName());
        }
        assertEquals(23456, accounts.get(1).getAccountNumber());
    }

}
