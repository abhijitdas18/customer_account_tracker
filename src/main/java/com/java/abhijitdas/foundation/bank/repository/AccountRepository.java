package com.java.abhijitdas.foundation.bank.repository;

import com.java.abhijitdas.foundation.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AccountRepository  extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT * from bank.account acc where acc.account_number = ?1", nativeQuery = true)
    public Optional<Account> findAccountByNumber(Integer accountNumber);

    @Modifying
    @Query(value = "DELETE from bank.account acc where acc.account_number = ?1", nativeQuery = true)
    public void deleteAccountByAccountNumber(Integer accountNumber);

    @Query(value = "SELECT * from BANK.ACCOUNT acc WHERE acc.fk_customer_id = ?1", nativeQuery = true)
    public List<Account> findAccountsByCustomerId(Integer customerId);
}
