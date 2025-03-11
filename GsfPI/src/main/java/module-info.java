module principal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Controller to javafx.fxml;
    exports principal;
}