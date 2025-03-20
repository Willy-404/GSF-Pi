package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaFornecedorController {

    @FXML
    private Button btnCadastrarFornecedor;

    @FXML
    private Button btnVisualizarFornecedor; 
    
    @FXML
    void OnClickVisuFornecedor(ActionEvent event) throws IOException {
     Stage visuFornecedor = new Stage();
        visuFornecedor.setTitle("VisualizarFornecedor");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VisualizarFornecedor.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       visuFornecedor.setScene(cena);
       visuFornecedor.show(); 
    }
    
    @FXML
    void OnClickCadastrarFornecedor(ActionEvent event) throws IOException {
     Stage cadastroFornecedor = new Stage();
        cadastroFornecedor.setTitle("CadastroFornecedor");
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CadastrarFornecedor.fxml"));
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroFornecedor.setScene(cena);
       cadastroFornecedor.show(); 
    }

}

