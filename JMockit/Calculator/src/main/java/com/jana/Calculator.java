package com.jana;

public class Calculator {

  public String mockTest;
//  private String mockPrivate;
//  public final String mockFinal = "final value";
//  int a;
//  int b;
//  String mockString = "StringMock";

  public String getUserOperation(){
    return UserConstants.getOperation();
  }

public void Calculator(){
    this.mockTest = "Real";
}

//  public Calculator(int a, int b) {
//    super();
//    this.a = a;
//    this.b = b;
//  }

  public int performMath(String operation, int k, int m){
    int retVal = 0;
    //Switch Case
//    final String op = getUserOperation();
//    switch (operation){
//      case op:
//        retVal = new Addition(k,m).add();
//        break;
//      case "subtract":
//        retVal = new Subtraction(k, m).subtract();
//        break;
//      case "multiply":
//        retVal = new Multiplication(k,m).multiply();
//        break;
//      default:
//      case "divide":
//        retVal = new Division(k, m).divide();
//        break;
//    }

    if(operation.equalsIgnoreCase(getUserOperation())){
      retVal = new Addition(k,m).add();
    } else if (operation.equalsIgnoreCase(getUserOperation())) {
      retVal = new Subtraction(k, m).subtract();
    } else if (operation.equalsIgnoreCase(getUserOperation())) {
      retVal = new Multiplication(k,m).multiply();
    } else {
      retVal = new Division(k, m).divide();
    }
    return retVal;
  }
}
