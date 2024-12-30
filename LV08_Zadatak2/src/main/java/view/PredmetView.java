package view;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.PredmetModel;

import java.util.List;

public class PredmetView {
    private TextField nazivField;
    private TextField ECTSField;
    private Label errorLabel;
    private final List<PredmetModel> predmeti;

    public PredmetView(List<PredmetModel> predmeti) {
        this.predmeti = predmeti;
    }

    public VBox createView() {
        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 10;");

        HBox nazivBox = new HBox(10);
        Label nazivLabel = new Label("Naziv predmeta:");
        nazivField = new TextField();
        nazivBox.getChildren().addAll(nazivLabel, nazivField);

        HBox ECTSBox = new HBox(10);
        Label ECTSLabel = new Label("ECTS bodovi:");
        ECTSField = new TextField();
        ECTSBox.getChildren().addAll(ECTSLabel, ECTSField);

        errorLabel = new Label();
        errorLabel.setTextFill(Color.RED);

        Button addButton = new Button("Dodaj predmet");
        addButton.setOnAction(e -> handleAddButton());

        root.getChildren().addAll(nazivBox, ECTSBox, addButton, errorLabel);

        return root;
    }

    private void handleAddButton() {
        String naziv = nazivField.getText();
        try {
            Double ECTS = Double.parseDouble(ECTSField.getText());
            PredmetModel predmet = new PredmetModel(naziv, ECTS);
            predmeti.add(predmet);
            errorLabel.setText("Predmet uspješno dodan!");
            errorLabel.setTextFill(Color.GREEN);
            nazivField.clear();
            ECTSField.clear();

            System.out.println("Lista predmeta:");
            predmeti.forEach(p -> System.out.println("Naziv: " + p.getNaziv() + ", ECTS: " + p.getECTS()));
        } catch (NumberFormatException ex) {
            errorLabel.setText("ECTS mora biti broj.");
            errorLabel.setTextFill(Color.RED);
        } catch (IllegalArgumentException ex) {
            errorLabel.setText(ex.getMessage());
            errorLabel.setTextFill(Color.RED);
        }
    }
}