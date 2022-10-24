package org.jana;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{
  public void drive(){
    System.out.println("Woo Im riding man!");
  }
}
