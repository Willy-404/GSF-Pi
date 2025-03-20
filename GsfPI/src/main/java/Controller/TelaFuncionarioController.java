package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaFuncionarioController {

    @FXML
    private Button btnCadastrarFuncionario;

    @FXML
    private Button btnVisualizarFuncionario;
    
      @FXML
    void OnClickCadastrarFuncionario(ActionEvent event) throws IOException {
 Stage cadastroFuncionario = new Stage();
        cadastroFuncionario.setTitle("CadastroFuncionario");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CadastrarFuncionario.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroFuncionario.setScene(cena);
       cadastroFuncionario.show(); 
    }

    @FXML
    void OnClickVisuFuncionario(ActionEvent event) throws IOException {
 Stage visuFuncionario = new Stage();
        visuFuncionario.setTitle("VisualizarFuncionario");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarFuncionario.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       visuFuncionario.setScene(cena);
       visuFuncionario.show();
    }


}