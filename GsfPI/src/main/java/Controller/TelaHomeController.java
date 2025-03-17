package Controller;

import java.io.IOException;
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
    private Button btnFunconario;

    @FXML
    private Button btnPontoEletronico;

    @FXML
    private Button btnVizualizarLotes;

    @FXML
    private Button btnVizualizarPonto;

    @FXML
    void onClickCadastrarLotes(ActionEvent event)throws IOException{
        
        Stage cadastroLote = new Stage();
        cadastroLote.setTitle("Cadastro de lotes");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CadastroLotes.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroLote.setScene(cena);
       cadastroLote.show(); 
    }

    @FXML
    void onClickPontoEletronico(ActionEvent event)throws IOException{
          
        Stage pontoEletro = new Stage();
        pontoEletro.setTitle("Ponto Eletronico");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PontoEletronico.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       pontoEletro.setScene(cena);
       pontoEletro.show(); 
    }

    @FXML
    void onClickTelaFornecedor(ActionEvent event) throws IOException{
          
        Stage fornecedor = new Stage();
        fornecedor.setTitle("Tela Fornecedor");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaFornecedor.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       fornecedor.setScene(cena);
       fornecedor.show(); 
    }

    @FXML
    void onClickTelaFuncionario(ActionEvent event) throws IOException{
          
        Stage funcionario = new Stage();
        funcionario.setTitle("Tela Funcionario");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaFuncionario.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       funcionario.setScene(cena);
       funcionario.show(); 
    }

    @FXML
    void onClickVizualizarLotes(ActionEvent event) throws IOException{
          
        Stage vizuLotes = new Stage();
        vizuLotes.setTitle("Vizualizar Lotes");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VizualizarLotes.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       vizuLotes.setScene(cena);
       vizuLotes.show(); 
    }

    @FXML
    void onClickVizualizarPonto(ActionEvent event) throws IOException{
          
        Stage vizuPonto = new Stage();
        vizuPonto.setTitle("Vizualizar Pontos");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VizualizarPonto.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       vizuPonto.setScene(cena);
       vizuPonto.show(); 
    }

}
