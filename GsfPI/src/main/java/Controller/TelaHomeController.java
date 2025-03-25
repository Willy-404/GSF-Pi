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

public class TelaHomeController {

    @FXML
    private Button btnCadastrarLote;

    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnFuncionario;

    @FXML
    private Button btnPontoEletronico;

    @FXML
    private Button btnVisualizarLotes;

    @FXML
    private Button btnVisualizarPonto;

    @FXML
    void onClickCadastrarLotes(ActionEvent event)throws IOException{
        
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
    void onClickPontoEletronico(ActionEvent event)throws IOException{
          
        Stage pontoEletro = new Stage();
        pontoEletro.setMaximized(true);
        pontoEletro.setTitle("Ponto Eletronico");
        
        URL url = new File("src/main/java/view/PontoEletronico.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
       Scene cena = new Scene(root);
       pontoEletro.setScene(cena);
       pontoEletro.show(); 
    }

    @FXML
    void onClickTelaFornecedor(ActionEvent event) throws IOException{
          
        Stage fornecedor = new Stage();
        fornecedor.setMaximized(true);
        fornecedor.setTitle("Tela Fornecedor");
        
        URL url = new File("src/main/java/view/TelaFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
       Scene cena = new Scene(root);
       fornecedor.setScene(cena);
       fornecedor.show(); 
    }

    @FXML
    void onClickTelaFuncionario(ActionEvent event) throws IOException{
          
        Stage funcionario = new Stage();
        funcionario.setMaximized(true);
        funcionario.setTitle("Tela Funcionario");
        
        URL url = new File("src/main/java/view/TelaFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
       Scene cena = new Scene(root);
       funcionario.setScene(cena);
       funcionario.show(); 
    }

    @FXML
    void onClickVisualizarLotes(ActionEvent event) throws IOException{
          
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
    void onClickVisualizarPonto(ActionEvent event) throws IOException{
          
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

}
