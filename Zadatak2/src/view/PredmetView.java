package view;

import model.Predmet;

import java.util.List;
import java.util.Scanner;

public class PredmetView {
    private Scanner ulaz;

    public PredmetView() {
        ulaz = new Scanner(System.in);
    }

    public void prikaziPredmete(List<Predmet> predmeti) {
        System.out.println("Lista Predmeta:");
        for (Predmet predmet : predmeti) {
            System.out.println(predmet);
        }
    }

    public String unesiNaziv() {
        System.out.print("Unesite naziv predmeta: ");
        return ulaz.nextLine();
    }

    public Double unesiECTS() {
        System.out.print("Unesite ECTS kredite (5.0 - 20.0): ");
        try {
            return Double.parseDouble(ulaz.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Neispravan format ECTS kredita.");
            return null;
        }
    }

    public void prikaziPoruku(String poruka) {
        System.out.println(poruka);
    }
}
