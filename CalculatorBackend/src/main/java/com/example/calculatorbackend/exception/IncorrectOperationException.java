package com.example.calculatorbackend.exception;

public class IncorrectOperationException extends RuntimeException{
  private String message = "";

  public IncorrectOperationException() {
  }

  public IncorrectOperationException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }


}
