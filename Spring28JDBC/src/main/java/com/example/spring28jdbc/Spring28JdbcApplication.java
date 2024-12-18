package com.example.spring28jdbc;

import com.example.spring28jdbc.model.Student;
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
    //JDBC
    //logger.info("Student Name is: " + repository.findById(10001L).getName());

    //logger.info("Here are all the students: -> {}", repository.findAll());

//    logger.info("Here is the new student id -> {}", repository.insert(10010L, "John", "C1234567"));
//    logger.info("Here is the updated info for student -> {}", repository.update(10010L, "John", "D1234567"));
//    logger.info("Here are all the students -> {}", repository.delete(10010L));

    //JPA
    logger.info("Student id 10001 -> {}", repository.findById(10001L));
    logger.info("Here are all the users -> {}", repository.findAll());
    logger.info("Insert -> {}", repository.save(new Student("John", "A1234567")));
    logger.info("Update 10001 -> {}", repository.save(new Student(10001L, "Name updated", "New passport number")));
    repository.deleteById(10002L);
    logger.info("Here are all the users -> {}", repository.findAll());
  }
}
