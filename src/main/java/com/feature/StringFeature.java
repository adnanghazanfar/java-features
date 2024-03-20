package com.feature;

public class StringFeature {

  public static void main(String[] args) {
    String name = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    System.out.println(name.indexOf('K', 0, 5)); // -1
    System.out.println(name.indexOf('K', 0, 25)); // 10
  }

}
