package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;
import model.Fornecedor;
import model.FornecedorDAO;
import model.Perfil;
import model.PerfilDAO;
import util.Alertas;

public class SaidaPontoController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;
    
    @FXML
    private Label lblEmail;

    @FXML
    private Label lblInfo;

    @FXML
    private Label lblSenha;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void onClickCancelar(ActionEvent event) throws IOException {
         if(lblEmail.isVisible()){
            LoginController.trocarLogin(btnConfirmar);
         }else{
            PontoEletronicoController.trocarPonto(btnCancelar, f); 
         }
    }
    
    Alertas alertas = new Alertas();
    PerfilDAO pmetodo = new PerfilDAO();
    
    @FXML
    void onClickConfirmar(ActionEvent event) throws IOException, SQLException {
        if(lblEmail.isVisible()){
            Perfil pT = pmetodo.selecionaPerfilEmail(txtEmail.getText());
            pT.setSenha(txtSenha.getText());
            if(pmetodo.editarPerfilEmail(pT, txtEmail.getText())){
                alertas.alertaInformation("Recuperação realizada com sucesso", "Senha alterada e pronta para uso!");
                if(pT.getTipoPerfil().toString().equals("Faccao")){
                    FaccaoDAO fmetodo = new FaccaoDAO();
                    Faccao f = fmetodo.selecionar(pT.getCNPJ());
                    f.setSenha(txtSenha.getText());
                    fmetodo.editarFaccao(f,pT.getCNPJ());
                }else{
                    FornecedorDAO fmetodo = new FornecedorDAO();
                    Fornecedor f = fmetodo.selecionar(pT.getCNPJ());
                    f.setSenha(txtSenha.getText());
                    fmetodo.editarFornecedor(f,pT.getCNPJ());
                }
                LoginController.trocarLogin(btnConfirmar);
            }
        }else{
            if(txtSenha.getText().equals(f.getSenha())){
                TelaHomeController.trocarTelaHome(btnConfirmar, f);
            }else{
                alertas.alertaError("Senha incorreta", "Digite uma senha valida!");  
            } 
        }
        
    }
    
    public static void trocarSaidaPonto(Button button, Perfil f, String caminho)throws IOException {
        Stage ponto = new Stage();
        //Como deixar sem poder alterar tamanho? Será que da pra transformar em pop-up, ai quando confirmar e der certo fechar essa e a tela PontoEletronico


        URL url = new File("src/main/java/view/SaidaPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        SaidaPontoController thc = loader.getController();
        thc.setPerfil(f);
        thc.verificaCaminho(caminho);
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
    
    Perfil f;
    public void setPerfil(Perfil f) {
        this.f = f; 
    }
    
    public void verificaCaminho(String c){
        if(c.equals("Ponto")){
            lblEmail.setVisible(false);
            txtEmail.setVisible(false);
            lblInfo.setText("Por medidas de segurança, digite sua senha para poder sair!");
        }else{
            lblEmail.setVisible(true);
            txtEmail.setVisible(true);
            lblInfo.setText("Informe o Email e a nova senha!");
        }
    }
}
