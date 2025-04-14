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
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class TelaHomeController {

    @FXML
    private Button btnCadastrarLote;

    @FXML
    private Button btnFornecedor;

    @FXML
    private Button btnFuncionario;
    
    @FXML
    private Button btnPerfil;

    @FXML
    private Button btnPontoEletronico;

    @FXML
    private Button btnVisualizarLotes;

    @FXML
    private Button btnVisualizarPonto;

    @FXML
    void onClickCadastrarLotes(ActionEvent event) throws IOException {

        Stage cadastroLote = new Stage();
        cadastroLote.setMaximized(true);
        cadastroLote.setTitle("Cadastro de lotes");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadastroLote.setScene(cena);
        cadastroLote.show();
        
        ((Stage) btnCadastrarLote.getScene().getWindow()).close();
    }

    @FXML
    void onClickPontoEletronico(ActionEvent event) throws IOException {

        Stage pontoEletro = new Stage();
        pontoEletro.setMaximized(true);
        pontoEletro.setTitle("Ponto Eletronico");

        URL url = new File("src/main/java/view/PontoEletronico.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        pontoEletro.setScene(cena);
        pontoEletro.show();
        
        ((Stage) btnPontoEletronico.getScene().getWindow()).close();
    }

    @FXML
    void onClickTelaFornecedor(ActionEvent event) throws IOException {

        Stage fornecedor = new Stage();
        fornecedor.setMaximized(true);
        fornecedor.setTitle("Tela Fornecedor");

        URL url = new File("src/main/java/view/TelaFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        fornecedor.setScene(cena);
        fornecedor.show();
        
        ((Stage) btnFornecedor.getScene().getWindow()).close();
    }

    @FXML
    void onClickTelaFuncionario(ActionEvent event) throws IOException {

        Stage funcionario = new Stage();
        funcionario.setMaximized(true);
        funcionario.setTitle("Tela Funcionario");

        URL url = new File("src/main/java/view/TelaFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        funcionario.setScene(cena);
        funcionario.show();
        
        ((Stage) btnFuncionario.getScene().getWindow()).close();
    }

    @FXML
    void onClickVisualizarLotes(ActionEvent event) throws IOException {

        Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();
        
        ((Stage) btnVisualizarLotes.getScene().getWindow()).close();
    }

    @FXML
    void onClickVisualizarPonto(ActionEvent event) throws IOException {

        Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Pontos");

        URL url = new File("src/main/java/view/VisualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
        
        ((Stage) btnVisualizarPonto.getScene().getWindow()).close();
    }
    @FXML
    void onClickVisualizarPerfil(ActionEvent event) throws IOException {
Stage visuPerfil = new Stage();
        visuPerfil.setMaximized(true);
        visuPerfil.setTitle("Visualizar Perfil");

        URL url = new File("src/main/java/view/VisualizarPerfil.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuPerfil.setScene(cena);
        visuPerfil.show();
        
    }
    
    @FXML
public void initialize() {
    BotaoComEfeito.aplicarEfeito(btnPerfil);
}
    
    //metodo para trocar a tela pro home
    public void trocarTelaHome(Button btnTroca)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("home");

            URL url = new File("src/main/java/view/TelaHome.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) btnTroca.getScene().getWindow()).close();
    }
    //metodo para trocar a tela pro home usando menubar como parametro
     public void trocarTelaHome(MenuBar menubar)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("home");

            URL url = new File("src/main/java/view/TelaHome.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) menubar.getScene().getWindow()).close();
    }

}
