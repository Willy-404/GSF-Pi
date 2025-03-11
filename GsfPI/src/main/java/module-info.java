module com.mycompany.gsfpi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens Principal to javafx.fxml;
    exports Principal;
}
