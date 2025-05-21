package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.Fornecedor;
import model.FornecedorDAO;
import model.Funcionario;
import model.FuncionarioDAO;

public class CadastrarFornecedorController {
    
       private ArrayList<Fornecedor> userInfo = new ArrayList<>();
    public ArrayList<Fornecedor> getUserInfo() {
        return userInfo;
    }  

    @FXML
    private MenuBar MenuBar;
    
    @FXML
    private Button btnCadastrarForn;

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
    private TextField txtCnpj;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;
    
    
    Faccao f;
     public Stage stage;
     
    public void setFaccao(Faccao f) {
        this.f=f;
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
    void OnClickVoltar(ActionEvent event) throws IOException {
        TelaHomeController.trocarTelaHome(btnVoltar, f);
    }
    
    @FXML
    void OnClickCadastrarForn(ActionEvent event) {
        if (txtCnpj.getText().isEmpty() || txtNome.getText().isEmpty() || 
             txtContato.getText().isEmpty()
            ||txtEmail.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campos não preenchidos");
            alerta.setHeaderText("Todos os campos devem ser preenchidos!!!");
            alerta.showAndWait();
            return;
        } else if (!txtCnpj.getText().matches("[z0-9]+")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campo CPF");
            alerta.setHeaderText("Campo CPF deve conter apenas numeros!!!");
            alerta.showAndWait();
            return;
        } else if (txtCnpj.getText().length() != 11) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CPF");
            alerta.setHeaderText("Campo CPF inválido!!!");
            alerta.showAndWait();
            return;
        }
        
        if (CadastroDeFornecedor() != true) { 
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro ao cadastrar ");
            alerta.setHeaderText("Erro ao cadastrar funcionário ");
            alerta.showAndWait();
        } else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Cadastro realizado com sucesso");
            alerta.setHeaderText("O funcionário foi cadastrado com sucesso");
            alerta.showAndWait();
        }
    }
    
    //metodo para trocar tela para cadastrar fornecedor
    public static void trocarCadFornecedor(MenuBar menuBar, Faccao f)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("Cadastro de Fornecedor");

            URL url = new File("src/main/java/view/CadastrarFornecedor.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            CadastrarFornecedorController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(home);
            
           
            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) menuBar.getScene().getWindow()).close();
    }
    
     public boolean CadastroDeFornecedor() {

        Long CNPJFornecedor = Long.parseLong(txtCnpj.getText());
        String NomeFuncionario = txtNome.getText();
        String Telefone = txtContato.getText();
        String Email = txtEmail.getText();
       
        Fornecedor f = new Fornecedor(CNPJFornecedor, NomeFuncionario, Telefone, Email);
        FornecedorDAO FornecMetodo = new FornecedorDAO();
        return FornecMetodo.cadastroFornecedor(f);

    }


    public void setStage(Stage home) {
        this.stage = home;
    }

}
