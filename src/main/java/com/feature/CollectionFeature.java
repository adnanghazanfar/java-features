package com.feature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionFeature {

  public static void main(String[] args) {

    List.of(1,2,3,4,5);

    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.stream().forEach(System.out::println);

    numbers = Collections.unmodifiableList(numbers);
    numbers.add(5);

    numbers.stream().forEach(System.out::println);

  }


}
