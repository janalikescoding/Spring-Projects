package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ValidateISBNTest {

  @Test
  public void checkAValidISBN(){
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("9389432707");
    assertTrue("first test", result);
    result = validator.checkISBN("0140177396");
    assertTrue("second test", result);

  }

  @Test
  public void checkAnInvalidISBN(){
    ValidateISBN validator = new ValidateISBN();
    boolean result = validator.checkISBN("9389432708");
    assertFalse("expected invalid isbn", result);
  }
}
