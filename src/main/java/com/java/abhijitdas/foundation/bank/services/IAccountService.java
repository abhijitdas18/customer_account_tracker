package com.java.abhijitdas.foundation.bank.services;

import com.java.abhijitdas.foundation.bank.entity.Account;
import com.java.abhijitdas.foundation.bank.entity.Customer;
import com.java.abhijitdas.foundation.bank.entity.FundTransfer;
import com.java.abhijitdas.foundation.bank.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface IAccountService {

    // This method is expected to receive Account object and
    // creates account and customer details by invoking appropriate DAO
    public Account addAccount(Account account);

    // This method is expected to receive an account number and
    // return the Account details.
    public Account findAccountByNumber(Integer accNumber);


    public void deleteAccountById(Integer accountNumber);


    public Account updateAccountByAccountNumber(Integer accountNumber, Account account);

    // This method is expected to return all Accounts including customer profile
    public List<Account> getAllAccounts();



    // This method is expected to return transfer status like “ID MISATCH” or
    // “INSUFFICIENT FUNDS” or “SUCCESS” only.
    //It iterates through “accounts” to find existence id’s for both payer and
    // beneficiary, if both found and if payer has sufficient funds then updates
    // the balance for both accounts suitably.
    public String transferFunds(int from, int to, double amount);

    // This method is expected to return account details by mapping account number.
    //It iterates through “accounts” to find existence of received account number,
    // if account number found it will return account object (details).
    // Otherwise “null” to be returned.
    public Account getBalanceOf(int accountNumber);

    public List<Account> findAccountsByCustomerId(Integer customerId);

    public Transaction fundTransfer(FundTransfer fundTransfer);
}
