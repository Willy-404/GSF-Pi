package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Faccao;
import model.Ponto;
import model.PontoDAO;

public class VisualizarPontoController {

   
    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnBuscar;

    @FXML
    private ComboBox<?> cbMes;
    
        @FXML
    private TableView<?> TabelaIdentificação;

    @FXML
    private TableView<?> TabelaPonto;

    @FXML
    private TableColumn<?, ?> colCpf;

    @FXML
    private TableColumn<?, ?> colData;

    @FXML
    private TableColumn<?, ?> colEntrada;

    @FXML
    private TableColumn<?, ?> colEntrada1;

    @FXML
    private TableColumn<?, ?> colNome;

    @FXML
    private TableColumn<?, ?> colSaida;

    @FXML
    private TableColumn<?, ?> colSaida1;

    @FXML
    private TableColumn<?, ?> colTurno;

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
    private TextField txtCpf;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPesquisa;
    Faccao f;

    public void setFaccao(Faccao f) {
        this.f=f;
    }
    
    PontoDAO pmetodo = new PontoDAO();
    public Stage stage;
  /*  private void carregarPonto() {
         //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
        List<Ponto> pontoList = pmetodo.listarPontos();
        ObservableList<Ponto> listaObPonto = FXCollections.observableArrayList(pontoList);
        TabelaPonto.setItems(listaObPonto);
        colCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        //Ver como puxar o nome da tabela de funcionario
        //colNome.setCellValueFactory(new PropertyValueFactory<>(""));
        
        //Error: IllegalStateException: Cannot read from unreadable property HorarioSaidaV
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colEntrada.setCellValueFactory(new PropertyValueFactory<>("HoraEntradaM"));
        colSaida.setCellValueFactory(new PropertyValueFactory<>("HoraSaidaM"));
        colEntrada1.setCellValueFactory(new PropertyValueFactory<>("HoraEntradaV"));
        colSaida1.setCellValueFactory(new PropertyValueFactory<>("HoraSaidaV"));
    }
    
    @FXML
    public void initialize() {
        carregarPonto();
    }*/
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
    
     public static void trocarVizPonto(MenuBar menuBar, Faccao f)throws IOException {
       Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Ponto Eletrônico");

        URL url = new File("src/main/java/view/VisualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        VisualizarPontoController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(visuPonto);

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
        
        ((Stage) menuBar.getScene().getWindow()).close();
    }
     
      public static void trocarVizPonto(Button button, Faccao f)throws IOException {
       Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Ponto Eletrônico");

        URL url = new File("src/main/java/view/VisualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        VisualizarPontoController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(visuPonto);

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
       
        ((Stage) button.getScene().getWindow()).close();
    }

    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }

}
