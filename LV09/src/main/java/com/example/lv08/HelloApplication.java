package com.example.lv08;

import com.example.lv08.controller.OsobaController;
import com.example.lv08.controller.PredmetController;
import com.example.lv08.model.OsobaModel;
import com.example.lv08.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    /*

        OsobaModel osobaModel = OsobaModel.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //zasto je ovo ovdje postavljeno a ne u fxml fajlu?
        fxmlLoader.setController(new OsobaController(osobaModel));

        Scene scene = new Scene(fxmlLoader.load(), 300, 700);
        stage.setTitle("Dodaj osobu!");
        stage.setScene(scene);
        stage.show();
*/


        /*
        Scene scene = new Scene(new Button("OK"), 200, 250);
        stage.setTitle("MyJavaFX"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
        Stage sstage = new Stage(); // Create a new stage
        sstage.setTitle("Second Stage"); // Set the stage title
        // Set a scene with a button in the stage
        sstage.setScene(new Scene(new Button("New Stage"), 100, 100));
        sstage.show();

         */

        PredmetModel predmetModel = PredmetModel.getInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("predmet.fxml"));
        fxmlLoader.setController(new PredmetController(predmetModel));

        Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setResizable(false);
        stage.setTitle("Azuriranje fakultetskog predmeta");
        stage.setScene(scene);
        stage.show();




    }
    public static void main(String[] args) {

        launch();
        //Connection connect=Database.connect();

    }

}