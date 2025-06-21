package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import model.Faccao;

import model.Lotes;
import model.LotesDAO;
import util.Alertas;
import util.Validacao;

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
    
    @FXML
    private Button btnNovoLote;

    @FXML
    private Button btnPesquisar;
    
    @FXML
    private TextField txtPesquisar;

    Lotes l;
    Faccao f;
    public Stage stage;

    public void setFaccao(Faccao f) {
        this.f = f;
    }

    Lotes itemLote;
    LotesDAO lmetodo = new LotesDAO();

    @FXML
    private TableView<Lotes> TabelaLotes;

    @FXML
    private TableColumn<Lotes, LocalDate> colPrazo;
    
    @FXML
    private TableColumn<Lotes, Integer> colQuantidade;

    @FXML
    private TableColumn<Lotes, Integer> colReferencia;
    
     @FXML
    private TableColumn<Lotes, String> colColeção;

    @FXML
    private TableColumn<Lotes, LocalDate> colEntrada;

    @FXML
    private TableColumn<Lotes, String> colMarca;

    @FXML
    private TableColumn<Lotes, String> colModelo;

    @FXML
    private TableColumn<Lotes, Float> colPreco;

    @FXML
    private TableColumn<Lotes, String> colTecido;

    
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();
    int validarSelecao = 0;

    private void carregarLotes() {
         //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
        List<Lotes> lotesList = lmetodo.listarLotes();
        ObservableList<Lotes> listaObLotes = FXCollections.observableArrayList(lotesList);
        TabelaLotes.setItems(listaObLotes);
        
        colReferencia.setCellValueFactory(new PropertyValueFactory<>("Referencia"));
        colPrazo.setCellValueFactory(new PropertyValueFactory<>("Prazo"));
        colEntrada.setCellValueFactory(new PropertyValueFactory<>("Entrada"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
        colColeção.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
        colTecido.setCellValueFactory(new PropertyValueFactory<>("Tecido"));
        colMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("QuantidadeT"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));
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
        if (event.getClickCount() == 2) {
            itemLote = TabelaLotes.getSelectionModel().getSelectedItem();
            if (itemLote != null) {
                 Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Editar?");
                alerta.setHeaderText("Deseja fazer a edição do item selecionado?");
                alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        int id= itemLote.getReferencia();
                        itemLote = lmetodo.loteSelecionado(id);
                        CadastroLotesController.trocarCadLotes(TabelaLotes, f, itemLote);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } 
            });    
            } else {
                alertas.alertaError("Item selecionado", "O item selecionado não contem informações!");
            }
        }

    }

    public static void trocarVizLotes(MenuBar menuBar, Faccao f) throws IOException {
        Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        VisualizarLotesController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(visuLotes);
        thc.carregarLotes();

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();

        ((Stage) menuBar.getScene().getWindow()).close();
    }

    public static void trocarVizLotes(Button btn, Faccao f) throws IOException {
        Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        VisualizarLotesController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(visuLotes);
        thc.carregarLotes();

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();

        ((Stage) btn.getScene().getWindow()).close();
    }

    public void setStage(Stage visuLotes) {
        this.stage = visuLotes;
    }
    
     @FXML
    void OnClickNovoLote(ActionEvent event) throws IOException {
        CadastroLotesController.trocarCadLotes(btnNovoLote, f);
    }
    LotesDAO metodo = new LotesDAO();
    Lotes lotePesq;
    @FXML
    void OnClickPesquisar(ActionEvent event) throws SQLException {
        //Pesquisa por referencia
        if(!txtPesquisar.getText().equals("")){
            int pesquisaRef = Integer.parseInt(txtPesquisar.getText());
            lotePesq = metodo.select(pesquisaRef);
            if(lotePesq == null){
                alertas.alertaError("Nenhum Lote Encontrado", "A referência não existe no sistema, digite uma referência valida!");
                txtPesquisar.setText("");
            }else{
                ObservableList<Lotes> listaObLotes = FXCollections.observableArrayList(lotePesq);
                TabelaLotes.setItems(listaObLotes);

                colReferencia.setCellValueFactory(new PropertyValueFactory<>("Referencia"));
                colPrazo.setCellValueFactory(new PropertyValueFactory<>("Prazo"));
                colEntrada.setCellValueFactory(new PropertyValueFactory<>("Entrada"));
                colModelo.setCellValueFactory(new PropertyValueFactory<>("Modelo"));
                colColeção.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
                colTecido.setCellValueFactory(new PropertyValueFactory<>("Tecido"));
                colMarca.setCellValueFactory(new PropertyValueFactory<>("Marca"));
                colQuantidade.setCellValueFactory(new PropertyValueFactory<>("QuantidadeT"));
                colPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));
            }
        }else {
            carregarLotes();
        }
    }
}
