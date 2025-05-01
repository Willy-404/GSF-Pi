package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;
import model.Perfil;

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

    @FXML
    void onClickCadastrar(ActionEvent event) throws IOException {

        if (txtEmail.getText().isEmpty() || txtNomeCompleto.getText().isEmpty() || txtSenha.getText().isEmpty() || txtCnpj.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campos não preenchidos");
            alerta.setHeaderText("Todos os campos devem ser preenchidos!!!");
            alerta.showAndWait();
            return;
        } else if (!txtCnpj.getText().matches("[z0-9]+")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campo CNPJ");
            alerta.setHeaderText("Campo CNPJ deve conter apenas numeros!!!");
            alerta.showAndWait();
            return;
        } else if (txtCnpj.getText().length() != 14) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CNPJ");
            alerta.setHeaderText("Campo CNPJ inválido!!!");
            alerta.showAndWait();
            return;
        }

        if (cadastroDeFaccao() != true) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro ao cadastrar ");
            alerta.setHeaderText("Erro ao cadastrar seu perfil ");
            alerta.showAndWait();
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cadastro realizado com sucesso");
            alerta.setHeaderText("Seu perfil foi cadastrado com sucesso");
            alerta.showAndWait();
            
            LoginController lc = new LoginController();
            lc.trocarLogin(btnCadastrar);
        }
       
    }

    @FXML
    void onClickSair(ActionEvent event) throws IOException {
        LoginController lc = new LoginController();
        lc.trocarLogin(btnSair);

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
        long CnpjFaccao = Long.parseLong(txtCnpj.getText());
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
