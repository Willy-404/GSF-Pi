package Controller;

import dal.ConexaoBD;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.LoginDAO;
import util.Alertas;

public class LoginController {
private Connection conexao;
    private final LoginDAO dao = new LoginDAO();
    
    private Stage stageLogin;
    
    @FXML
    private Hyperlink LinkCadastrar;
 
    @FXML
    private Button btnConfirmar;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtSenha;

    Alertas alertas = new Alertas();
    @FXML
    void onClickTelaHome(ActionEvent event) throws IOException {
        
        
        Faccao r = null;
    try {
        r = processarLogin();
    } catch (SQLException ex) {
                   System.out.println("Erro de conexao com o banco de dados");

    }
        if(r == null){
            alertas.alertaError("Informações incorretas", "Login ou senha inválidos!");
       
        }else{
            TelaHomeController.trocarTelaHome(btnConfirmar, r);
        }
      

    }
    
    
        public Faccao processarLogin() throws IOException, SQLException {
        if (!dao.bancoOnline()) {
            System.out.println("Banco de dados desconectado!");
        } else if (txtEmail.getText() != null && !txtEmail.getText().isEmpty() && txtSenha.getText() != null && !txtSenha.getText().isEmpty()) {
            String Email = txtEmail.getText();
            String Senha = txtSenha.getText();
            
            LoginDAO loginDAO = new LoginDAO();
            Faccao f = loginDAO.autenticar(Email, Senha);
            
            return f;
        } else {
            System.out.println("Verifique as informações!");
        }
    return null;

    }

      public void verificarBanco() {
        this.conexao = ConexaoBD.conectar();

        if (this.conexao != null) {
            System.out.println("Conectou no banco de dados");
        } else {
            System.out.println("Problemas na conexão com o banco de dados");
        }

    }
    public void setStage(Stage stage) {
        this.stageLogin = stage;
    }
    
    
    //Metodo para trocar para a tela de login
    public void trocarLogin(Button btnTroca)throws IOException {
            Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("Login");

            URL url = new File("src/main/java/view/Login.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) btnTroca.getScene().getWindow()).close();
    }
    
      @FXML
    void OnClickLinkCadastro(ActionEvent event) throws IOException {
 Stage cadatrar = new Stage();
        cadatrar.setMaximized(true);
        cadatrar.setTitle("Cadastro");

        URL url = new File("src/main/java/view/Cadastro.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        cadatrar.setScene(cena);
        cadatrar.show();
        
        ((Stage) LinkCadastrar.getScene().getWindow()).close();
    }
     


}
