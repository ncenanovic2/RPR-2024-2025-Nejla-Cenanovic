
import controller.PredmetController;
import view.PredmetView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PredmetView view = new PredmetView();
        PredmetController controller = new PredmetController(view);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Dodaj novi predmet");
            System.out.println("2. Prikazi sve predmete");
            System.out.println("3. Ucitaj predmete iz XML datoteke");
            System.out.println("4. Izlaz");
            System.out.print("Izaberite opciju: ");

            String izbor = scanner.nextLine();

            switch (izbor) {
                case "1":
                    controller.dodajPredmet();
                    break;
                case "2":
                    controller.prikaziSvePredmete();
                    break;
                case "3":
                    System.out.print("Unesite putanju do XML datoteke: ");
                    String putanja = scanner.nextLine();
                    controller.ucitajPredmeteIzXml(putanja);
                    break;
                case "4":
                    System.out.println("Izlaz iz aplikacije.");
                    System.exit(0);
                default:
                    System.out.println("Pogrešna opcija. Pokušajte ponovo.");
            }
        }
    }
}