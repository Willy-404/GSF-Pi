package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.ComboBox;
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
    private TextField txtEntrada;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TextField txtPrazo;

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
        if (event.getClickCount() == 1) {
            itemLote = TabelaLotes.getSelectionModel().getSelectedItem();
            if (itemLote != null) {
                int id = itemLote.getReferencia();
                itemLote = lmetodo.loteSelecionado(id);
                txtReferencia.setText(String.valueOf(itemLote.getReferencia()));
                txtPrazo.setText(String.valueOf(itemLote.getPrazo()));
                txtEntrada.setText(String.valueOf(itemLote.getEntrada()));
                txtPreco.setText(String.valueOf(itemLote.getPreco()));
                txtTecido.setText(String.valueOf(itemLote.getTecido()));
                txtMarca.setText(String.valueOf(itemLote.getMarca()));
                cbColecao.setValue(itemLote.getColecao());
                cbModelo.setValue(itemLote.getModelo());
                txtQuantidade.setText(String.valueOf(itemLote.getQuantidade()));
            } else {
                alertas.alertaError("Item selecionado", "O item selecionado não contem informações!");
            }
        }

    }

    @FXML
    void onClickVoltar(ActionEvent event) {
        //Verificação de itemisEmpty para mostrar alerta CONFIRMATION
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair da tela?");
        alerta.setHeaderText("Ao sair perderá qualquer alteração!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    alertas.alertaInformation("Saida Confirmada", "A saida foi confirmada com sucesso!");
                    TelaHomeController.trocarTelaHome(btnVoltar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                alertas.alertaInformation("Saida Cancelada", "A saida foi cancelada com sucesso!");
            }
        });
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

    void OnClickEditar(ActionEvent event) throws IOException {
        int id = (l.getReferencia());
        LotesDAO lmetodo = new LotesDAO();

        int ReferenciaT = Integer.parseInt(txtReferencia.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate PrazoT = LocalDate.parse(txtPrazo.getText(), formatter);
        LocalDate EntradaT = LocalDate.parse(txtEntrada.getText(), formatter);
        Double PrecoT = Double.parseDouble(txtPreco.getText());
        String TecidoT = txtTecido.getText();
        String MarcaT = txtMarca.getText();
        String ColecaoT = cbColecao.getValue();
        String ModeloT = cbModelo.getValue();
        int QuantidadeT = Integer.parseInt(txtQuantidade.getText());

        Lotes lTroca = new Lotes(ReferenciaT, PrazoT, EntradaT, PrecoT, TecidoT, MarcaT, ColecaoT, ModeloT, QuantidadeT);

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Editar?");
        alerta.setHeaderText("Deseja fazer a edição das informações?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if (lmetodo.editarLotes(lTroca, id) != true) {
                    alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
                } else {
                    alertas.alertaInformation("Edição Concluida", "A edição foi concluída com sucesso!");
                }
            } else {
                alertas.alertaInformation("Edição Cancelada", "A edição foi cancelada com sucesso!!");
            }
        });
    }

    public void setStage(Stage visuLotes) {
        this.stage = visuLotes;
    }
}
