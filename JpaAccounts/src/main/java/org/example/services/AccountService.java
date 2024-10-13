package org.example.services;

import org.example.entities.Account;
import org.example.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
//@Profile("test")
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public BigDecimal getBalance(Long id) {
    //return accountRepository.getAccount(id).getBalance();
    return accountRepository.findById(id).get().getBalance();
  }

  public BigDecimal deposit(Long id, BigDecimal amount){
//    Account account = accountRepository.getAccount(id);
    Account account = accountRepository.findById(id).get();
    BigDecimal newBalance = account.getBalance().add(amount);
    account.setBalance(newBalance);
//    accountRepository.updateAccount(account);
    accountRepository.save(account);
    return newBalance;
  }

  public BigDecimal withdraw(Long id, BigDecimal amount){
    return deposit(id, amount.negate());
  }

  public void transfer(Long fromId, Long toId, BigDecimal amount) {
    withdraw(fromId, amount);
    deposit(toId, amount);
  }

}
