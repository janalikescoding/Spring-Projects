package com.jana;

public class SuperClass {
  String data;

  public SuperClass(String data) {
    throw new IllegalArgumentException("Dont call me - test");
  }
}
