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
import javafx.stage.Stage;
import model.Faccao;
import util.Alertas;

public class SaidaPontoController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void onClickCancelar(ActionEvent event) throws IOException {
        PontoEletronicoController.trocarPonto(btnCancelar, f);
    }
    
    Alertas alertas = new Alertas();
    
    @FXML
    void onClickConfirmar(ActionEvent event) throws IOException {
        if(txtSenha.getText() == f.getSenha()){
            TelaHomeController.trocarTelaHome(btnConfirmar, f);
        }else{
            alertas.alertaError("Senha incorreta", "Digite uma senha valida!");  
        }
    }
    
    public static void trocarSaidaPonto(Button button, Faccao f)throws IOException {
        Stage ponto = new Stage();
        //Como deixar sem poder alterar tamanho? Será que da pra transformar em pop-up, ai quando confirmar e der certo fechar essa e a tela PontoEletronico


        URL url = new File("src/main/java/view/SaidaPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        SaidaPontoController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(ponto);

        Scene cena = new Scene(root);
        ponto.setScene(cena);
        ponto.show();
        
        ((Stage) button.getScene().getWindow()).close();
    }
    
     
    private Stage stage;
    
    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }
    
    Faccao f;
    public void setFaccao(Faccao f) {
        this.f = f; 
    }
}
