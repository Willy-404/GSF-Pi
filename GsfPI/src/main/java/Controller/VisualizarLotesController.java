package Controller;

import java.io.IOException;
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

public class VisualizarLotesController {

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
    private Label lblLotes;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

  @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        Stage cadastroFornecedor = new Stage();
        cadastroFornecedor.setTitle("Cadastro de Fornecedor");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CadastrarFornecedor.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroFornecedor.setScene(cena);
       cadastroFornecedor.show(); 
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
         Stage cadastroFuncionario = new Stage();
        cadastroFuncionario.setTitle("Cadastro de Funcionario");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CadastrarFuncionario.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroFuncionario.setScene(cena);
       cadastroFuncionario.show(); 
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
         Stage cadastroLote = new Stage();
        cadastroLote.setTitle("Cadastro de lotes");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CadastroLotes.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroLote.setScene(cena);
       cadastroLote.show(); 
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
 Stage visuFornecedor = new Stage();
        visuFornecedor.setTitle("VisualizarFornecedor");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarFornecedor.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       visuFornecedor.setScene(cena);
       visuFornecedor.show(); 
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
Stage visuFuncionario = new Stage();
        visuFuncionario.setTitle("VisualizarFuncionario");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarFuncionario.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       visuFuncionario.setScene(cena);
       visuFuncionario.show();
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
  Stage visuLotes = new Stage();
        visuLotes.setTitle("Visualizar Lotes");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarLotes.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       visuLotes.setScene(cena);
       visuLotes.show(); 
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
       Stage visuPonto = new Stage();
        visuPonto.setTitle("Visualizar Pontos");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarPonto.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       visuPonto.setScene(cena);
       visuPonto.show(); 
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
  Stage home = new Stage();
        home.setTitle("home");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaHome.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       home.setScene(cena);
       home.show(); 
    }

}
