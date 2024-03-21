package com.feature;

import java.util.random.RandomGeneratorFactory;

public class PseudoInts {


  public static void main(String[] args) {

    // Algorithm names
    RandomGeneratorFactory.all().map(RandomGeneratorFactory::name).forEach(System.out::println);

    // get random numbers stream.
    RandomGeneratorFactory.of("SecureRandom")
        .create()
        .ints(10, 0,100)
        .forEach(System.out::println);

  }


}
