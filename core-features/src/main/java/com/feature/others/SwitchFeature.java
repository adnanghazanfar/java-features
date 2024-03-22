package com.feature.others;

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

  static String asStringValue(Object anyValue) {
    return switch (anyValue) {
      case String str -> str;
      case null, default ->     "null";
    };
  }
}
