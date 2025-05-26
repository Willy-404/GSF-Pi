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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Faccao;
import model.Funcionario;
import model.FuncionarioDAO;
import util.Alertas;
import util.Validacao;

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
    private Menu menuCadastrar;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEmail;

    @FXML
    private FlowPane txtEndereco;

    @FXML
    private DatePicker txtNascimento;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;
  Faccao f;
    public Stage stage;

    public void setFaccao(Faccao r) {
        this.f = r;
    }
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao(); 
    @FXML
    public void initialize() {
        cbCargo.getItems().addAll("Costureira","Manual");
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
    void onClickVoltar(ActionEvent event) throws IOException {
        //Verificação de itemisEmpty para mostrar alerta CONFIRMATION
        TelaHomeController.trocarTelaHome(btnVoltar, f);
    }

    @FXML
    void onClickCadastroFunca(ActionEvent event)  {
        long cpfnum;
        //Nome, Cpf, Contato(telefone), Data de nascimento (trocar para datapicker). e no direito com, Email, Cargo, Salario.
        if (validacao.itemisEmpty(txtNome.getText(),"Nome")) {
            return;
            
        }else if(validacao.itemisEmpty(txtEmail.getText(),"Email")){
            return;
        }else if(validacao.ValidaFormatEmail(txtEmail.getText())){
            return;
            
        }else if(validacao.itemisEmpty(txtCpf.getText(),"CPF")){
            return;
        } else { 
            String cpfSemPontos = txtCpf.getText().replaceAll("[.-]", "");
            cpfnum = Long.parseLong(cpfSemPontos);
        }
        if (validacao.ValidaFormatoCpf(txtCpf.getText())) {
            return;
        } else if (validacao.ValidaTamanhoText(14,txtCpf.getText(), "CPF")) {
            return;
        }else if(validacao.ValidaCPFSistema(txtCpf.getText(), "funcionario", "Cpf", cpfnum)){
            return;
            
        }else if(validacao.itemisEmpty(cbCargo.getSelectionModel().getSelectedItem(),"Cargo")){
            return;
            
        }else if(validacao.itemisEmpty(txtContato.getText(),"Telefone")){
            return;
        }else if(validacao.ValidaFormatTell(txtContato.getText())){
            return;
        }else if (validacao.ValidaTamanhoText(15,txtContato.getText(), "Telefone")) {
            return;
               
        }else if(validacao.itemisEmpty(txtSalario.getText(),"Salario")){
             return;
        }else if(validacao.ValidarFormat("^\\d+,\\d{2}$", txtSalario.getText(), "Formato do Salário incorreto", "O padrão esperado é XXXXX,XX!")){
            return;
        }
        //Validar data?
        
        if (CadastroDeFuncionario() != true) { 
            alertas.alertaError("Erro ao cadastrar ", "Erro ao cadastrar o Funcionario");
        } else {
            alertas.alertaInformation("Cadastro realizado com sucesso", "O Funcionario foi cadastrado com sucesso");
        }
    }
        //Metodo para trocar pra tela Cadastrar funcionario
    public static void trocarCadFuncionario(MenuBar menuBar, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Funcionario");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        CadastrarFuncionarioController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();
    }

    public boolean CadastroDeFuncionario() {
        String cpfSemPontos = txtCpf.getText().replaceAll("[.-]", "");
        long Cpf = Long.parseLong(cpfSemPontos);
        String NomeFuncionario = txtNome.getText();
        LocalDate DataNascimento = txtNascimento.getValue();
        String Telefone = txtContato.getText();
        String Email = txtEmail.getText();
        float ValorHora = Float.parseFloat(txtSalario.getText());
        String Cargo = cbCargo.getSelectionModel().getSelectedItem();

        Funcionario f = new Funcionario(Cpf, NomeFuncionario, DataNascimento, Telefone, Email, ValorHora, Cargo);
        FuncionarioDAO FuncaMetodo = new FuncionarioDAO();
        return FuncaMetodo.cadastroFuncionario(f);

    }

    public void setStage(Stage home) {
      this.stage = home;  
    }

}
