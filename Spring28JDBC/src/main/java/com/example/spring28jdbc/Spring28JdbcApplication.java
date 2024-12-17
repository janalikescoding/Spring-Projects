package com.example.spring28jdbc;

import com.example.spring28jdbc.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring28JdbcApplication implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(Spring28JdbcApplication.class);

  @Autowired
  StudentRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Spring28JdbcApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception{
    //logger.info("Student Name is: " + repository.findById(10001L).getName());

    //logger.info("Here are all the students: -> {}", repository.findAll());

    logger.info("Here is the new student id -> {}", repository.insert(10010L, "John", "C1234567"));
    logger.info("Here is the updated info for student -> {}", repository.update(10010L, "John", "D1234567"));
    logger.info("Here are all the students -> {}", repository.delete(10010L));
  }
}
