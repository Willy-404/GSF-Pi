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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
             && cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem().isEmpty() && txtQuantidade.getText().isEmpty()) {
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
                int id = itemLote.getReferencia();
                Lotes lselect = new Lotes(id);
                itemLote = lmetodo.loteSelecionado(id);
                txtReferencia.setText(String.valueOf(itemLote.getReferencia()));
                txtPrazo.setValue(itemLote.getPrazo());
                txtEntrada.setValue(itemLote.getEntrada());
                String precoTexto = String.valueOf(itemLote.getPreco());
                String precoFormatado = precoTexto.replaceAll("[.]", ",");
                txtPreco.setText(String.valueOf(precoFormatado));
                txtTecido.setText(String.valueOf(itemLote.getTecido()));
                txtMarca.setText(String.valueOf(itemLote.getMarca()));
                cbColecao.setValue(itemLote.getColecao());
                cbModelo.setValue(itemLote.getModelo());
                txtQuantidade.setText(String.valueOf(itemLote.getQuantidadeT()));
                l = lselect;
                validarSelecao++;
            } else {
                alertas.alertaError("Item selecionado", "O item selecionado não contem informações!");
            }
        }

    }

    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        //Verificação de itemisEmpty para mostrar alerta CONFIRMATION
         if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
             && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
             && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
            TelaHomeController.trocarTelaHome(btnVoltar, f);
        } else {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas!");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    TelaHomeController.trocarTelaHome(btnVoltar, f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } 
        });
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

    //Não entra no botão onClickEditar
    @FXML
    void onClickEditar(ActionEvent event) throws IOException {  
        if(validarSelecao == 0){
            alertas.alertaError("Selecione um Item", "Nenhum Item foi selecionado, selecione um item para fazer a sua alteração!");
            return;
        }else if(!txtReferencia.getText().isEmpty() && !txtTecido.getText().isEmpty() && !cbColecao.getSelectionModel().getSelectedItem().isEmpty() && txtPrazo.getValue() != null 
           && txtEntrada.getValue() != null && !txtPreco.getText().isEmpty() && !cbModelo.getSelectionModel().getSelectedItem().isEmpty()
           && !txtQuantidade.getText().isEmpty()) {
            
            String dataPrazo = String.valueOf(txtPrazo.getValue()), dataEntrada = String.valueOf(txtEntrada.getValue());   
            int RefInt = 0;
            
            if(validacao.itemisEmpty(txtReferencia.getText(), "Referencia")){
                return;
                //formato?
            }else if(validacao.itemisEmpty(txtMarca.getText(), "Marca")){
                return;
                //Nome de Fornecedores no sistema?

            }else if(validacao.itemisEmpty(txtTecido.getText(), "Tecido")){
                return;

            }else if(validacao.itemNull(cbColecao.getSelectionModel().getSelectedItem(), "Coleção")){
                return;

            }else if(validacao.itemNull(dataPrazo, "Prazo")){
                return;

             } else if (validacao.itemNull(dataEntrada, "Entrada")) {
                 return;

             } else if (validacao.itemisEmpty(txtPreco.getText(), "Preço")) {
                 return;
             } else if (validacao.ValidarFormat("^\\d+,\\d{1,2}$", txtPreco.getText(), "Formato do Preço incorreto",
                     "O padrão esperado é XXXXX,XX!")) {
                 return;

             } else if (validacao.itemNull(cbModelo.getSelectionModel().getSelectedItem(), "Modelo")) {
                 return;

             }else if(validacao.itemisEmpty(txtQuantidade.getText(), "Quantidade")){
                 return;
             }
            int id = (l.getReferencia());
            LotesDAO lmetodo = new LotesDAO();

            int ReferenciaT = Integer.parseInt(txtReferencia.getText());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate PrazoT = txtPrazo.getValue();
            LocalDate EntradaT = txtEntrada.getValue();
            String precoTNum = txtPreco.getText().replaceAll("[,]", ".");
            float PrecoT = Float.parseFloat(precoTNum);
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
        }else{
            alertas.alertaError("Erro na edição", "Erro ao editar o lote!");
        }
    }

    public void setStage(Stage visuLotes) {
        this.stage = visuLotes;
    }
}
