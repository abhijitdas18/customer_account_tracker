package com.java.abhijitdas.foundation.bank.repository;

import com.java.abhijitdas.foundation.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountRepository  extends JpaRepository<Account, Integer> {
    @Modifying
    @Query(value = "DELETE from bank.account acc where acc.account_number = ?1", nativeQuery = true)
    public void deleteAccountByAccountNumber(Integer accountNumber);
}
