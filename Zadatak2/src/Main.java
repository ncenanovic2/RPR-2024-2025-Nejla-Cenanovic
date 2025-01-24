import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args)throws InterruptedException {
         int BROJ_NITI = 50;


            final int VELICINA_KOLEKCIJE = 1_000;
            Random random = new Random();
            int[] kolekcija = random.ints(VELICINA_KOLEKCIJE, 0, 1000).toArray();

            System.out.println("Nesortirana kolekcija: " + Arrays.toString(kolekcija));


            AtomicBoolean promjena = new AtomicBoolean(true);


            Thread[] niti = new Thread[BROJ_NITI];
            for (int i = 0; i < BROJ_NITI; i++) {
                niti[i] = new Thread(() -> {
                    while (promjena.get()) {
                        promjena.set(false); // Pretpostavimo da nije bilo promene
                        for (int j = 0; j < kolekcija.length - 1; j++) {
                            synchronized (kolekcija) {
                                if (kolekcija[j] > kolekcija[j + 1]) {
                                    // Zamena elemenata
                                    int temp = kolekcija[j];
                                    kolekcija[j] = kolekcija[j + 1];
                                    kolekcija[j + 1] = temp;
                                    promjena.set(true); // Signaliziramo da je bilo promene
                                }
                            }
                        }
                    }
                });
            }

            for (Thread nit : niti) {
                nit.start();
            }

            for (Thread nit : niti) {
                nit.join();
            }

            System.out.println("Sortirana kolekcija: " + Arrays.toString(kolekcija));
    }
}
