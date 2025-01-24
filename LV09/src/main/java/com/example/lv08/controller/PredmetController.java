package com.example.lv08.controller;

import com.example.lv08.model.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;


public class PredmetController {

    private PredmetModel model;
    private ObjectProperty<Predmet> izabraniPredmet=new SimpleObjectProperty<>();
    private ObservableList<Predmet> predmetiObservableList = FXCollections.observableArrayList();

    //nepotrebno
    @FXML
    private Label idLabela;
    @FXML
    private Label nazivLabela;
    @FXML
    private Label ectsLabela;
    @FXML
    private ListView<Predmet> predmetiListView;
    @FXML
    private Button azurirajButton;
    @FXML
    private Label rezultatLabela;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nazivTextField;
    @FXML
    private TextField ectsTextField;

    @FXML
    public void initialize(){
        PredmetModel.kreirajTabeluAkoNePostoji();
        PredmetModel.isprazniTabeluPredmet();
        PredmetModel.napuniInicijalnimPodacima();

        rezultatLabela.setVisible(false);
        //DIREKTNO sam IZ MODELA UZIMALA LISTU
        //UMJESTO DA NAPRAVIM U KONTROLERU POSEBNU OBSERVABE LISTU KOJA JE POVEZANA SA MODELOM
        //NE ZNAM KAKO OVO FUNKCIONISE BEZ TOGA
        //ipak moze funkcionisati bez toga
        //al svakako sam stavila tu listu u controlleru radi reda

        ucitajPredmeteIzBaze();

        predmetiListView.setItems(predmetiObservableList);

        azurirajButton.setOnAction(event->azurirajPredmet());

        predmetiListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue,newValue)->{
            izabraniPredmet.set(newValue);
        });
        izabraniPredmet.addListener((observable, oldValue, newValue)->{
            if(oldValue!=null){
                idTextField.textProperty().unbindBidirectional(oldValue.IDProperty());
                nazivTextField.textProperty().unbindBidirectional(oldValue.nazivProperty());
                ectsTextField.textProperty().unbindBidirectional(oldValue.ECTSProperty());
            }
            if(newValue!=null){
                idTextField.textProperty().bindBidirectional(newValue.IDProperty());
                nazivTextField.textProperty().bindBidirectional(newValue.nazivProperty());
                ectsTextField.textProperty().bindBidirectional(newValue.ECTSProperty());
            }
        });
    }

    private void ucitajPredmeteIzBaze() {
        List<Predmet> predmeti = PredmetModel.dajSvePredmete();
        predmetiObservableList.setAll(predmeti);
    }





    public PredmetController(PredmetModel model){
        this.model=model;
    }

    public PredmetModel getModel() {
        return model;
    }

    public void setModel(PredmetModel model) {
        this.model = model;
    }
    public void azurirajPredmet(){
        if(izabraniPredmet!=null) {
            String id = idTextField.getText();
            String naziv = nazivTextField.getText();
            String bodovi = ectsTextField.getText();
            String poruka= model.azurirajPredmet(id,naziv,bodovi);
            rezultatLabela.setVisible(true);
            rezultatLabela.setText(poruka);
            predmetiListView.refresh();
        }
    }

    /*
    public void azurirajIme(String naziv, String noviNaziv){
        try{
            String porukica=model.azurirajImePredmeta(naziv,noviNaziv);
            //view.setPoruka(porukica);
        }catch (Exception e){
            //view.setPoruka("Greska: "+e.getMessage());
        }
    }
    public void azurirajBodovePredmeta(String naziv, Double broj){
        try{
            String porukica=model.azurirajBodovePredmeta(naziv,broj);
            //view.setPoruka(porukica);
        } catch (Exception e) {
            //view.setPoruka("Greska: "+e.getMessage());
        }
    }
    public void dajBodovePoNazivu(){
        try{
            String naziv=view.getUlazniTekst();
            String poruka=String.valueOf(model.dajBodovePoNazivu(naziv));
            view.setPoruka(poruka);
        } catch (Exception e) {
            view.setPoruka("Greska: "+e.getMessage());
        }
    }
    public void obrisiPredmet(String naziv) {
        try {
            view.setPoruka(model.obrisiPredmet(naziv));
        } catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    public void dajPredmeteIzTxtDokumenta(String file){
        try{
            model.ucitajPredmeteIzTxtDokumenta(file);
            ObservableList<Predmet> predmeti=model.dajSvePredmete();
            String ispis="";
            for(Predmet x: predmeti){
                ispis+=x.toString()+"\n";
            }
            view.setPoruka(ispis);
        } catch (Exception e) {
            view.setPoruka("Greska: " + e.getMessage());
        }
    }
    */
}
