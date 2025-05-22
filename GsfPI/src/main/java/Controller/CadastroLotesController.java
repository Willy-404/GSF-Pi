package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.Lotes;
import model.LotesDAO;
import util.Alertas;

public class CadastroLotesController {

    @FXML
    private MenuBar MenuBar;

       @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnConfirmarLote;

    @FXML
    private Button btnExcluir;
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
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    private TextField txtEntrada;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtPrazo;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtQuantidade;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TextField txtTecido;
    
    @FXML
    private TableView<?> tbSubGrupo;

     Faccao f;
      public Stage stage;

    public void setFaccao(Faccao f) {
        this.f=f;
    }
    Alertas alertas = new Alertas();
    @FXML
    public void initialize() {
        // Adiciona opções ao ComboBox
        cbTamanho.getItems().addAll("PP","P","M","G","GG","1","2","3","4","6","8","10","12","16","18");
        cbModelo.getItems().addAll("Calça","Short","legging","Blusa","Regata","Casaco");
        cbColecao.getItems().addAll("Primavera","verão","Outono","Inverno");
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
       //Validação de saída
       Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Sair?");
        alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                   alertas.alertaInformation("Saida Confirmada", "A saida foi confirmada com sucesso!");
                    TelaHomeController.trocarTelaHome(btnVoltar, f);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }else{
                  alertas.alertaInformation("Saida Cancelada", "A saida foi cancelada com sucesso!");
            }
        });
    }
    
     @FXML
    void onClickbtnConfirmar(ActionEvent event) throws IOException {
       //Fazer as verificações
       if (cadastroDeLotes() != true) {
            alertas.alertaError("Erro ao cadastrar", "Erro ao cadastrar o Lote");
        } else {
            alertas.alertaInformation("Cadastro realizado com sucesso", "O Lote foi cadastrado com sucesso!");
            
           VisualizarLotesController.trocarVizLotes(btnConfirmarLote, f);
        }
    }
    
    //metodo de trocar tela para cadastro lote
    public static void trocarCadLotes(MenuBar menuBar, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Lotes");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        CadastroLotesController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();

    }

    private boolean cadastroDeLotes() {

        int Referencia = Integer.parseInt(txtReferencia.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate Prazo = LocalDate.parse(txtPrazo.getText(), formatter);
        LocalDate Entrada = LocalDate.parse(txtEntrada.getText(), formatter);
        double Preco = Double.parseDouble(txtPreco.getText());
        String Tecido = txtTecido.getText();
        String Marca = txtMarca.getText();
        String Colecao = cbColecao.getValue();
        String Modelo = cbModelo.getValue();
        int Quantidade = Integer.parseInt(txtQuantidade.getText());

        Lotes l = new Lotes(Referencia, Prazo, Entrada, Preco, Tecido, Marca, Colecao, Modelo, Quantidade);
        LotesDAO LDmetodo = new LotesDAO();
        return LDmetodo.cadastroLotes(l);

    }

    public void setStage(Stage home) {
      this.stage = home;  
    }
    
        @FXML
    void onClickAdicionar(ActionEvent event) {

    }

    @FXML
    void onClickExcluir(ActionEvent event) {

    }
}
