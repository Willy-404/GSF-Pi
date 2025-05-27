package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;
import model.Perfil;
import util.Alertas;
import util.Validacao;

public class CadastroController {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNomeCompleto;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtTelefone;

    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();
    @FXML
    void onClickCadastrar(ActionEvent event) throws IOException {
        long cnpjnum;
        
        if (validacao.itemisEmpty(txtNomeCompleto.getText(),"Nome")) {
            return;
            
        }else if(validacao.itemisEmpty(txtEmail.getText(),"Email")){
            return;
        }else if(validacao.ValidaFormatEmail(txtEmail.getText())){
            return;
        }else if(validacao.ItemEmailnoSistema(txtEmail.getText(), "faccao", "EmailAcesso", txtEmail.getText())){
            return;
            
        }else if(validacao.itemisEmpty(txtCnpj.getText(),"CNPJ")){
            return;
        } else { 
            String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
            cnpjnum = Long.parseLong(cnpjSemPontos);
        }
        if (validacao.ValidaFormatoCnpj(txtCnpj.getText())) {
            return;
        } else if (validacao.ValidaTamanhoText(18,txtCnpj.getText(), "CNPJ")) {
            return;
        }else if(validacao.ItemCNPJnoSistema(txtCnpj.getText(), "faccao", "CnpjFaccao", cnpjnum)){
            return;
            
        }else if(validacao.itemisEmpty(txtTelefone.getText(),"Telefone")){
            return;
        }else if(validacao.ValidaFormatTell(txtTelefone.getText())){
            return;
        }else if (validacao.ValidaTamanhoText(15,txtTelefone.getText(), "Telefone")) {
            return;
        
            
        }else if(validacao.itemisEmpty(txtSenha.getText(),"Senha")){
            return;
        }

        if (cadastroDeFaccao() != true) {
            alertas.alertaError("Erro ao cadastrar", "Erro ao cadastrar seu Perfil!");
        } else {
            alertas.alertaInformation("Cadastro realizado com sucesso", "Seu perfil foi cadastrado com sucesso!");
            
            LoginController lc = new LoginController();
            lc.trocarLogin(btnCadastrar);
        }
       
    }

    @FXML
    void onClickSair(ActionEvent event) throws IOException {
        LoginController lc = new LoginController();
        if(txtNomeCompleto.getText().isEmpty() && txtEmail.getText().isEmpty() &&  txtCnpj.getText().isEmpty() && 
           txtTelefone.getText().isEmpty() &&  txtSenha.getText().isEmpty()){
           lc.trocarLogin(btnSair);
        }else{
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        lc.trocarLogin(btnSair);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
    }

    //metodo para trocar para a tela de Cadasstro de usuario
    public void trocarCadastro(Hyperlink btnTroca) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de usuario");

        URL url = new File("src/main/java/view/Cadastro.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) btnTroca.getScene().getWindow()).close();
    }

    private boolean cadastroDeFaccao() {
        String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
        long CnpjFaccao = Long.parseLong(cnpjSemPontos);
        String NomeRepreFaccao = txtNomeCompleto.getText();
        String EmailAcesso = txtEmail.getText();
        String Senha = txtSenha.getText();
        String Telefone = txtTelefone.getText();
        Perfil perfil = Perfil.FACCAO;
        Faccao f = new Faccao(CnpjFaccao, NomeRepreFaccao, EmailAcesso, Senha,Telefone,  perfil);
        FaccaoDAO fmetodo = new FaccaoDAO(); 
        return fmetodo.cadastroFaccao(f);

    }

}
