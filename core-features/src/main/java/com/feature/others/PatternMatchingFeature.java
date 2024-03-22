package com.feature.others;

public class PatternMatchingFeature {

  private static String process(Object data) {
    return switch(data) {
      case Integer i when i > 7 -> "It is a number and greater than 7";
      case Integer _ -> "It is a number";
      case null -> "It is null";
      case SealedFeature sealedFeature -> "It is a sealedFeature";
      case RecordFeature.Human(String name, _, _) -> STR."It is a human \{name}";
      default -> "unknown";
    };
  }

  public static void main(String[] args) {
    System.out.println(process(null));
    System.out.println(process(new SealedFeature()));
    System.out.println(process(new RecordFeature.Human("AG", 2, "SWE")));
    System.out.println(process(5));
    System.out.println(process(50));
    System.out.println(process("ABC"));
  }

}
