package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.ItemLote;
import model.ItemLoteDAO;
import model.Lotes;
import model.LotesDAO;
import util.Alertas;
import util.Validacao;

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
    private TextField txtLinha;
    
    @FXML
    private TextField txtQuantidadeItem;

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
    private DatePicker txtEntrada;

    @FXML
    private TextField txtMarca;

    @FXML
    private DatePicker txtPrazo;

    @FXML
    private TextField txtPreco;

    @FXML
    private TextField txtReferencia;

    @FXML
    private TextField txtTecido;

    @FXML
    private TableView<?> tbSubGrupo;
    
    @FXML
    private TextField txtQuantidade;

    Faccao f;
    public Stage stage;

    public void setFaccao(Faccao f) {
        this.f = f;
    }
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();

    @FXML
    public void initialize() {
        // Adiciona opções ao ComboBox
        cbTamanho.getItems().addAll("PP","P","M","G","GG","1","2","3","4","6","8","10","12","16","18");
        cbModelo.getItems().addAll("Calça","Short","Legging","Blusa","Regata","Casaco");
        cbColecao.getItems().addAll("Primavera","Verão","Outono","Inverno");
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
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
                && cbColecao.getSelectionModel().isEmpty() && txtPrazo.getValue() == null && txtEntrada.getValue() == null
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().isEmpty() && txtQuantidade.getText().isEmpty()) {
            TelaHomeController.trocarTelaHome(btnVoltar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        TelaHomeController.trocarTelaHome(btnVoltar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } 
            });
        }
    }

    @FXML
    void onClickbtnConfirmar(ActionEvent event) throws IOException {
       String dataPrazo = String.valueOf(txtPrazo.getValue()), dataEntrada = String.valueOf(txtEntrada.getValue());
         System.out.println(dataPrazo+"\n"+dataEntrada);
               
       int RefInt = 0;
       if(validacao.itemisEmpty(txtReferencia.getText(), "Referencia")){
           return;
           //formato?
       }else{
           RefInt = Integer.parseInt(txtReferencia.getText());
       }if(validacao.ValidaRefSistema(txtReferencia.getText(), RefInt)){
           return;
           
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
        } else if (validacao.ValidarFormat("^\\d+,\\d{2}$", txtPreco.getText(), "Formato do Preço incorreto",
                "O padrão esperado é XXXXX,XX!")) {
            return;

        } else if (validacao.itemNull(cbModelo.getSelectionModel().getSelectedItem(), "Modelo")) {
            return;
            
        }else if(validacao.itemisEmpty(txtQuantidade.getText(), "Quantidade")){
            return;
        }

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

    public void setStage(Stage home) {
        this.stage = home;
    }

    private boolean cadastroDeLotes() {
        int Referencia = Integer.valueOf(txtReferencia.getText());
        LocalDate Prazo = txtPrazo.getValue(); 
        LocalDate Entrada = txtEntrada.getValue();
        String precoNum = txtPreco.getText().replaceAll("[,]", ".");
        float Preco = Float.parseFloat(precoNum);
        String Tecido = txtTecido.getText();
        String Marca = txtMarca.getText();
        String Colecao = cbColecao.getSelectionModel().getSelectedItem();
        String Modelo = cbModelo.getSelectionModel().getSelectedItem();
        int Quantidade = Integer.valueOf(txtQuantidade.getText());
       

        Lotes l = new Lotes(Referencia, Prazo, Entrada, Preco, Tecido, Marca, Colecao, Modelo, Quantidade);
        LotesDAO LDmetodo = new LotesDAO();
        return LDmetodo.cadastroLotes(l);

    }

    @FXML
    void onClickAdicionar(ActionEvent event) {
        adcionarSubgrupo();
    }
    
    @FXML
    public boolean adcionarSubgrupo() {
        String Tamanho = cbTamanho.getSelectionModel().getSelectedItem();
        String Linha = txtLinha.getText();
        int Quantidade = Integer.parseInt(txtQuantidadeItem.getText());

        ItemLote subgrupo = new ItemLote(Tamanho, Linha, Quantidade);
        ItemLoteDAO ItemMetodo = new ItemLoteDAO();
        return ItemMetodo.cadastroSubgrupo(subgrupo);
    }

    @FXML
    void onClickExcluir(ActionEvent event) {

    }
}
