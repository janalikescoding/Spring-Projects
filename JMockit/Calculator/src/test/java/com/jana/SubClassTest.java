package com.jana;

import mockit.Capturing;
import mockit.Injectable;

import mockit.Mocked;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubClassTest {


  @Injectable
  SubClass sub;

//  @Mocked
//  SuperClass super;

  @Test
  public void test(){
    sub = new SubClass("data");
    assertEquals(sub.getData(), "data");
  }
}
