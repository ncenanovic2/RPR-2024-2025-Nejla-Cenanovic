package com.example.lv08_zadatak2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PredmetModel;
import view.PredmetView;

import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        stage.setTitle("Aplikacija za predmete!");

        List<PredmetModel> predmeti = new ArrayList<>();

        PredmetView predmetView = new PredmetView(predmeti);


        Scene scene = new Scene(predmetView.createView(), 400, 250);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}