module com.example.lv08_zadatak2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lv08_zadatak2 to javafx.fxml;
    exports com.example.lv08_zadatak2;
}