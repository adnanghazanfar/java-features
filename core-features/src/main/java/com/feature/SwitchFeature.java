package com.feature;

public class SwitchFeature {

  enum EmployeeType {A, B, C}

  public static void main(String[] args) {
    var employeeType = EmployeeType.A;
    String result = switch (employeeType){
      case A, B -> {
        yield "A or B";
      }
      default -> "Other";
    };
    System.out.println(result);
  }

}
