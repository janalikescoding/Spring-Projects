package org.example.services;

import org.example.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.number.BigDecimalCloseTo.closeTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class AccountServiceTest {

  @Autowired
  private AccountService service;

  @Test
  public void testDeposit() throws Exception {
    BigDecimal start = service.getBalance(1L);
    BigDecimal amount = new BigDecimal("50.0");
    service.deposit(1L, amount);

    BigDecimal finish = start.add(amount);

    assertThat(finish, is(closeTo(service.getBalance(1L), new BigDecimal("0.01"))));
  }

  @Test
  public void testWithdraw() throws Exception {
    BigDecimal start = service.getBalance(1L);
    BigDecimal amount = new BigDecimal("50.0");
    service.withdraw(1L, amount);

    BigDecimal finish = start.subtract(amount);

    assertThat(finish, is(closeTo(service.getBalance(1L), new BigDecimal("0.01"))));
  }

  @Test
  public void testTransfer() throws Exception {
    BigDecimal acc1Start = service.getBalance(1L);
    BigDecimal acc2Start = service.getBalance(2L);

    BigDecimal amount = new BigDecimal("50.0");
    service.transfer(1L, 2L, amount);

    BigDecimal acc1Finish = acc1Start.subtract(amount);
    BigDecimal acc2Finish = acc2Start.add(amount);

    assertThat(acc1Finish, is(closeTo(service.getBalance(1L), new BigDecimal("0.01"))));
    assertThat(acc2Finish, is(closeTo(service.getBalance(2L), new BigDecimal("0.01"))));
  }
}
