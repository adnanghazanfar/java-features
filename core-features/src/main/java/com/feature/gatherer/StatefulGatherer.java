import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;

void main(String[] args) {

  var fruits = List.of("apple", "apple", "orange", "banana", "melon", "pineapple");

  System.out.println("****** Distinct.");
  System.out.println(fruits.stream().distinct().toList());

  System.out.println("****** Distinct by length using reduce.");
  System.out.println(
          fruits.stream()
                  .reduce(new LinkedHashSet<String>(), (set, current) -> {
                    if (set.stream().noneMatch(str -> str.length() == current.length())) {
                      set.add(current);
                    }
                    return set;
                  }, (set1, set2) -> {
                    set1.addAll(set2);
                    return set1;
                  }));

  System.out.println("****** Distinct by length using wrapper.");
  System.out.println(fruits.stream()
          .map(DistinctByLength::new) // MAP TO CUSTOM TYPE
          .distinct()                 // PREFORM DISTINCT
          .map(DistinctByLength::str) // MAP BACK TO STRING
          .toList());

  System.out.println("****** Distinct by length using collector.");
  System.out.println(fruits.stream()
          .collect(Collector.of(
                  HashSet::new,
                  (Set<String> groups, String element) -> {
                    if (groups.stream().noneMatch(str -> str.length() == element.length())) {
                      groups.add(element);
                    }
                  },
                  (l, r) -> {
                    l.addAll(r);
                    return l;
                  }
          )));

  System.out.println("****** Distinct by length using gatherer.");
  Integrator<Set<Integer>, String, String> integrator = (state, element, downstream) -> {
    if (!state.contains(element.length())) {
      downstream.push(element);
      state.add(element.length());
    }
    return true;
  };
  System.out.println(fruits.stream().gather(Gatherer.ofSequential(HashSet::new,integrator)).toList());
}

record DistinctByLength(String str) {
  @Override
  public boolean equals(Object obj) {
    return str.length() == ((DistinctByLength)obj).str().length();
  }

  @Override
  public int hashCode() {
    return str == null ? 0 : Integer.hashCode(str.length());
  }
}

