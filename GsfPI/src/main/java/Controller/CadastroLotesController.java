package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroLotesController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnConfirmarLote;

    @FXML
    private ComboBox<?> cbLinha;

    @FXML
    private ComboBox<?> cbColecao;

    @FXML
    private ComboBox<?> cbModelo;

    @FXML
    private ComboBox<?> cbTamanho;

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
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
       CadastrarFornecedorController cf =  new CadastrarFornecedorController();
        cf.trocarCadFornecedor(MenuBar);
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        CadastrarFuncionarioController cf =  new CadastrarFuncionarioController();
        cf.trocarCadFuncionario(MenuBar);
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        CadastroLotesController cl =  new CadastroLotesController();
        cl.trocarCadLotes(MenuBar);
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        VisualizarFornecedorController vf =  new VisualizarFornecedorController();
        vf.trocarVizFornecedor(MenuBar);
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
         VisualizarFuncionarioController vf =  new VisualizarFuncionarioController();
        vf.trocarVizFuncionario(MenuBar);
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        VisualizarLotesController vl =  new VisualizarLotesController();
        vl.trocarVizLotes(MenuBar);
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        VisualizarPontoController vp =  new VisualizarPontoController();
        vp.trocarVizPonto(MenuBar);
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        TelaHomeController thc = new TelaHomeController();
        thc.trocarTelaHome(MenuBar);
    }

    //metodo de trocar tela para cadastro lote
     public void trocarCadLotes(MenuBar menuBar)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("Cadastro de Lotes");

            URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) menuBar.getScene().getWindow()).close();
            
      /*     private boolean cadastroDeLotes(){
           
           int Referencia = Integer.parseInt(txtReferencia.getText()); 
           DateTimeFormatter formatacao  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
           LocalDateTime Prazo = LocalDateTime.parse(txtPrazo.getText()formatacao);
          // LocalDateTime Entrada = LocalDateTime.parse(txtEntrada.getText()formatacao);
          // 
           Double Preco = Double.parseDouble(txtPreco.getText());
           String Tecido = txtTecido.getText();
           String MarcaLote = txtMarca.getText();
           String Colecao = txtColecao.getText();
        //   String Modelo = txtModelo.getText();
        // Linha ?
        //mudar o nome marcalote 
           
        boolean sucesso = LotesDAO.cadastroLotes(Referencia, Prazo, Entrada, Saida, Preco, Tecido, MarcaLote, Colecao );
        return sucesso;
        */
    }
}
