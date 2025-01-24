package com.example.lv08.controller;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.example.lv08.model.*;

public class OsobaController {
    @FXML
    private Label ucitavanjeLabel;
    @FXML
    private ListView<Osoba> osobeListView;
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
    @FXML
    private ChoiceBox<Uloga> ulogaChoiceBox;
    @FXML
    private Button azurirajOsobuButton;
    @FXML
    private Label porukaLabel;

    private OsobaModel model;

    private ObservableList<Osoba> osobeObservableList = FXCollections.observableArrayList();
    private ObjectProperty<Osoba> izabranaOsoba=new SimpleObjectProperty<>();

    public OsobaController(OsobaModel model) {
        this.model = model;
    }
    private void ucitajOsobeIzBaze() {
        List<Osoba> osobe = OsobaModel.dajSveOsobe();
        osobeObservableList.setAll(osobe);
    }

    @FXML
    public void initialize() {
        OsobaModel.kreirajTabeluAkoNePostoji();
        OsobaModel.isprazniTabeluOsoba();
        OsobaModel.napuniInicijalnimPodacima();

        ucitavanjeLabel.setText("Ucitani podaci");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");
        azurirajOsobuButton.setText("Azuriraj");
        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);

        ucitajOsobeIzBaze();

        osobeListView.setItems(osobeObservableList);

        //operacija kad se klikne dugme
        //moglo se komotno i bez eventhandlera, normalno je koristiti i lambda funkiju
        //event handleri ili event listeneri, isto je
        azurirajOsobuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                azurirajOsobu();
            }});
        //listener dodat kod liste koji se azurira svaki put kad je pritisnuta nova osoba u listi
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            izabranaOsoba.set(newValue);
        });
        //jos jedan listener koji se mijenja svaki put kad je promijenjana izabrana osoba tjts kad se varijabla izabranaOsoba mijenja
        izabranaOsoba.addListener((observable, oldValue, newValue) -> {
            if(oldValue != null) {
                imeField.textProperty().unbindBidirectional(oldValue.imeProperty());
                prezimeField.textProperty().unbindBidirectional(oldValue.prezimeProperty());
                adresaField.textProperty().unbindBidirectional(oldValue.adresaProperty());
                //pokusati ovo nekad kasnije
                //datumRodjenjaPicker.valueProperty().unbindBidirectional(oldValue.datumRodjenjaProperty().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(););
                maticniBrojField.textProperty().unbindBidirectional(oldValue.maticniBrojProperty());
                ulogaChoiceBox.valueProperty().unbindBidirectional(oldValue.ulogaProperty());
            }
            if(newValue != null) {
                imeField.textProperty().bindBidirectional(newValue.imeProperty());
                prezimeField.textProperty().bindBidirectional(newValue.prezimeProperty());
                adresaField.textProperty().bindBidirectional(newValue.adresaProperty());
                maticniBrojField.textProperty().bindBidirectional(newValue.maticniBrojProperty());
                ulogaChoiceBox.valueProperty().bindBidirectional(newValue.ulogaProperty());
            }
        });
    }
    /*
    nepotrebna funkcija ako se koristi povezivanje!
    private void ispuniPolja(Osoba osoba) {
        imeField.setText(osoba.getIme());
        prezimeField.setText(osoba.getPrezime());
        adresaField.setText(osoba.getAdresa());
        datumRodjenjaPicker.setValue(osoba.getDatumRodjenja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        maticniBrojField.setText(osoba.getMaticniBroj());
        ulogaChoiceBox.setValue(osoba.getUloga());
    }

     */
    private void azurirajOsobu() {
        if (izabranaOsoba != null) {
            // procitaj sadrzaj input polja
            String ime = imeField.getText();
            String prezime = prezimeField.getText();
            String adresa = adresaField.getText();
            LocalDate datumRodjenjaLocal = datumRodjenjaPicker.getValue();
            String maticniBroj = maticniBrojField.getText();
            Uloga uloga = ulogaChoiceBox.getValue();
            // validacija polja forme
            if (ime.isEmpty() || prezime.isEmpty() || adresa.isEmpty() || maticniBroj.isEmpty() || datumRodjenjaLocal == null || uloga == null) {
                porukaLabel.setVisible(true);
                porukaLabel.setText("Sva polja moraju biti popunjena!");
                return;
            }
            Date datumRodjenja = Date.from(datumRodjenjaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
            String poruka = model.azurirajOsobu(izabranaOsoba.get().getId(), ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);

            porukaLabel.setVisible(true);
            porukaLabel.setText(poruka);
            ucitajOsobeIzBaze();
            osobeListView.refresh();
        }
    }
    /*
    public Osoba dajOsobuPoId(Integer id) {
        Osoba osoba = model.dajOsobuPoId(id);
        if (osoba == null) {
            view.setPoruka("Osoba nije pronadjena!");
        } else {
            view.setPoruka(osoba.toString());
        }
        return osoba;
    }
    public void azurirajIme(Integer id){
        try {
            model.azurirajOsobu(id, view.getUlazniTekst(), null, null, null, null, null);
            view.setPoruka("Ime je uspjesno azurirano!");
        }
        catch(Exception e){
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    public void obrisiOsobu(Integer id){
            String rezultat=model.obrisiOsobu(id);
            view.setPoruka(rezultat);
    }
    public void dajOsobeIzTxtDatoteke(String file){
        try{
            model.napuniPodatkeIzTxtDatoteke(file);
            ObservableList<Osoba> osobe=model.dajSveOsobe();
            String ispis="";
            for(Osoba x:osobe){
                ispis+=x.toString()+"\n";
            }
            view.setPoruka("Rezultat: "+ispis);
        } catch (Exception e) {
            view.setPoruka("Greska: "+e.getMessage());
        }
    }
    public void dajOsobeIzXmlDatoteke(String file){
        try{
            model.napuniPodatkeIzXmlDatoteke(file);
            ObservableList<Osoba> osobe=model.dajSveOsobe();
            String ispis="";
            for(Osoba x:osobe){
                ispis+=x.toString()+"\n";
            }
            view.setPoruka("Rezultat: "+ispis);
        } catch (Exception e) {
            view.setPoruka("Greska: "+e.getMessage());
        }
    }
*/

}
