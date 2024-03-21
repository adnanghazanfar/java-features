package com.feature;

import java.util.Objects;

public class RecordFeature {

  public static void main(String[] args) {

    // immutable data
    Human human1 = new Human("John", 35, "SWE");
    Human human2 = new Human("John", 35, "SWE");

    System.out.println(human1 == human2);
    System.out.println(human1.equals(human2));

    System.out.println(Human.UNKNOWN_ADDRESS);
  }

  public record Human(String name, int age, String profession) {

    public static String UNKNOWN_ADDRESS = "Unknown";

    public Human {
      Objects.requireNonNull(name);
      Objects.requireNonNull(age);
    }

    public void setName(String newname) {
      System.out.println(name.toUpperCase());
    }

  }

}



