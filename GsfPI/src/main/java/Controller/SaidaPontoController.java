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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;
import model.Fornecedor;
import model.FornecedorDAO;
import model.Perfil;
import model.PerfilDAO;
import util.Alertas;
import util.Validacao;

public class SaidaPontoController {

    @FXML
    private Button btnCancelar;
    
    @FXML
    private TextField txtSenhaVisivel;
    
    @FXML
    private ImageView ImageSenha;

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

    private Stage stage;
    private Perfil f;

    Alertas alertas = new Alertas();
    PerfilDAO pmetodo = new PerfilDAO();
    Validacao validacao = new Validacao();
    
     
    @FXML
    void onClickVerSenha(MouseEvent event) {
        if(txtSenha.isVisible()){
            String senha = txtSenha.getText();
            txtSenhaVisivel.setText(senha);
            txtSenha.setVisible(false);
            txtSenhaVisivel.setVisible(true);
            
        }else{
            String senha = txtSenhaVisivel.getText();
            txtSenha.setText(senha);
            txtSenhaVisivel.setVisible(false);
            txtSenha.setVisible(true);
        }
    }
    
    // Ação do botão cancelar
    @FXML
    void onClickCancelar(ActionEvent event) throws IOException {
        if (lblEmail.isVisible()) {
            LoginController.trocarLogin(btnConfirmar);
        } else {
            PontoEletronicoController.trocarPonto(btnCancelar, f);
        }
        stage.close(); // Fecha o pop-up
    }

    // Ação do botão confirmar
      @FXML
    void onClickConfirmar(ActionEvent event) throws IOException, SQLException {
        if(lblEmail.isVisible()){
                Perfil pT = pmetodo.selecionaPerfilEmail(txtEmail.getText());
                if(pT == null){
                    alertas.alertaError("Email não existe no sistema", "Digite um email válido para realizar a alteração da senha!");
                }else{
                    if(txtSenha.isVisible()){
                        if(txtSenha.getText().equals("")){
                            alertas.alertaError("Digite uma senha", "Digite uma senha válida para realizar a alteração!");
                        }else{
                           pT.setSenha(txtSenha.getText());
                         }
                    }else{
                        if(txtSenhaVisivel.getText().equals("")){
                            alertas.alertaError("Digite uma senha", "Digite uma senha válida para realizar a alteração!");
                        }else{
                           pT.setSenha(txtSenhaVisivel.getText());
                        }
                    }      
                       if(pmetodo.editarPerfilEmail(pT, txtEmail.getText())){
                           alertas.alertaInformation("Recuperação realizada com sucesso", "Senha alterada e pronta para uso!");
                           if(pT.getTipoPerfil().toString().equals("Faccao")){
                               FaccaoDAO fmetodo = new FaccaoDAO();
                               Faccao f = fmetodo.selecionar(pT.getCNPJ());
                               if(txtSenha.isVisible()){
                                  f.setSenha(txtSenha.getText()); 
                               }else{
                                   f.setSenha(txtSenhaVisivel.getText()); 
                               }
                               fmetodo.editarFaccao(f,pT.getCNPJ());
                           }else{
                               FornecedorDAO fmetodo = new FornecedorDAO();
                               Fornecedor f = fmetodo.selecionar(pT.getCNPJ());
                               if(txtSenha.isVisible()){
                                  f.setSenha(txtSenha.getText()); 
                               }else{
                                   f.setSenha(txtSenhaVisivel.getText()); 
                               }
                               fmetodo.editarFornecedor(f,pT.getCNPJ());
                           }
                           LoginController.trocarLogin(btnConfirmar);
                       }    
                    }
        }else{
            if(txtSenha.isVisible()){
                if(txtSenha.getText().equals(f.getSenha())){
                    TelaHomeController.trocarTelaHome(btnConfirmar, f);
                }else{
                    alertas.alertaError("Senha incorreta", "Digite uma senha valida!");  
                } 
            }else{
                if(txtSenhaVisivel.getText().equals(f.getSenha())){
                    TelaHomeController.trocarTelaHome(btnConfirmar, f);
                }else{
                    alertas.alertaError("Senha incorreta", "Digite uma senha valida!");  
                } 
            }
        }
        
    }

    // Método para abrir a janela como pop-up modal
    public static void trocarSaidaPonto(Button button, Perfil f, String caminho) throws IOException {
        Stage popupStage = new Stage();
        popupStage.setTitle("Saída do Ponto");
        popupStage.setResizable(false);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.initOwner(((Stage) button.getScene().getWindow()));

        URL url = new File("src/main/java/view/SaidaPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        SaidaPontoController controller = loader.getController();
        controller.setPerfil(f);
        controller.verificaCaminho(caminho);
        controller.setStage(popupStage);

        Scene scene = new Scene(root);
        popupStage.setScene(scene);
        popupStage.showAndWait(); // Modal: bloqueia interação com janela anterior
        
        ((Stage) button.getScene().getWindow()).close();
    }

    // Setters auxiliares para passar dados para o controller
    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }

    public void setPerfil(Perfil f) {
        this.f = f;
    }

    // Define o comportamento do formulário com base no caminho
    public void verificaCaminho(String c) {
        if (c.equals("Ponto")) {
            lblEmail.setVisible(false);
            txtEmail.setVisible(false);
            lblInfo.setText("Por medidas de segurança, digite sua senha para poder sair!");
        } else {
            lblEmail.setVisible(true);
            txtEmail.setVisible(true);
            lblInfo.setText("Informe o Email e a nova senha!");
        }
    }
}
