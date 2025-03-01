package com.example.calculatorbackend.controller;

import com.example.calculatorbackend.service.OperationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OperationsControllerUnitTest {

  @Autowired
  OperationsService operationsService;

  @Test
  public void test_add_success(){
    double result = operationsService.add(4,5);
    assert(result==9);
  }

  @Test
  public void test_subtract_success(){
    double result = operationsService.subtract(4,5);
    assert(result==-1);
  }

  @Test
  public void test_multiply_success(){
    double result = operationsService.multiply(4,5);
    assert(result==20);
  }

  @Test
  public void test_divide_success(){
    double result = operationsService.divide(4,5);
    assert(result==.8);
  }

}
