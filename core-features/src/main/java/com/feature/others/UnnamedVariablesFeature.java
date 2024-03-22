package com.feature.others;

import java.util.List;

public class UnnamedVariablesFeature {

  public static void main(String[] args) {

    List<String> fruits = List.of("Apple", "Orange", "Banana", "Melon");

    for (String _ : fruits) {
      System.out.println("fruit");
    }

    try {
      int a  = 9 / 0;
    } catch (ArithmeticException _) {
      System.out.println("ArithmeticException");
    }

  }

}
