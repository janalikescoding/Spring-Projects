package org.example.repositories;

import org.example.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

//public interface AccountRepository {
//
//  List<Account> getAccounts();
//
//  int getNumberofAccounts();
//
//  Long createAccount(BigDecimal initialBalance);
//
//  int deleteAccount(Long id);
//
//  void updateAccount(Account account);
//
//  Account getAccount(Long id);
//}

public interface AccountRepository extends JpaRepository<Account,Long> { //First one is the dataType of the object associated with the repository. Second is the type of the primary key.
  List<Account> findAccountsByBalanceGreaterThanEqual(BigDecimal amount);
}
