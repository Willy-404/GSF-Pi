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

public class LoginController {

    private Stage stageLogin;

    @FXML
    private Button btnConfirmar;

    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void onClickTelaHome(ActionEvent event) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("home");

        URL url = new File("src/main/java/view/TelaHome.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();
        
        ((Stage) btnConfirmar.getScene().getWindow()).close();

    }

    @FXML
    void onClickTelaCadastro(ActionEvent event) throws IOException {

        Stage cadastro = new Stage();
        cadastro.setMaximized(true);

        cadastro.setTitle("Cadastro de Usuario");

        URL url = new File("src/main/java/view/cadastro.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadastro.setScene(cena);
        cadastro.show();
        
        ((Stage) btnCadastrar.getScene().getWindow()).close();
    }

    public void setStage(Stage stage) {
        this.stageLogin = stage;
    }

}
