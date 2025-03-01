package com.example.calculatorbackend.service;

import com.example.calculatorbackend.exception.IncorrectOperationException;
import org.springframework.stereotype.Service;

@Service
public class OperationsService {
  public double add(double a, double b) {
    return a + b;
  }

  public double subtract(double a, double b) {
    return a - b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }
  public double divide(double a, double b) {
    if(b == 0){
      throw new IncorrectOperationException("Denominator cannot be ZERO");
    }
    return a / b;
  }
}
