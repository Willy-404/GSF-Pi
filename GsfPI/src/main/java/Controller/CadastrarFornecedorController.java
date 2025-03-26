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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarFornecedorController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnCadastrarFornecedor;

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
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtInscricaoEstadual;

    @FXML
    private TextField txtNome;

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
        
        ((Stage) MenuBar.getScene().getWindow()).close();
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
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        Stage cadastroLote = new Stage();
        cadastroLote.setMaximized(true);
        cadastroLote.setTitle("Cadastro de lotes");
        URL url = new File("src/main/java/view/cadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene cena = new Scene(root);
        cadastroLote.setScene(cena);
        cadastroLote.show();
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        Stage visuFornecedor = new Stage();
        visuFornecedor.setMaximized(true);
        visuFornecedor.setTitle("VisualizarFornecedor");
        URL url = new File("src/main/java/view/visualizarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene cena = new Scene(root);
        visuFornecedor.setScene(cena);
        visuFornecedor.show();
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
        Stage visuFuncionario = new Stage();
        visuFuncionario.setMaximized(true);
        visuFuncionario.setTitle("VisualizarFuncionario");
        URL url = new File("src/main/java/view/visualizarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuFuncionario.setScene(cena);
        visuFuncionario.show();
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");
        URL url = new File("src/main/java/view/visualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Pontos");

        URL url = new File("src/main/java/view/visualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("home");

        URL url = new File("src/main/java/view/telaHome.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();
        
        ((Stage) MenuBar.getScene().getWindow()).close();
    }

}
