package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import model.FaccaoDAO;
import model.Lotes;
import model.LotesDAO;

public class VisualizarLotesController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem itemCadFornecedor;

    @FXML
    private MenuItem itemCadFuncionario;

    @FXML
    private MenuItem itemCadLote;

    @FXML
    private MenuItem itemTelaInicial;

    @FXML
    private MenuItem itemVisuFornecedor;

    @FXML
    private MenuItem itemVisuFuncionario;

    @FXML
    private MenuItem itemVisuLote;

    @FXML
    private MenuItem itemVisuPonto;

    @FXML
    private Label lblLotes;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;
    
    private ArrayList<Lotes> lotesList = new ArrayList<>(); 
    private ObservableList<Lotes> listaObLotes = FXCollections.observableArrayList();
    LotesDAO lmetodos = new LotesDAO();
    Lotes l; 

     @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
       CadastrarFornecedorController cf =  new CadastrarFornecedorController();
        cf.trocarCadFornecedor(MenuBar);
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        CadastrarFuncionarioController cf =  new CadastrarFuncionarioController();
        cf.trocarCadFuncionario(MenuBar);
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        CadastroLotesController cl =  new CadastroLotesController();
        cl.trocarCadLotes(MenuBar);
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        VisualizarFornecedorController vf =  new VisualizarFornecedorController();
        vf.trocarVizFornecedor(MenuBar);
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
         VisualizarFuncionarioController vf =  new VisualizarFuncionarioController();
        vf.trocarVizFuncionario(MenuBar);
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        VisualizarLotesController vl =  new VisualizarLotesController();
        vl.trocarVizLotes(MenuBar);
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        VisualizarPontoController vp =  new VisualizarPontoController();
        vp.trocarVizPonto(MenuBar);
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        TelaHomeController thc = new TelaHomeController();
        thc.trocarTelaHome(MenuBar);
    }

    public void trocarVizLotes(MenuBar menuBar)throws IOException {
          Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();
        
        ((Stage) menuBar.getScene().getWindow()).close();
    }
    
    /* fazer o metodo para quando clicar em um item da tableview puxar as informações 
    
    void ??? {
        Tem como retornar a referencia do item ao clicar nele?
        Lotes lValores = lmetodo.ListarLotes(l, ref);
    
    exemplo: 
        txtReferencia.setText(String.valueOf(l.getReferencia()));
    }
    
    
    */
    
     void OnClickEditar(ActionEvent event) throws IOException {
        int id = (l.getReferencia());
        LotesDAO lmetodo = new LotesDAO();
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Editar?");
        alerta.setHeaderText("Deseja fazer a edição das informações?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if(lmetodo.editarLotes(l, id) != true){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edição Concluida");
                    alert.setHeaderText("A edição ocoreu com sucesso!!");
                    alerta.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Problema na Edição");
                    alert.setHeaderText("Ocorreu um problema na edição!!");
                    alerta.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edição Cancelada");
                    alert.setHeaderText("A edição foi cancelada com sucesso!!");
                    alerta.showAndWait();
            }
        });
     }
}
