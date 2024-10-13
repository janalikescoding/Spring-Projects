package org.example.repositories;

import org.example.config.AppConfig;
import org.example.entities.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional //Rollback all changes by tests automatically
//@ActiveProfiles("test")
public class JpaAccountRepositoryTest {

  @Autowired
  private AccountRepository repository;

//  @Test
//  public void testGetAccounts() throws Exception {
//    List<Account> accounts = repository.getAccounts();
//    assertThat(accounts.size(),is(3));
//  }
//
//  @Test
//  public void testGetAccount() throws Exception {
//    Account account = repository.getAccount(1L);
//    assertThat(account.getId(), is(1L));
//    assertThat(new BigDecimal("100.00"), is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
//  }
//
//  @Test
//  public void testNumberOfAccounts() throws Exception {
//    int count = repository.getNumberofAccounts();
//    assertThat(count, is(3));
//  }
//
//  @Test
//  public void testCreateAccount() throws Exception {
//    Long id = repository.createAccount(new BigDecimal("250.00"));
//    assertThat(id, is(notNullValue()));
//
//    //Get the latest account and make sure that the balance matches to what was used during creation
//    Account account = repository.getAccount(id);
//    assertThat(account.getId(), is(id));
//    assertThat(account.getBalance(), is(closeTo(new BigDecimal("250.00"), new BigDecimal("0.01"))));
//  }
//
//  @Test
//  public void testUpdateAccount() throws Exception {
//    Account account = repository.getAccount(1L);
//    BigDecimal current = account.getBalance();
//    BigDecimal amount = new BigDecimal("50.00");
//    account.setBalance(current.add(amount));
//    repository.updateAccount(account);
//
//    Account again = repository.getAccount(1L);
//    assertThat(again.getBalance(), is(closeTo(current.add(amount), new BigDecimal("0.01"))));
//  }
//
//  @Test
//  public void testDeleteAccounts() throws Exception {
//    for(Account a: repository.getAccounts()){
//      repository.deleteAccount(a.getId());
//    }
//    assertThat(repository.getNumberofAccounts(), is(0)); //With EntityManager, this test seems to fail because the deleteAccount seems to get rolled back immediately.
//  }
}
