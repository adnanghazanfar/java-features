package com.feature;

import java.util.Objects;

public class RecordFeature {

  public static void main(String[] args) {
    System.out.println(new Human(null, 35, "SWE"));
    System.out.println(Human.UNKNOWN_ADDRESS);
}

  record Human (String name, int age, String profession) {
    public static String UNKNOWN_ADDRESS = "Unknown";

    public Human {
      Objects.requireNonNull(name);
      Objects.requireNonNull(age);
    }

  }

}

