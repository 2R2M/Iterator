module com.example.lab_iterator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.lab_iterator to javafx.fxml;
    exports com.example.lab_iterator;
}