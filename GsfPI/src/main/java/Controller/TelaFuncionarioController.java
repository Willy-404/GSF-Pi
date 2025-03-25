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
import javafx.stage.Stage;

public class TelaFuncionarioController {

    @FXML
    private Button btnCadastrarFuncionario;

    @FXML
    private Button btnVisualizarFuncionario;

    @FXML
    void OnClickCadastrarFuncionario(ActionEvent event) throws IOException {
        Stage cadastroFuncionario = new Stage();
        cadastroFuncionario.setMaximized(true);
        cadastroFuncionario.setTitle("CadastroFuncionario");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadastroFuncionario.setScene(cena);
        cadastroFuncionario.show();
    }

    @FXML
    void OnClickVisuFuncionario(ActionEvent event) throws IOException {
        Stage visuFuncionario = new Stage();
        visuFuncionario.setMaximized(true);
        visuFuncionario.setTitle("VisualizarFuncionario");

        URL url = new File("src/main/java/view/VisualizarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuFuncionario.setScene(cena);
        visuFuncionario.show();
    }

}
