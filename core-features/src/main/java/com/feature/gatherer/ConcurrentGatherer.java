import java.util.concurrent.TimeUnit;
import java.util.stream.Gatherers;
import java.util.stream.IntStream;

void main() {
  long started = System.currentTimeMillis();
  IntStream.rangeClosed(1, 100)
      .boxed()
      .gather(Gatherers.mapConcurrent(50, this::getSquare))
      .forEach(System.out::println);
  long ended = System.currentTimeMillis();
  System.out.println("Execution time: " + (ended - started)/1000);
}

int getSquare(int number) {
  try {
    TimeUnit.SECONDS.sleep(1);
  } catch (InterruptedException e) {
    throw new RuntimeException(e);
  }
  return number * number;
}
