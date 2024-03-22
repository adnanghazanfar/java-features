package com.feature.others;

public class RecordFeature {

  public static void main(String[] args) {

    // immutable data
    Human human1 = new Human("John", 35, "SWE");

    System.out.println(recordPatten(human1));
  }

  static String recordPatten(Object object) {
    if (object instanceof Human(String name, int age, String profession)) {
      return name;
    }
    return null;
  }

  public record Human(String name, int age, String profession) { }

}



