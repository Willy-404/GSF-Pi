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
       URL url = new File("src/main/java/view/visualizarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root= loader.load();
       Scene cena = new Scene(root);
       visuFornecedor.setScene(cena);
       visuFornecedor.show(); 
    }
    
    @FXML
    void OnClickCadastrarFornecedor(ActionEvent event) throws IOException {
     Stage cadastroFornecedor = new Stage();
        cadastroFornecedor.setTitle("CadastroFornecedor");
        URL url = new File("src/main/java/view/cadastrarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root= loader.load();
        
       Scene cena = new Scene(root);
       cadastroFornecedor.setScene(cena);
       cadastroFornecedor.show(); 
    }

}

