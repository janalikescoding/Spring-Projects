package com.jana;

import mockit.Capturing;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Tested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class CalculatorTest {

  @Tested
  Calculator calculator;

  //MODIFY CALCULATOR CLASS DECLARATIONS/METHODS ACCORDINGLY WHILE TESTING

  //STATIC BLOCK TEST
  @Test
  @DisplayName("Static Operation")
  void staticTest() {
    new MockUp<UserConstants>() {
      @Mock
      public String getOperation() {
        return "sub";
      }
    };
    String retVal = calculator.getUserOperation();
    assertTrue(retVal.equals("sub"));
  }

//  @Test
//  @DisplayName("Addition Operation")
//  void additionTest() {
//    //PARAM CONST TEST
//    new MockUp<Calculator>() {
//      @Mock
//      public void $init(int a, int b) {
//
//      }
//    };
//    Calculator calculator = new Calculator(4, 5);
//    int retVal = calculator.performMath("add", 4, 5);
//    assertTrue(retVal > 0);
//
//  }

//  @Test
//  @DisplayName("Subtraction Operation")
//  void subtractionTest(){
//    int retVal = calculator.performMath("subtract", 4, 5);
//    assertFalse(retVal > 0);
//  }
//
//  @Test
//  @DisplayName("Multiplication Operation")
//  void multiplicationTest(){
//    int retVal = calculator.performMath("multiply",4,5);
//    assertTrue(retVal > 0);
//  }
//
//  @Test
//  @DisplayName("Division Operation")
//  void divisionTest(){
//    int retVal = calculator.performMath("divide",4,5);
//    assertFalse(retVal > 1);
//  }
}
