package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class VisualizarPontoController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem itemCadFornecedor;

    @FXML
    private MenuItem itemCadFuncionario;

    @FXML
    private MenuItem itemCadLote;

    @FXML
    private MenuItem itemTelaInicial;

    @FXML
    private MenuItem itemVisuFornecedor;

    @FXML
    private MenuItem itemVisuFuncionario;

    @FXML
    private MenuItem itemVisuLote;

    @FXML
    private MenuItem itemVisuPonto;

    @FXML
    private Label lblPonto;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        Stage cadastroFornecedor = new Stage();
        cadastroFornecedor.setMaximized(true);
        cadastroFornecedor.setTitle("Cadastro de Fornecedor");

        URL url = new File("src/main/java/view/CadastrarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadastroFornecedor.setScene(cena);
        cadastroFornecedor.show();
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        Stage cadastroFuncionario = new Stage();
        cadastroFuncionario.setMaximized(true);
        cadastroFuncionario.setTitle("Cadastro de Funcionario");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadastroFuncionario.setScene(cena);
        cadastroFuncionario.show();
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        Stage cadastroLote = new Stage();
        cadastroLote.setMaximized(true);
        cadastroLote.setTitle("Cadastro de lotes");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadastroLote.setScene(cena);
        cadastroLote.show();
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        Stage visuFornecedor = new Stage();
        visuFornecedor.setMaximized(true);
        visuFornecedor.setTitle("VisualizarFornecedor");

        URL url = new File("src/main/java/view/VisualizarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuFornecedor.setScene(cena);
        visuFornecedor.show();
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
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

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Pontos");

        URL url = new File("src/main/java/view/VisualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("home");

        URL url = new File("src/main/java/view/TelaHome.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();
    }

}
