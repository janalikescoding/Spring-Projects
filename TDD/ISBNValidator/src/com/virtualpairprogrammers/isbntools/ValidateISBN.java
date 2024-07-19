package com.virtualpairprogrammers.isbntools;

public class ValidateISBN {
  public boolean checkISBN(String isbn) {
    Long isbnL = Long.decode(isbn);
    int total = 0;

    for(int i = 10; i > 0; i --){
      total += isbnL[10-i]
    }

}
