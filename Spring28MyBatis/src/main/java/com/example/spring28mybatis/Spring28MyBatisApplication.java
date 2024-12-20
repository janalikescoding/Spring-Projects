package com.example.spring28mybatis;

import com.example.spring28mybatis.model.Student;
import com.example.spring28mybatis.repository.StudentMyBatisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring28MyBatisApplication implements CommandLineRunner {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private StudentMyBatisRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(Spring28MyBatisApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    LOGGER.info("Student id 10001 -> {}", repository.findById(10001L));

    LOGGER.info("Inserting -> {}", repository.insertStudent(new Student(10010L, "John", "A1234657")));

    LOGGER.info("Update 10010 -> {}", repository.updateStudent(new Student(10001L, "Name-Updated", "New-Passport")));

    repository.deleteStudent(10002L);

    LOGGER.info("All users -> {}", repository.findAll());
  }
}
