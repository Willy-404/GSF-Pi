package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController {

    @FXML
    private Button Btnlogin;

    @FXML
    private Button btnircadastro;

    @FXML
    private TextField email;

    @FXML
    private TextField senha;

    @FXML
    void onClickTelaHome(ActionEvent event) throws IOException{
        Stage home = new Stage();
        home.setTitle("home");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TelaHome.fxml"));
        Parent root= loader.load();
        
        
       Scene cena = new Scene(root);
       home.setScene(cena);
       home.show(); 
     
 
    }

    @FXML
    void onClickTelaCadastro(ActionEvent event) throws IOException {
        
         Stage cadastro = new Stage();
        cadastro.setTitle("home");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Cadastro.fxml"));
        Parent root= loader.load();
        
        
       Scene cena = new Scene(root);
       cadastro.setScene(cena);
       cadastro.show(); 
    }

}
