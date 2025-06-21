package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Faccao;
import model.Funcionario;
import model.FuncionarioDAO;
import util.Alertas;

public class VisualizarFuncionarioController {

    @FXML
    private Button btnNovoFuncionario;

    @FXML
    private TableView<Funcionario> tabelaFuncionario;

    @FXML
    private TableColumn<Funcionario, String> colTelefone;

    @FXML
    private TableColumn<Funcionario, LocalDate> colNascimento;

    @FXML
    private TableColumn<Funcionario, String> colCPF;

    @FXML
    private TableColumn<Funcionario, Float> colSalario;

    @FXML
    private TableColumn<Funcionario, String> colCargo;

    @FXML
    private TableColumn<Funcionario, String> colEmail;

    @FXML
    private TableColumn<Funcionario, String> colNome;

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
    private Label lblFuncionarios;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;
    
     @FXML
    private Button btnPesquisar;

    Faccao f;
    public Stage stage;

    public void setFaccao(Faccao f) {
        this.f = f;
    }
    FuncionarioDAO lmetodo = new FuncionarioDAO();
    Alertas alertas = new Alertas();

    //Método para buscar do banco de dados
    public void carregarFuncionarios() {
         //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
        List<Funcionario> funcionarioList = lmetodo.ListarFuncionario();
        ObservableList<Funcionario> listaFuncionario = FXCollections.observableArrayList(funcionarioList);
        tabelaFuncionario.setItems(listaFuncionario);
        colCPF.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("NomeFuncionario"));
        colNascimento.setCellValueFactory(new PropertyValueFactory<>("DataNascimento"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colSalario.setCellValueFactory(new PropertyValueFactory<>("ValorHora"));
        colCargo.setCellValueFactory(new PropertyValueFactory<>("Cargo"));
    }

    @FXML
    public void initialize() {
        carregarFuncionarios();
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
    void onSelecionaItem(MouseEvent event) throws IOException {
        if(event.getClickCount() == 2){
            Funcionario itemSelecionado = tabelaFuncionario.getSelectionModel().getSelectedItem();
            if(itemSelecionado != null){
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Editar?");
                alerta.setHeaderText("Deseja fazer a edição do item selecionado?");
                alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        CadastrarFuncionarioController.trocarCadFuncionario(tabelaFuncionario, f, itemSelecionado);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
            });
                
            }else {
                alertas.alertaError("Item selecionado", "O item selecionado não contem informações!");
            }
        }
    }

    //metodo de trocar para a tela vizu funcionario
    public static void trocarVizFuncionario(MenuBar menuBar, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Visualizar Funcionário");

        URL url = new File("src/main/java/view/VisualizarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        VisualizarFuncionarioController thc = loader.getController();
        thc.setFaccao(f);
        thc.carregarFuncionarios();
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();
    }
    public static void trocarVizFuncionario(Button botao, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Visualizar Funcionário");

        URL url = new File("src/main/java/view/VisualizarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        VisualizarFuncionarioController thc = loader.getController();
        thc.setFaccao(f);
        thc.carregarFuncionarios();
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) botao.getScene().getWindow()).close();
    }

    @FXML
    void OnClickNovoFuncionario(ActionEvent event) throws IOException {
        Stage cadastroFuncionario = new Stage();
        cadastroFuncionario.setMaximized(true);
        cadastroFuncionario.setTitle("CadastroFuncionario");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastrarFuncionarioController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(cadastroFuncionario);
        thc.setTextButon("Cadastrar");
        thc.setTextLabel("Cadastro de Funcionário");
        
        Scene cena = new Scene(root);
        cadastroFuncionario.setScene(cena);
        cadastroFuncionario.show();

        ((Stage) btnNovoFuncionario.getScene().getWindow()).close();
    }

    public void setStage(Stage visuFuncionario) {
        this.stage = visuFuncionario;
    }
    
    @FXML
    void OnClickPesquisar(ActionEvent event) {
        //Pesquisa por nome de funcionario
        
    }

}
