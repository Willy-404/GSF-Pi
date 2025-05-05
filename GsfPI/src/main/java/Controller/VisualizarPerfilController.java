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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;
import model.Perfil;

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
    
    @FXML
    private TextField txtSenha;
    
    //Retorno dos valores da faccao Logada no sistema 
    FaccaoDAO fd = new FaccaoDAO();
    Faccao f;
   public Stage stage;


    
    public void setFaccao(Faccao f) {
        this.f=f;
        txtCnpj.setText(String.valueOf(f.getCNPJFaccao()));
        txtContato.setText(f.getTelefone());
        txtEmail.setText(f.getEmailAcesso());
        txtNome.setText(f.getNomeRepreFaccao());
        txtSenha.setText(f.getSenha());
    }
        
    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
       CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        CadastroLotesController.trocarCadLotes(MenuBar, f);
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
         VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        VisualizarLotesController.trocarVizLotes(MenuBar, f);
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        VisualizarPontoController.trocarVizPonto(MenuBar, f);
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        TelaHomeController.trocarTelaHome(MenuBar, f);
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
        TelaHomeController.trocarTelaHome(btnVoltar, f);
    }
    
     @FXML
    void OnClickEditar(ActionEvent event) throws IOException {
        //seleciona o id da faccao que será modificada
        long id = (f.getCNPJFaccao());
        
        //Pegando as informações da Faccao atual
        long cnpjT = Long.parseLong(txtCnpj.getText());
        String NomeRepreFaccaoT = txtNome.getText();
        String EmailAcessoT = txtEmail.getText();
        String SenhaT = txtSenha.getText();
        String TelefoneT = txtContato.getText();
        Perfil perfilT = Perfil.FACCAO;
        
        Faccao fTroca = new Faccao(cnpjT,NomeRepreFaccaoT,EmailAcessoT,SenhaT,TelefoneT, perfilT);
        FaccaoDAO fmetodo = new FaccaoDAO();
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Editar?");
        alerta.setHeaderText("Deseja fazer a edição das informações?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if(fmetodo.editarFaccao(fTroca, id) != true){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Problema na Edição");
                    alert.setHeaderText("Ocorreu um problema na edição!!");
                    alerta.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edição Concluida");
                    alert.setHeaderText("A edição ocoreu com sucesso!!");
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

   public static void TrocarVisualizarPerfil(Button btnPerfil, Faccao f) throws IOException {
        Stage visuPerfil = new Stage();
        visuPerfil.setMaximized(true);
        visuPerfil.setTitle("Visualizar Perfil");

        URL url = new File("src/main/java/view/VisualizarPerfil.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
          VisualizarPerfilController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(visuPerfil);

        Scene cena = new Scene(root);
        visuPerfil.setScene(cena);
        visuPerfil.show();
        
        ((Stage) btnPerfil.getScene().getWindow()).close();
        
    }

    public void setStage(Stage visuPerfil) {
        this.stage = visuPerfil;
    }
}