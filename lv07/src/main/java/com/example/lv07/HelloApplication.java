package com.example.lv07;

import controller.OsobaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.OsobaModel;
import view.OsobaView;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        OsobaModel osobaModel = new OsobaModel();
        osobaModel.napuni();


        OsobaView osobaView = new OsobaView();
        osobaView.setUlazniTekst("Novo ime");


        OsobaController osobaController = new OsobaController(osobaModel, osobaView);
        osobaController.azurirajIme(1);


        System.out.println("1) View ispisuje: " + osobaView.getPoruka());
        System.out.println("   Azurirana osoba je: " + osobaController.dajOsobuPoId(1).toString());


        osobaController.dajOsobeIzTxtDatoteke("src/data/osobe.txt");
        System.out.println("2) View ispisuje: " + osobaView.getPoruka());


        osobaController.dajOsobeIzXmlDatoteke("src/data/osobe.xml");
        System.out.println("3) View ispisuje: " + osobaView.getPoruka());
    }

   // public static void main(String[] args) {
      //  launch();
   // }
}