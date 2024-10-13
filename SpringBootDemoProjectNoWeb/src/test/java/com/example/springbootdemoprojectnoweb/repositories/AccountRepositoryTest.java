package com.example.springbootdemoprojectnoweb.repositories;

import com.example.entities.Account;
import com.example.repositories.AccountRepository;
import com.example.springbootdemoprojectnoweb.SpringBootDemoProjectNoWebApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
@ContextConfiguration(classes = SpringBootDemoProjectNoWebApplication.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@EnableJpaRepositories(basePackages = "com.example.repositories")
@Transactional
public class AccountRepositoryTest {
  @Autowired
  private AccountRepository repository;

  @Test
  public void contextLoads(){}

  @Test
  public void testGetAccounts() throws Exception {
    List<Account> accounts = repository.findAll();
    assertThat(accounts.size(),is(3));
  }

  @Test
  public void testGetAccount() throws Exception {
    Account account = repository.findById(1L).get();
    assertThat(account.getId(), is(1L));
    assertThat(new BigDecimal("100.00"), is(closeTo(account.getBalance(), new BigDecimal("0.01"))));
  }

  @Test
  public void testNumberOfAccounts() throws Exception {
    assertThat(repository.count(), is(3L));
  }

  @Test
  public void testCreateAccount() throws Exception {
    Account account = new Account(99L, new BigDecimal("250.00"));
    Account savedAccount = repository.save(account);
    assertThat(savedAccount, is(notNullValue()));
    assertThat(savedAccount.getId(), is(account.getId()));
    assertThat(savedAccount.getBalance(), is(closeTo(new BigDecimal("250.00"), new BigDecimal("0.01"))));
  }

  @Test
  public void testUpdateAccount() throws Exception {
    Account account = repository.findById(1L).get();
    BigDecimal current = account.getBalance();
    BigDecimal amount = new BigDecimal("50.00");
    account.setBalance(current.add(amount));
    repository.save(account);

    Account again = repository.findById(1L).get();
    assertThat(again.getBalance(), is(closeTo(current.add(amount), new BigDecimal("0.01"))));
  }

  @Test
  public void testDeleteAccounts() throws Exception {
    repository.deleteAll();
    assertThat(repository.count(), is(0L));
  }
}
