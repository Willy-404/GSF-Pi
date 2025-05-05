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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;

public class VisualizarPerfilController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnSairDoPerfil;

    @FXML
    private Button btnVoltar;

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
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;
    
     @FXML
    private Menu menuCadastar;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;
    
    //Retorno dos valores da faccao Logada no sistema 
    FaccaoDAO fd = new FaccaoDAO();
    Faccao f = fd.ListaFaccao();
    
    @FXML
    public void initialize() {
        // Adiciona opções ao ComboBox
        txtCnpj.setText(String.valueOf(f.getCNPJFaccao()));
        txtContato.setText(f.getTelefone());
        txtEmail.setText(f.getEmailAcesso());
    }
    
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
    
    @FXML
    void OnClickSair(ActionEvent event) throws IOException  {
        LoginController lc = new LoginController();
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Logoff");
        alerta.setHeaderText("Deseja fazer a saida do sistema?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try{
                lc.trocarLogin(btnSairDoPerfil);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Logoff Cancelada");
                    alert.setHeaderText("O logoff foi cancelado com sucesso!!");
                    alerta.showAndWait();
            }
        });  
    }
    
      @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        TelaHomeController thc = new TelaHomeController();
        thc.trocarTelaHome(btnVoltar);
    }
    
     @FXML
    void OnClickEditar(ActionEvent event) throws IOException {
        long id = (f.getCNPJFaccao());
        FaccaoDAO fmetodo = new FaccaoDAO();
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Editar?");
        alerta.setHeaderText("Deseja fazer a edição das informações?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if(fmetodo.editarFaccao(f, id) != true){
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

   public void TrocarVisualizarPerfil(Button btnPerfil) throws IOException {
        Stage visuPerfil = new Stage();
        visuPerfil.setMaximized(true);
        visuPerfil.setTitle("Visualizar Perfil");

        URL url = new File("src/main/java/view/VisualizarPerfil.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        visuPerfil.setScene(cena);
        visuPerfil.show();
        ((Stage) btnPerfil.getScene().getWindow()).close();
        
    }
}