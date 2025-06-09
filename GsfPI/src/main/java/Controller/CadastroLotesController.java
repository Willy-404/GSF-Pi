package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
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
    private TableView<ItemLote> tbSubGrupo;
    
    @FXML
    private TableColumn<ItemLote, String> colLinha;

    @FXML
    private TableColumn<ItemLote, Integer> colQuantidade;

    @FXML
    private TableColumn<ItemLote, String> colTamanho;
    
    @FXML
    private TextField txtQuantidade;

    Faccao f;
    public Stage stage;

    public void setFaccao(Faccao f) {
        this.f = f;
    }
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();
    int quantSomada = 0;

    @FXML
    public void initialize() {
        // Adiciona opções ao ComboBox
        cbTamanho.getItems().addAll("PP","P","M","G","GG","1","2","3","4","6","8","10","12","16","18");
        cbModelo.getItems().addAll("Calça","Short","Legging","Blusa","Regata","Casaco");
        cbColecao.getItems().addAll("Primavera","Verão","Outono","Inverno");
    }
    
    
    ArrayList<ItemLote> ItensLote = new ArrayList<>();
    

    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
                && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
                        CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        CadastroLotesController.trocarCadLotes(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        VisualizarLotesController.trocarVizLotes(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                       VisualizarPontoController.trocarVizPonto(MenuBar, f); 
                    } catch (IOException ex) {
                        ex.printStackTrace();
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
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        TelaHomeController.trocarTelaHome(MenuBar, f);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } 
            });
        }
        
    }

    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        //Validação de saída
        if (txtReferencia.getText().isEmpty() && txtMarca.getText().isEmpty() && txtTecido.getText().isEmpty()
                && cbColecao.getSelectionModel().getSelectedItem() == null && txtPrazo.getValue() == null && txtEntrada.getValue() == null
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()) {
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
    String ReferenciaSalva;
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
        } else if (validacao.ValidarFormat("^\\d+,\\d{1,2}$", txtPreco.getText(), "Formato do Preço incorreto",
                "O padrão esperado é XXXXX,XX!")) {
            return;

        } else if (validacao.itemNull(cbModelo.getSelectionModel().getSelectedItem(), "Modelo")) {
            return;
            
        }else if(validacao.itemisEmpty(txtQuantidade.getText(), "Quantidade")){
            return;
        }//Validar quantidades dos itens e quantidade total, as duas tem que ser iguais;

        ReferenciaSalva = txtReferencia.getText();
        if (cadastroDeLotes() != true) {
            alertas.alertaError("Erro ao cadastrar", "Erro ao cadastrar o Lote");
        } else {
            alertas.alertaInformation("Cadastro realizado com sucesso", "O Lote foi cadastrado com sucesso!");
            txtReferencia.setText("");
            txtTecido.setText("");
            txtPrazo.setValue(null);
            txtPreco.setText("");
            txtQuantidade.setText("");
            txtMarca.setText("");
            cbColecao.setValue(null);
            txtEntrada.setValue(null);
            cbModelo.setValue(null);
        }
        
        if (cadastroDeSubgrupos() != true){
            alertas.alertaError("Erro no Cadastro de Subgrupo", "Não foi possível cadastrar o Subgrupo");
        } else {
            alertas.alertaInformation("Subgrupo Cadastrado", "O Subgrupo foi Cadastrado com Sucesso");
        }
    }
    
    @FXML
    void onClickAdicionar(ActionEvent event) {
        if(validacao.itemNull(cbTamanho.getSelectionModel().getSelectedItem(), "Tamanho")){
            return;
            
        }else if(validacao.itemisEmpty(txtLinha.getText(), "Linha")){
               return;
               
        }else if(validacao.itemisEmpty(txtQuantidadeItem.getText(), "Quantidade")){
             return;
             
        }else{
            int quantItem = Integer.parseInt(txtQuantidadeItem.getText());
            quantSomada = quantSomada + quantItem;
            ItemLote item = adcionarSubgrupo();
            ItensLote.add(item);
            carregarSubgrupos(ItensLote);
            
            txtLinha.setText("");
            txtQuantidadeItem.setText("");
            cbTamanho.setValue(null);
        }
    }
    
    @FXML
    void onSelecionaItem(MouseEvent event) {
        if (event.getClickCount() == 2) {
            subgrupo = tbSubGrupo.getSelectionModel().getSelectedItem();
            btnAdicionar.setText("Editar");
        }
        if(subgrupo != null){
            //verificar qual o subgrupo ta sendo alterado por meio de um for e fazer a alteração nesse momento
            cbTamanho.setValue(subgrupo.getTamanho());
            txtLinha.setText(subgrupo.getLinha());
            txtQuantidadeItem.setText(String.valueOf(subgrupo.getQuantidade()));
        }
        btnAdicionar.setText("Adicionar");
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
    
    private boolean cadastroDeSubgrupos(){
    
        int RefeLote = Integer.parseInt(ReferenciaSalva);
        ItemLoteDAO metodo = new ItemLoteDAO();
        boolean resultado = true;
        
        for (ItemLote item : ItensLote){
            ItemLote subgrupo = new ItemLote(RefeLote,item.getQuantidade(),item.getTamanho(),item.getLinha());
            metodo.cadastroSubgrupo(subgrupo);
        }
        return resultado;
    }
    
    
    ItemLote subgrupo; 
    @FXML
    public ItemLote adcionarSubgrupo() {
        
        String Tamanho = cbTamanho.getSelectionModel().getSelectedItem();
        String Linha = txtLinha.getText();
        int Quantidade = Integer.parseInt(txtQuantidadeItem.getText());

        subgrupo = new ItemLote(Quantidade, Tamanho, Linha);
        //ItemLoteDAO ItemMetodo = new ItemLoteDAO(); 
        //return ItemMetodo.cadastroSubgrupo(subgrupo);
        
        return subgrupo;
    }
    
    ItemLoteDAO lmetodo = new ItemLoteDAO();
    public void carregarSubgrupos(List<ItemLote> subgruposList) {
        //vamos puxar os dados pra tabela direto do Array ItensLote
        
         //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
            ObservableList<ItemLote> listSubgrupos = FXCollections.observableArrayList(subgruposList);
            tbSubGrupo.setItems(listSubgrupos);
            colTamanho.setCellValueFactory(new PropertyValueFactory<>("Tamanho"));
            colLinha.setCellValueFactory(new PropertyValueFactory<>("Linha"));
            colQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
    }

    @FXML
    void onClickExcluir(ActionEvent event) {

    }
}
