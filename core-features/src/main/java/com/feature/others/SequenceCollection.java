package com.feature.others;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class SequenceCollection {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>(List.of("1", "2", "3"));

    list.addFirst("0");
    list.addLast("4");
    System.out.println(list.getFirst());
    System.out.println(list.getLast());

    list.removeFirst();
    list.removeLast();
    System.out.println(list);

    System.out.println(list.reversed());

  }




}
