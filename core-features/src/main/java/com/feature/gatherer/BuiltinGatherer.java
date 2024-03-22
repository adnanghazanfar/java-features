import java.util.stream.Gatherers;
import java.util.stream.IntStream;

void main() {
  System.out.println("FOLD: " + IntStream.rangeClosed(0, 9)
      .boxed()
      .gather(Gatherers.fold(() -> "", (s, i) -> s + i))
      .toList());

  System.out.println("SCAN: " + IntStream.rangeClosed(0, 9)
      .boxed()
      .gather(Gatherers.scan(() -> "", (s, i) -> s + i))
      .toList());

  System.out.println("WINDOW FIXED: " + IntStream.rangeClosed(0, 9)
      .boxed()
      .gather(Gatherers.windowFixed(2))
      .toList());

  System.out.println("WINDOW SLIDING: " +IntStream.rangeClosed(0, 9)
      .boxed()
      .gather(Gatherers.windowSliding(2))
      .toList());
}