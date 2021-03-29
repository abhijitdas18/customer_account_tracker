package com.java.abhijitdas.foundation.bank.services;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.entity.FundTransfer;
import com.java.abhijitdas.foundation.bank.entity.Transaction;
import com.java.abhijitdas.foundation.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.time.format.DateTimeFormatter;

@Service
public class AccountServiceImpl implements IAccountService {

    static int counter = 1000;

    public static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter DATE_TIME_FORMATTER
            = DateTimeFormatter.ofPattern(DATE_PATTERN);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account findAccountByNumber(Integer accNumber) {

        Account account = accountRepository.findByAccountNumber(accNumber).get();
        return account;
    }


    @Override
    public void deleteAccountById(Integer accountNumber) {

        accountRepository.deleteById(accountNumber);
    }

    @Override
    public Account updateAccountByAccountNumber(Integer accountNumber, Account account) {
//        Account accountObj = findAccountByNumber(accountNumber)
//                .orElseThrow(() -> new EntityNotFoundException("Account Number : "
//                + accountNumber + " is not found."));
        System.out.println("Acc no :" + accountNumber);


        Account storedAccountObj = findAccountByNumber(accountNumber);
        System.out.println("storedAccountObj : "+ storedAccountObj);
        if(storedAccountObj == null) {
            throw new EntityNotFoundException("Account Number : " + accountNumber + " is not found.");
        }
        System.out.println("storedAccountObj Acc no:" + storedAccountObj.getAccountNumber());
        storedAccountObj.setAccountNumber(storedAccountObj.getAccountNumber());
        storedAccountObj.setAccountName(account.getAccountName());
        storedAccountObj.setAccountType(account.getAccountType());
        storedAccountObj.setBalance(account.getBalance());
        storedAccountObj.setCustomerId(account.getCustomerId());

        Account updatedAccount = addAccount(storedAccountObj);
        return updatedAccount;

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
        return findAccountByNumber(accountNumber);
    }

    @Override
    public List<Account> findAccountsByCustomerId(Integer customerId) {
        return accountRepository.findByCustomerId(customerId);
        // Optional
        //return accountRepository.findAccountsByCustomerId(customerId);
    }

    @Override
    public Transaction fundTransfer(FundTransfer fundTransfer) {

        int fromAccNo = fundTransfer.getFromAccountNumber();
        int toAccNo = fundTransfer.getToAccountNumber();
        int amt = fundTransfer.getAmount();

        Optional<Account> fromAccountOpt = accountRepository.findByAccountNumber(fromAccNo);
        Account fromAccount = fromAccountOpt.get();
        if(fromAccount.getBalance() > amt) {
            fromAccount.setBalance(fromAccount.getBalance() - amt);
            accountRepository.save(fromAccount);

           Optional<Account> toAccountOpt = accountRepository.findByAccountNumber(toAccNo);
           Account toAccount = toAccountOpt.get();

           toAccount.setBalance(toAccount.getBalance() + amt);
           accountRepository.save(toAccount);


            LocalDateTime ldt = LocalDateTime.now();
           String dateTimeString = DATE_TIME_FORMATTER.format(ldt);
           Transaction transaction = new Transaction(++counter,amt,dateTimeString);

           return transaction;
        }
        return  null;
    }

    public void deleteAccountByAccountNumber(Integer accountNumber) {
        accountRepository.deleteAccountByAccountNumber(accountNumber);
    }

}
