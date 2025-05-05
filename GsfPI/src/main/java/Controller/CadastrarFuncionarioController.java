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
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Funcionario;
import model.FuncionarioDAO;

public class CadastrarFuncionarioController {
    
    private ArrayList<Funcionario> userInfo = new ArrayList<>();
    public ArrayList<Funcionario> getUserInfo() {
        return userInfo;
    }    
   @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnCadastroFunca;

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
    private Menu menuCadastrar;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    private TextField txtCargo;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEmail;

    @FXML
    private FlowPane txtEndereco;

    @FXML
    private TextField txtNascimento;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        CadastrarFornecedorController cf = new CadastrarFornecedorController();
        cf.trocarCadFornecedor(MenuBar);
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        CadastrarFuncionarioController cf = new CadastrarFuncionarioController();
        cf.trocarCadFuncionario(MenuBar);
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        CadastroLotesController cl = new CadastroLotesController();
        cl.trocarCadLotes(MenuBar);
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        VisualizarFornecedorController vf = new VisualizarFornecedorController();
        vf.trocarVizFornecedor(MenuBar);
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
        VisualizarFuncionarioController vf = new VisualizarFuncionarioController();
        vf.trocarVizFuncionario(MenuBar);
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        VisualizarLotesController vl = new VisualizarLotesController();
        vl.trocarVizLotes(MenuBar);
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        VisualizarPontoController vp = new VisualizarPontoController();
        vp.trocarVizPonto(MenuBar);
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        TelaHomeController thc = new TelaHomeController();
        thc.trocarTelaHome(MenuBar);
    }

    @FXML
    void onClickCadastroFunca(ActionEvent event)  {
        if (txtCpf.getText().isEmpty() || txtNome.getText().isEmpty() || 
            txtNascimento.getText().isEmpty() || txtContato.getText().isEmpty()
            ||txtEmail.getText().isEmpty()||txtSalario.getText().isEmpty()
            ||txtCargo.getText().isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campos não preenchidos");
            alerta.setHeaderText("Todos os campos devem ser preenchidos!!!");
            alerta.showAndWait();
            return;
        } else if (!txtCpf.getText().matches("[z0-9]+")) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Campo CPF");
            alerta.setHeaderText("Campo CPF deve conter apenas numeros!!!");
            alerta.showAndWait();
            return;
        } else if (txtCpf.getText().length() != 11) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("CPF");
            alerta.setHeaderText("Campo CPF inválido!!!");
            alerta.showAndWait();
            return;
        }
        
        if (CadastroDeFuncionario() != true) { 
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
        //Metodo para trocar pra tela Cadastrar funcionario
    public void trocarCadFuncionario(MenuBar menuBar) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Funcionario");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();
    }

    public boolean CadastroDeFuncionario() {

        String Cpf = txtCpf.getText();
        String NomeFuncionario = txtNome.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate DataNascimento = LocalDate.parse(txtNascimento.getText(), formatter);
        String Telefone = txtContato.getText();
        String Email = txtEmail.getText();
        Float ValorHora = Float.parseFloat(txtSalario.getText());
        String Cargo = txtCargo.getText();

        Funcionario f = new Funcionario(Cpf, NomeFuncionario, DataNascimento, Telefone, Email, ValorHora, Cargo);
        FuncionarioDAO FuncaMetodo = new FuncionarioDAO();
        return FuncaMetodo.cadastroFuncionario(f);

    }

}
