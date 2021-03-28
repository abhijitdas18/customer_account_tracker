package com.java.abhijitdas.foundation.bank.repository;

import com.java.abhijitdas.foundation.bank.entity.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Order(1)
    @Sql("/schema.sql")
    public void findByAccountNumberTest(){
        System.out.println("Creating Accounts:");
        Account accountOne = new Account(101,12345,
                "saving", 4000,"sav", 101);

        Account accountTwo = new Account(101,45678,
                "saving", 4880,"sav", 102);

        Account accountThree = new Account(101,67890,
                "current", 14000,"cur", 101);

        Account acc1 = accountRepository.save(accountOne);
        Account acc2 = accountRepository.save(accountTwo);
        Account acc3 = accountRepository.save(accountThree);

        assertEquals(45678, acc2.getAccountNumber());
        assertEquals(67890, acc3.getAccountNumber());



    }
}
