package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNomeCompleto;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void onClickCadastrar(ActionEvent event) throws IOException {

        Stage login = new Stage();
        login.setMaximized(true);
        login.setTitle("Login");
        URL url = new File("src/main/java/view/login.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene cena = new Scene(root);
        login.setScene(cena);
        login.show();
        
        ((Stage) btnCadastrar.getScene().getWindow()).close();
    }

}
