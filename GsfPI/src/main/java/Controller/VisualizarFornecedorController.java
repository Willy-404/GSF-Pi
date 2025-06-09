package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Faccao;
import model.Fornecedor;
import model.FornecedorDAO;
import util.Alertas;

public class VisualizarFornecedorController {

    @FXML
    private Button btnNovoFornecedor;

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
    private Label lblFornecedores;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    private Menu menuCadastrar;
    Faccao f;
    public Stage stage;

    public void setFaccao(Faccao f) {
        this.f = f;
    }

    @FXML
    private TableView<Fornecedor> tabelaFornecedor;

    @FXML
    private TableColumn<Fornecedor, Long> colCnpj;

    @FXML
    private TableColumn<Fornecedor, String> colSenha;

    @FXML
    private TableColumn<Fornecedor, String> colRepresentante;
    
    @FXML
    private TableColumn<Fornecedor, String> colEndereco;
    
    @FXML
    private TableColumn<Fornecedor, String> colEmail;
    
    @FXML
    private TableColumn<Fornecedor, String> colTelefone;
    
    FornecedorDAO lmetodo = new FornecedorDAO();
    Alertas alertas = new Alertas();

    //Método para buscar do banco de dados
    public void visuFornecedor() {
        //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
        List<Fornecedor> fornecedorList = lmetodo.ListarFornecedor();
        ObservableList<Fornecedor> listaFornecedor = FXCollections.observableArrayList(fornecedorList);
        tabelaFornecedor.setItems(listaFornecedor);
        colCnpj.setCellValueFactory(new PropertyValueFactory<>("CnpjFornecedor"));
        colRepresentante.setCellValueFactory(new PropertyValueFactory<>("NomeRepreFornecedor"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("UsuarioFornecedor"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
        
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
    void onSelecionaItem(MouseEvent event) {
         if(event.getClickCount() == 2){
            Fornecedor itemSelecionado = tabelaFornecedor.getSelectionModel().getSelectedItem();
            if(itemSelecionado != null){
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Editar?");
                alerta.setHeaderText("Deseja fazer a edição do item selecionado?");
                alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        CadastrarFornecedorController.trocarCadFornecedor(tabelaFornecedor, f, itemSelecionado);
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

    //metodo para trocar tela para visualizar fornecedor
    public static void trocarVizFornecedor(MenuBar menuBar, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Visualizar o Fornecedor");

        URL url = new File("src/main/java/view/VisualizarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        VisualizarFornecedorController thc = loader.getController();
        thc.visuFornecedor();
        thc.setStage(home);
        thc.setFaccao(f);
        
        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();
    }

    public static void trocarVizFornecedor(Button botao, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Visualizar o Fornecedor");

        URL url = new File("src/main/java/view/VisualizarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        VisualizarFornecedorController thc = loader.getController();
        thc.setFaccao(f);
        thc.visuFornecedor();
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) botao.getScene().getWindow()).close();
    }
    
    @FXML
    void OnClickNovoFornecedor(ActionEvent event) throws IOException {
        Stage cadastroFornecedor = new Stage();
        cadastroFornecedor.setMaximized(true);
        cadastroFornecedor.setTitle("Cadastrar Fornecedor");
        URL url = new File("src/main/java/view/CadastrarFornecedor.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastrarFornecedorController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(cadastroFornecedor);
        thc.setTextButon("Cadastrar");
        thc.setTextLabel("Cadastro de Fornecedor");

        Scene cena = new Scene(root);
        cadastroFornecedor.setScene(cena);
        cadastroFornecedor.show();

        ((Stage) btnNovoFornecedor.getScene().getWindow()).close();
    }

    public void setStage(Stage home) {
        this.stage = home;
    }

  /*  @FXML
    public void initialize() {
        visuFornecedor();
    }*/

}
