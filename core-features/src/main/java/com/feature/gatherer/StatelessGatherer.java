import java.util.stream.Gatherer;
import java.util.stream.Stream;

void main() {

  Gatherer.Integrator<Void, String, String> integrator = (_, element, downstream) -> {
    String upperCase = element.toUpperCase();
    downstream.push(upperCase);
    return true;
  };

  Stream.of("apple", "orange", "banana", "melon", "pineapple")
          .gather(Gatherer.of(integrator))
          .forEach(System.out::println);

}