package com.feature.others;

public class StringFeature {

  private static final String MULTILINE_STRING = """
      Hello "Sir"!
      How are you?
      """;

  public static void main(String[] args) {

    System.out.println("Here is %s and %d".formatted("GOOG", 10));

    System.out.println(STR."Here is \{ 5*5 }");

    System.out.println(MULTILINE_STRING);
    MULTILINE_STRING.lines().forEach(System.out::println);

    var name = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    System.out.println(name.indexOf('K', 0, 5)); // -1
    System.out.println(name.indexOf('K', 0, 25)); // 10
  }

}
