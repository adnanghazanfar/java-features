package com.feature.others;

import java.util.HashMap;

public class HashMapFeature {

  public static void main(String[] args) {
    HashMap<AmbiguousInteger, Integer> map = new HashMap<>();
    // logically equivalent keys
    AmbiguousInteger key1 = new HashMapFeature.AmbiguousInteger(1),
        key2 = new HashMapFeature.AmbiguousInteger(1),
        key3 = new HashMapFeature.AmbiguousInteger(1);
    map.put(key1, 1); // put in value for entry '1'
    map.put(key2, 2); // attempt to override value for entry '1'

    System.out.println(STR."Key: \{key1}, hashcode: \{key1.hashCode()}, value: \{map.get(key1)}");
    System.out.println(STR."Key: \{key2}, hashcode: \{key2.hashCode()}, value: \{map.get(key2)}");
    System.out.println(STR."Key: \{key3}, hashcode: \{key3.hashCode()}, value: \{map.get(key3)}");

    System.out.println(map.keySet().size());
  }

  static class AmbiguousInteger {

    private final int value;

    AmbiguousInteger(int value) {
      this.value = value;
    }

    @Override
    public int hashCode() {
      return value;
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof AmbiguousInteger && value == ((AmbiguousInteger) obj).value;
    }
  }

}
