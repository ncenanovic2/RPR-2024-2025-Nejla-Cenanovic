package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Osoba;
import model.OsobaModel;
import model.Uloga;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static model.Osoba.dajOsobuPoId;

public class OsobaController {

    // Model i View komponente
    private OsobaModel model;

    // UI elementi povezani putem FXML-a
    @FXML
    private ListView<Osoba> osobeListView;

    @FXML
    private Button azurirajOsobuButton;

    @FXML
    private Label porukaLabel;

    @FXML
    private Label ucitavanjeLabel;

    @FXML
    private ChoiceBox<Uloga> ulogaChoiceBox;

    @FXML
    private TextField imeField;

    @FXML
    private TextField prezimeField;

    @FXML
    private TextField adresaField;

    @FXML
    private DatePicker datumRodjenjaPicker;

    @FXML
    private TextField maticniBrojField;

    private ObservableList<Osoba> osobeObservableList;
    private Osoba izabranaOsoba;

    public OsobaController(OsobaModel model) {
        this.model = model;
        this.osobeObservableList = FXCollections.observableArrayList();
    }

    @FXML
    public void initialize() {
        // Inicijalizacija modela i baze podataka
        OsobaModel.kreirajTabeluAkoNePostoji();
        OsobaModel.isprazniTabeluOsoba();
        OsobaModel.napuniInicijalnimPodacima();

        ucitavanjeLabel.setText("Podaci učitani");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");

        // Inicijalizacija ChoiceBox-a
        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);

        // Učitavanje podataka iz baze u ListView
        ucitajOsobeIzBaze();
        osobeListView.setItems(osobeObservableList);

        // Dodavanje listener-a za izbor osobe iz ListView-a
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                izabranaOsoba = newValue;
                ispuniPolja(izabranaOsoba);
                porukaLabel.setVisible(false);
            }
        });
    }

    private void ucitajOsobeIzBaze() {
        List<Osoba> osobe = OsobaModel.dajSveOsobe();
        osobeObservableList.setAll(osobe);
    }

    private void ispuniPolja(Osoba osoba) {
        imeField.setText(osoba.getIme());
        prezimeField.setText(osoba.getPrezime());
        adresaField.setText(osoba.getAdresa());
        //datumRodjenjaPicker.setValue(osoba.getDatumRodjenja().toLocalDate());
        maticniBrojField.setText(osoba.getMaticniBroj());
        ulogaChoiceBox.setValue(osoba.getUloga());
    }

    public String azurirajOsobu(Integer id, String novoIme, String novoPrezime, String novaAdresa, Date noviDatumRodjenja, String noviMaticniBroj, Uloga novaUloga)
    {
        Osoba trazenaOsoba = dajOsobuPoId(id);
        if(trazenaOsoba != null) {
            try {
                if (novoIme != null) {
                    trazenaOsoba.setIme(novoIme);
                }
                if (novoPrezime != null) {
                    trazenaOsoba.setPrezime(novoPrezime);
                }
                if (novaAdresa != null) {
                    trazenaOsoba.setAdresa(novaAdresa);
                }
                if (noviDatumRodjenja != null) {
                    trazenaOsoba.setDatumRodjenja(noviDatumRodjenja);
                }
                if (noviMaticniBroj != null) {
                    trazenaOsoba.setMaticniBroj(noviMaticniBroj);
                }
                if (novaUloga != null){
                    trazenaOsoba.setUloga(novaUloga);
                }
                return "Osoba je uspjesno azurirana!";
            }
            catch (IllegalArgumentException e) {
                return e.getMessage();
            }
        }
        return "Osoba nije pronadjena!";
    }

}
