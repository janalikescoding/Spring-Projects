//package org.example.repositories;
//
//import org.example.entities.Account;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.sql.DataSource;
//import java.math.BigDecimal;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
////@Profile("test")
//public class JpaAccountRepository implements AccountRepository{
//
//  //COMMENTED PARTS/UNCOMMENTED PARTS USE THE JDBC (JDBC TEMPLATE) AND THE ENTITY MANAGER PROVIDED BY JPA ALTERNATIVELY
//  private static long nextInt = 4;
////  private JdbcTemplate template;
////
////  @Autowired
////  public JpaAccountRepository(DataSource dataSource){
////    template = new JdbcTemplate(dataSource);
////  }
//
//  @PersistenceContext //Adding this annotation will inject a EntityManager when we need it.
//  private EntityManager entityManager;
//
//  @Override
//  public List<Account> getAccounts() {
////    String sqlText = "select * from account";
////    return template.query(sqlText, new AccountMapper());
//    return entityManager.createQuery("select a from Account a", Account.class).getResultList();
//  }
//
//  @Override
//  public Account getAccount(Long id) {
////    String sqlText = "select * from account where id = ?";
////    return template.queryForObject(sqlText, new AccountMapper(), id);
//    return entityManager.find(Account.class,id);
//  }
//
//  @Override
//  public int getNumberofAccounts() {
////    String sqlText = "select count(*) from account";
////    return template.queryForObject(sqlText, Integer.class);
//    String jpaText = "select count(a.id) from Account a"; // Account, id are case-sensitive. They match to the entity class. Could use either select count(a) or select count(a.id).
//    Long result = (Long) entityManager.createQuery(jpaText).getSingleResult();
//    return result.intValue();
//  }
//
//  @Override
//  public Long createAccount(BigDecimal initialBalance) {
////    String sqlText = "insert into account(id,balance) values(?,?)";
////    Long id = nextInt;
////    int uc = template.update(sqlText, id, initialBalance);
////    //nextInt = id + 1;
////    return (long) uc;
//    Long id = nextInt++;
//    entityManager.persist(new Account(id, initialBalance));
//    return id;
//  }
//
//  @Override
//  public int deleteAccount(Long id) {
////    String sqlText = "delete from account where id=?";
////    return template.update(sqlText, id);
//    entityManager.remove(getAccount(id));
//    return 1;
//  }
//
//  @Override
//  public void updateAccount(Account account) {
////    String sqlText = "update account set balance = ? where id = ?";
////    template.update(sqlText, account.getBalance(), account.getId());
//    entityManager.merge(account);
//  }
//
//  private class AccountMapper implements RowMapper<Account> {
//    @Override
//    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
//      return new Account(resultSet.getLong("id"), resultSet.getBigDecimal("balance"));
//    }
//  }
//}
