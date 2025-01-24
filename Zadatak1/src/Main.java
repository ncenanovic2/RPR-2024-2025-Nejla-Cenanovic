import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        final int VELICINA_KOLEKCIJE = 100_000_000;

        Random random = new Random();
        int[] kolekcija = IntStream.generate(() -> random.nextInt(1_000_000))
                .limit(VELICINA_KOLEKCIJE)
                .toArray();

        int trazeniBroj = kolekcija[random.nextInt(VELICINA_KOLEKCIJE)];
        System.out.println("Traženi broj: " + trazeniBroj);

        OptionalInt rezultat = IntStream.range(0, kolekcija.length)
                .parallel()
                .filter(i -> kolekcija[i] == trazeniBroj)
                .findFirst();

        if (rezultat.isPresent()) {
            System.out.println("Broj pronađen na poziciji: " + rezultat.getAsInt());
        } else {
            System.out.println("Broj nije pronađen.");
        }
    }
}