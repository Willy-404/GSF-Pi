module principal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens Controller to javafx.fxml;
    exports principal;
    exports model;
    
}