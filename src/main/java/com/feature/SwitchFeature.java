package com.feature;

public class SwitchFeature {

  enum EmployeeType {A, B, C}

  public static void main(String[] args) {
    EmployeeType em = EmployeeType.A;
    switch (em){
      case A, B -> System.out.println("A or B");
      default -> System.out.println("Other");
    }
  }

}
