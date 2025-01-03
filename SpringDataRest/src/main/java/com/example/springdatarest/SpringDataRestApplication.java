package com.example.springdatarest;

import com.example.springdatarest.repository.StudentsRepositoryRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestApplication {

  @Autowired
  StudentsRepositoryRest repository;

  public static void main(String[] args) {
    SpringApplication.run(SpringDataRestApplication.class, args);
  }

}
