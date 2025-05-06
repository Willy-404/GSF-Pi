package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
<<<<<<< Updated upstream
import java.util.ArrayList;
=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
>>>>>>> Stashed changes
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.Faccao;
import model.FaccaoDAO;


import model.Lotes;
import model.LotesDAO;

public class VisualizarLotesController {

    @FXML
    private MenuBar MenuBar;
    
        @FXML
    private Button btnEditar;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

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
    
<<<<<<< Updated upstream
    private ArrayList<Lotes> lotesList = new ArrayList<>(); 
    private ObservableList<Lotes> listaObLotes = FXCollections.observableArrayList();
    LotesDAO lmetodos = new LotesDAO();
    Lotes l; 
=======
     @FXML
    private TextField txtEntrada;
     
<<<<<<< Updated upstream
=======
     @FXML
    private TextField txtReferencia;
     
     @FXML
    private TextField txtPrazo;
     
     @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtMarca;
    
>>>>>>> Stashed changes
     @FXML
    private TextField txtReferencia;
     
     @FXML
    private TextField txtPrazo;
     
     @FXML
    private TextField txtQuantidade;
>>>>>>> Stashed changes

     Faccao f;
      public Stage stage;
    public void setFaccao(Faccao f) {
        this.f=f;
    }
<<<<<<< Updated upstream
<<<<<<< Updated upstream

      
=======
=======
>>>>>>> Stashed changes
    LotesDAO lmetodo = new LotesDAO();
 
>>>>>>> Stashed changes
    @FXML
    private TextField txtEntrada;

    @FXML
    private TextField txtMarca;

    @FXML
    private TableColumn<?, ?> txtPrazo;

    @FXML
    private TextField txtPreco;

    @FXML
    private TableColumn<?, ?> txtQuantidade;

    @FXML
    private TableColumn<?, ?> txtReferencia;

    @FXML
    private TextField txtTecido;
<<<<<<< Updated upstream
=======
    
    private void carregarLotes(){
        List<Lotes> lotesList = lmetodo.listarLotes(l, l.getReferencia()); 
        ObservableList<Lotes> listaObLotes = FXCollections.observableArrayList(lotesList);
            TabelaLotes.setItems(listaObLotes);  
            colPrazo.setCellValueFactory(new PropertyValueFactory<>("Prazo"));
            colReferencia.setCellValueFactory(new PropertyValueFactory<>("Referencia"));
            colQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
    }
>>>>>>> Stashed changes

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

    public static void trocarVizLotes(MenuBar menuBar, Faccao f)throws IOException {
          Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        VisualizarLotesController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(visuLotes);

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();
        
        ((Stage) menuBar.getScene().getWindow()).close();
    }
    
     public static void trocarVizLotes(Button btn, Faccao f)throws IOException {
          Stage visuLotes = new Stage();
        visuLotes.setMaximized(true);
        visuLotes.setTitle("Visualizar Lotes");

        URL url = new File("src/main/java/view/VisualizarLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        VisualizarLotesController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(visuLotes);

        Scene cena = new Scene(root);
        visuLotes.setScene(cena);
        visuLotes.show();
        
        ((Stage) btn.getScene().getWindow()).close();
    }
    
    /* fazer o metodo para quando clicar em um item da tableview puxar as informações 
    
    void ??? {
        Tem como retornar a referencia do item ao clicar nele?
        Lotes lValores = lmetodo.ListarLotes(l, ref);
    
    exemplo: 
        txtReferencia.setText(String.valueOf(l.getReferencia()));
    }
    
    
    */
    
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
        String TamanhoT = cbTamanho.getValue();
        int QuantidadeT = Integer.parseInt(txtQuantidade.getText());
        String LinhaT = cbLinha.getValue();
        
         Lotes lTroca = new Lotes(ReferenciaT, PrazoT, EntradaT, PrecoT, TecidoT, MarcaT, ColecaoT, ModeloT, TamanhoT, QuantidadeT, LinhaT);
        
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Editar?");
        alerta.setHeaderText("Deseja fazer a edição das informações?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                if(lmetodo.editarLotes(lTroca, id) != true){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edição Concluida");
                    alert.setHeaderText("A edição ocoreu com sucesso!!");
                    alerta.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Problema na Edição");
                    alert.setHeaderText("Ocorreu um problema na edição!!");
                    alerta.showAndWait();
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Edição Cancelada");
                    alert.setHeaderText("A edição foi cancelada com sucesso!!");
                    alerta.showAndWait();
            }
        });
     }

    public void setStage(Stage visuLotes) {
        this.stage = visuLotes;
    }
}
