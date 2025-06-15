package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
    private Button btnEditar;

    @FXML
    private Button btnVoltar;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private ComboBox<String> cbLinha;

    @FXML
    private ComboBox<String> cbColecao;

    @FXML
    private ComboBox<String> cbModelo;

    @FXML
    private ComboBox<String> cbTamanho;

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

    Lotes l;
    @FXML
    private DatePicker  txtEntrada;

    @FXML
    private TextField txtReferencia;

    @FXML
    private DatePicker txtPrazo;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtMarca;

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
    private TextField txtPreco;

    @FXML
    private TableColumn<Lotes, LocalDate> colPrazo;
    
    @FXML
    private TableColumn<Lotes, Integer> colQuantidade;

    @FXML
    private TableColumn<Lotes, Integer> colReferencia;

    @FXML
    private TextField txtTecido;
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();
    int validarSelecao = 0;

    private void carregarLotes() {
         //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
        List<Lotes> lotesList = lmetodo.listarLotes();
        ObservableList<Lotes> listaObLotes = FXCollections.observableArrayList(lotesList);
        TabelaLotes.setItems(listaObLotes);
        colPrazo.setCellValueFactory(new PropertyValueFactory<>("Prazo"));
        colReferencia.setCellValueFactory(new PropertyValueFactory<>("Referencia"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("QuantidadeT"));
    }

    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
         if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
                    CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
            }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
             CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
            CadastroLotesController.trocarCadLotes(MenuBar, f); 
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                   CadastroLotesController.trocarCadLotes(MenuBar, f); 
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
            VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
            VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
            VisualizarLotesController.trocarVizLotes(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    VisualizarLotesController.trocarVizLotes(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
            VisualizarPontoController.trocarVizPonto(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    VisualizarPontoController.trocarVizPonto(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
                    TelaHomeController.trocarTelaHome(MenuBar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    TelaHomeController.trocarTelaHome(MenuBar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
        }
        
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
}
