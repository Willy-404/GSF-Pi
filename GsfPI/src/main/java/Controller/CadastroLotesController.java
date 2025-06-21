package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private Label lblTitulo;

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
    List<ItemLote> ItensLote = new ArrayList<>();
    LotesDAO metodo = new LotesDAO();
    ItemLoteDAO lmetodo = new ItemLoteDAO();
     
    @FXML
    public void initialize() {
        // Adiciona opções ao ComboBox
        cbTamanho.getItems().addAll("PP","P","M","G","GG","1","2","3","4","6","8","10","12","16","18");
        cbModelo.getItems().addAll("Calça","Short","Legging","Blusa","Regata","Casaco");
        cbColecao.getItems().addAll("Primavera","Verão","Outono","Inverno");
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }
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
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas seram perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            }    
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
            VisualizarLotesController.trocarVizLotes(btnVoltar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas seram perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        VisualizarLotesController.trocarVizLotes(btnVoltar, f);
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
         boolean isEdit = false;
         if(btnConfirmarLote.getText().equals("Editar")){
             isEdit = true;
         }
       String dataPrazo = String.valueOf(txtPrazo.getValue()), dataEntrada = String.valueOf(txtEntrada.getValue());
         System.out.println(dataPrazo+"\n"+dataEntrada);
               
       int RefInt = 0;
       if(validacao.itemisEmpty(txtReferencia.getText(), "Referencia")){
           return;
           
       }else{
           RefInt = Integer.parseInt(txtReferencia.getText());
       }if(isEdit == false){
           if(validacao.ValidaRefSistema(txtReferencia.getText(), RefInt)){
                return;
           }
           
       }else if(validacao.itemisEmpty(txtMarca.getText(), "Marca")){
           return;
             
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
        if(isEdit == false){
            if (cadastroDeLotes() != true && cadastroDeSubgrupos() != true) {
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
                tbSubGrupo.setItems(null);
            }
        }else{
             String valorTexto = txtPreco.getText().replaceAll("[,]", ".");
            float valorPreco = Float.parseFloat(valorTexto);
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            Lotes loteEdit = new Lotes(RefInt, txtPrazo.getValue(), txtEntrada.getValue(), valorPreco, txtTecido.getText(), 
                txtMarca.getText(), cbColecao.getSelectionModel().getSelectedItem(), cbModelo.getSelectionModel().getSelectedItem(), quantidade);
            if(metodo.editarLotes(loteEdit, RefInt) != true && cadastroDeSubgrupos()){
                alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
            } else {
                alertas.alertaInformation("Edição Concluida", "A edição foi concluída com sucesso!");
                VisualizarLotesController.trocarVizLotes(btnVoltar, f);
            }
            
        }
    }
    
    int lugarLista = 0;
    
    @FXML
    void onSelecionaItem(MouseEvent event) throws SQLException {
        if (event.getClickCount() == 1) {
            subgrupo = tbSubGrupo.getSelectionModel().getSelectedItem();
            for(int i=0; i<lmetodo.numIdSubGrupo(); i++){
                if(subgrupo.equals(lmetodo.select(i,subgrupo.getRefeLote()))){
                   subgrupo.setId(i);
                }
            }
            btnAdicionar.setText("Editar");
        }
        if(subgrupo != null){
            cbTamanho.setValue(subgrupo.getTamanho());
            txtLinha.setText(subgrupo.getLinha());
            txtQuantidadeItem.setText(String.valueOf(subgrupo.getQuantidade()));
           
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
                if(!btnAdicionar.getText().equals("Editar")){
                    int quantItem = Integer.parseInt(txtQuantidadeItem.getText());
                    quantSomada = quantSomada + quantItem;
                    ItemLote item = adcionarSubgrupo();
                    ItensLote.add(item);
                    carregarSubgruposCadastro(ItensLote);

                    txtLinha.setText("");
                    txtQuantidadeItem.setText("");
                    cbTamanho.setValue(null);
                }else{
                    subgrupo.setQuantidade(Integer.parseInt(txtQuantidadeItem.getText()));
                    subgrupo.setLinha(txtLinha.getText());
                    subgrupo.setTamanho(cbTamanho.getSelectionModel().getSelectedItem());
                    boolean itemUpdate = lmetodo.editarSubgrupo(subgrupo, subgrupo.getId());
                    System.out.println(subgrupo);
                    System.out.println(subgrupo.getId());
                    if(itemUpdate == true){
                        
                        carregarSubgruposCadastro(ItensLote);
                        
                        tbSubGrupo.refresh(); 
                        txtLinha.setText("");
                        txtQuantidadeItem.setText("");
                        cbTamanho.setValue(null);

                        btnAdicionar.setText("Adicionar");  
                    }else{
                        alertas.alertaError("Edição de Item", "Erro na edição de Item!");
                    }
                    
                }
        }  
           
    }

    //metodo de trocar tela para cadastro lote
    public static void trocarCadLotes(MenuBar menuBar, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Lote");

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
    
    public static void trocarCadLotes(TableView tabela, Faccao f, Lotes l) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Edição de Lote");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastroLotesController thc = loader.getController();
        thc.setFaccao(f);
        thc.setTextButon("Editar");
        thc.setTextLabel("Edição de Lote");
        thc.setValoresSubGrupo(l.getReferencia());
        
        thc.setValores(l);
        //Carregar os SubGrupos 
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) tabela.getScene().getWindow()).close();

    }

    public static void trocarCadLotes(Button b, Faccao f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Lote");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastroLotesController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) b.getScene().getWindow()).close();

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
        return subgrupo;
    }
    
   
    public void carregarSubgruposCadastro(List<ItemLote> subgruposList) {
        ObservableList<ItemLote> listSubgrupos = FXCollections.observableArrayList(subgruposList);
        tbSubGrupo.setItems(listSubgrupos);
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("Tamanho"));
        colLinha.setCellValueFactory(new PropertyValueFactory<>("Linha"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
    }         
    
    public void setTextButon(String txtButton){
        btnConfirmarLote.setText(txtButton);
    }
    
    public void setTextLabel(String txtLabel){
        lblTitulo.setText(txtLabel);
    }
    
    public void setValores(Lotes l){
        txtReferencia.setText(String.valueOf(l.getReferencia()));
        txtEntrada.setValue(l.getEntrada());
        txtMarca.setText(l.getMarca());
        txtPrazo.setValue(l.getPrazo());
        String preco = String.valueOf(l.getPreco()).replaceAll("[.]", ",");
        txtPreco.setText(preco);
        txtQuantidade.setText(String.valueOf(l.getQuantidadeT()));
        cbColecao.setValue(l.getColecao());
        cbModelo.setValue(l.getModelo());
        txtTecido.setText(l.getTecido());
    }
    
    public void setValoresSubGrupo(int ref){
        ItemLoteDAO metodo = new ItemLoteDAO();
        ItensLote = lmetodo.listarSubgrupos(ref); 
        List<ItemLote> subgruposList = metodo.listarSubgrupos(ref);
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
