package org.jana;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{

  @Autowired
  private Tyre tyre;

  public Tyre getTyre() {
    return tyre;
  }

  public void setTyre(Tyre tyre) {
    this.tyre = tyre;
  }

  public void drive() {
    System.out.println("Car is running... Why are you running?, or rather - How are you running?");
    System.out.println("That was a long message");
    System.out.println(tyre);
  }
}
