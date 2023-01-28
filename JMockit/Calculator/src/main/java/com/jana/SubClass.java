package com.jana;

public class SubClass extends SuperClass{
  String data;

  public SubClass(String data) {
    super(data);
    this.data = data;
  }

  public String getData() {
    return data;
  }
}
