package com.example.retaionaldataaccess;

import com.example.retaionaldataaccess.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class RetaionalDataAccessApplication implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(RetaionalDataAccessApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(RetaionalDataAccessApplication.class, args);
  }

  @Autowired
  JdbcTemplate jdbcTemplate;



  @Override
  public void run(String... args) throws Exception {
    log.info("Creating tables");

    jdbcTemplate.execute("DROP TABLE customers IF EXISTS"); //Looks like the customers table exists for that particular application session, if the app is restarted the table is dropped automatically, and would need to create a new table for the new session
    jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, firstName VARCHAR(255), lastName VARCHAR(255))");

    List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
        .map(name -> name.split(" ")).collect(Collectors.toList());

    splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

    jdbcTemplate.batchUpdate("INSERT INTO customers(firstName, lastName) values(?,?)", splitUpNames);

    log.info("Querying for customer records where first_name = 'Josh':");
    jdbcTemplate.query("SELECT id, firstName, lastName FROM customers WHERE firstName = ?", (rs, rowNum) ->
        new Customer(rs.getLong("id"), rs.getString("firstName"), rs.getString("lastName")), "Josh")
        .forEach(customer -> log.info(customer.toString()));
  }
}
