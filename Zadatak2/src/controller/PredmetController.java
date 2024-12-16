package controller;

import model.Predmet;
import view.PredmetView;

import java.util.ArrayList;
import java.util.List;

public class PredmetController {
    private List<Predmet> predmeti;
    private PredmetView view;

    public PredmetController(PredmetView view) {
        this.view = view;
        this.predmeti = new ArrayList<>();
    }

    public void dodajPredmet() {
        String naziv = view.unesiNaziv();
        Double ECTS = view.unesiECTS();

        if (naziv == null || ECTS == null) {
            view.prikaziPoruku("Neispravni podaci. Pokušajte ponovo.");
            return;
        }

        try {
            Predmet predmet = new Predmet(naziv, ECTS);
            predmeti.add(predmet);
            view.prikaziPoruku("Predmet uspješno dodan.");
        } catch (IllegalArgumentException e) {
            view.prikaziPoruku("Greška: " + e.getMessage());
        }
    }

    public void prikaziSvePredmete() {
        view.prikaziPredmete(predmeti);
    }

    public void ucitajPredmeteIzXml(String putanjaDoDatoteke) {
        try {
            List<Predmet> ucitaniPredmeti = Predmet.ucitajPredmeteIzXmlDatoteke(putanjaDoDatoteke);
            predmeti.addAll(ucitaniPredmeti);
            view.prikaziPoruku("Predmeti uspješno učitani iz XML datoteke.");
        } catch (Exception e) {
            view.prikaziPoruku("Greška prilikom učitavanja predmeta: " + e.getMessage());
        }
    }
}