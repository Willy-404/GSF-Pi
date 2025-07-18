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
import model.Fornecedor;
import model.FornecedorDAO;
import model.ItemLote;
import model.ItemLoteDAO;
import model.Lotes;
import model.LotesDAO;
import model.Perfil;
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
    private ComboBox<String> cbFornecedor;

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

    Perfil f;
    public Stage stage;
    FornecedorDAO fmetodo = new FornecedorDAO();
    
    public void setPerfil(Perfil f){
        this.f = f;
        if(f.getTipoPerfil().toString().equals("Fornecedor")){
            itemCadFornecedor.setVisible(false);
            itemCadFuncionario.setVisible(false);
            itemVisuFornecedor.setVisible(false);
            itemVisuFuncionario.setVisible(false);
            itemVisuPonto.setVisible(false);
            try{
               Fornecedor forne = fmetodo.selecionar(f.getCNPJ());
               cbFornecedor.getItems().add(forne.getNomeRepreFornecedor()); 
            }catch(SQLException e){
                e.printStackTrace();
            }  
        }else{
             itemCadFornecedor.setVisible(true);
            itemCadFuncionario.setVisible(true);
            itemVisuFornecedor.setVisible(true);
            itemVisuFuncionario.setVisible(true);
            itemVisuPonto.setVisible(true);
            List<Fornecedor> forne = fmetodo.ListarFornecedor();
            for(int i=0; i<forne.size();i++){
                cbFornecedor.getItems().add(forne.get(i).getNomeRepreFornecedor());
            }
        }
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        CadastroLotesController.trocarCadLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        VisualizarLotesController.trocarVizLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                       VisualizarPontoController.trocarVizPonto(MenuBar, f); 
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
                        TelaHomeController.trocarTelaHome(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnConfirmarLote.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                atualizarSaida();
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
                && txtPreco.getText().isEmpty() && cbModelo.getSelectionModel().getSelectedItem() == null && txtQuantidade.getText().isEmpty()
                && cbFornecedor.getSelectionModel().getSelectedItem() == null) {
            if(btnConfirmarLote.getText().equals("Editar")){
                VisualizarLotesController.trocarVizLotes(btnVoltar, f);
            }else{
                TelaHomeController.trocarTelaHome(btnVoltar, f);
            }
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    try {
                        if(btnConfirmarLote.getText().equals("Editar")){
                            VisualizarLotesController.trocarVizLotes(btnVoltar, f);
                            atualizarSaida();
                        }else{
                            TelaHomeController.trocarTelaHome(btnVoltar, f);
                        }
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } 
            });
        }
    }
   
    String ReferenciaSalva;
    private boolean isEdit(){
         boolean eEdit = false;
       if(btnConfirmarLote.getText().equals("Editar")){
             eEdit = true;
         }
       return eEdit;
    }
    @FXML
    void onClickbtnConfirmar(ActionEvent event) throws IOException {
       boolean edit = isEdit();
         
       String dataPrazo = String.valueOf(txtPrazo.getValue()), dataEntrada = String.valueOf(txtEntrada.getValue());
         System.out.println(dataPrazo+"\n"+dataEntrada);
               
       int RefInt = 0;
       if(validacao.itemisEmpty(txtReferencia.getText(), "Referencia")){
           return;
           
       }else{
           RefInt = Integer.parseInt(txtReferencia.getText());
       }if(edit == false){
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
            
        } else if (validacao.itemNull(cbFornecedor.getSelectionModel().getSelectedItem(), "Fornecedor")) {
            return;
        }

        ReferenciaSalva = txtReferencia.getText();
        if(edit == false){
            if (cadastroDeLotes() != true || cadastroDeSubgrupos() != true) {
                alertas.alertaError("Erro ao cadastrar", "Erro ao cadastrar Lote");
            } else {
                alertas.alertaInformation("Cadastro realizado com sucesso", "Lote cadastrado com sucesso!");
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
                cbFornecedor.setValue(null);
            }
        }else{
             String valorTexto = txtPreco.getText().replaceAll("[,]", ".");
            float valorPreco = Float.parseFloat(valorTexto);
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            Lotes loteEdit = new Lotes(RefInt, txtPrazo.getValue(), txtEntrada.getValue(), valorPreco, txtTecido.getText(), 
                txtMarca.getText(), cbColecao.getSelectionModel().getSelectedItem(), cbModelo.getSelectionModel().getSelectedItem(), quantidade,
            cbFornecedor.getSelectionModel().getSelectedItem());
            if(metodo.editarLotes(loteEdit, refSalva) != true || updateDeSubgrupos()!= true){
                alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
                txtLinha.setText("");
                txtQuantidadeItem.setText("");
                cbTamanho.setValue(null);

                btnAdicionar.setText("Adicionar");  
            } else {
                alertas.alertaInformation("Edição Concluida", "Edição concluída com sucesso!");
                VisualizarLotesController.trocarVizLotes(btnVoltar, f);
            }
            
        }
    }
    
    int possicaoSGSelect;
    @FXML
    void onSelecionaItem(MouseEvent event) throws SQLException {
        if (event.getClickCount() == 2) {
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
                    
                    if(itemUpdate == true){
                        setValoresSubGrupo(refSalva);
                         
                        txtLinha.setText("");
                        txtQuantidadeItem.setText("");
                        cbTamanho.setValue(null);

                        btnAdicionar.setText("Adicionar");  
                    }else{
                        alertas.alertaError("Edição de Item", "Erro na edição de Item!");
                        txtLinha.setText("");
                        txtQuantidadeItem.setText("");
                        cbTamanho.setValue(null);

                        btnAdicionar.setText("Adicionar"); 
                    }
                    
                }
        }  
           
    }

    //metodo de trocar tela para cadastro lote
    public static void trocarCadLotes(MenuBar menuBar, Perfil f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Lote");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastroLotesController thc = loader.getController();
        thc.setPerfil(f);
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();

    }
    
    public static void trocarCadLotes(TableView tabela, Perfil f, Lotes l) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Edição de Lote");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastroLotesController thc = loader.getController();
        thc.setPerfil(f);
        thc.setTextButon("Editar");
        thc.setTextLabel("Edição de Lote");
        thc.setValoresSubGrupo(l.getReferencia());
        thc.SalvarItensOriginais(l.getReferencia());
        
        thc.setValores(l);
        thc.setStage(home);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) tabela.getScene().getWindow()).close();

    }

    public static void trocarCadLotes(Button b, Perfil f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Lote");

        URL url = new File("src/main/java/view/CadastroLotes.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        CadastroLotesController thc = loader.getController();
        thc.setPerfil(f);
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
        String nome = cbFornecedor.getSelectionModel().getSelectedItem();
       

        Lotes l = new Lotes(Referencia, Prazo, Entrada, Preco, Tecido, Marca, Colecao, Modelo, Quantidade, nome);
        LotesDAO LDmetodo = new LotesDAO();
        return LDmetodo.cadastroLotes(l);

    }
    
    private boolean cadastroDeSubgrupos(){
    
        ItemLoteDAO metodo = new ItemLoteDAO();
        
        for (ItemLote item : ItensLote){
            ItemLote subgrupo = new ItemLote(refSalva,item.getQuantidade(),item.getTamanho(),item.getLinha());
            if(metodo.cadastroSubgrupo(subgrupo) == false){
                return false;
            }
        }
        return true;
    }
    
    private boolean updateDeSubgrupos(){
        int RefeLote = Integer.parseInt(ReferenciaSalva);
        ItemLoteDAO metodo = new ItemLoteDAO();
        List<ItemLote> lista = metodo.listarSubgrupos(RefeLote);
        for (int i = 0; i < ItensLote.size(); i++) {
            ItemLote itemAtual = ItensLote.get(i);
            ItemLote subgrupo = new ItemLote(RefeLote,itemAtual.getQuantidade(),itemAtual.getTamanho(),itemAtual.getLinha());
            if(i<lista.size()){
                int idE = lista.get(i).getId();
                if(!metodo.editarSubgrupo(subgrupo, idE)){
                    return false;
                }
            }else{
                if(!metodo.cadastroSubgrupo(subgrupo)){
                    return false;
                }
            }
        }
        return true;
    }
    
    ItemLote subgrupo = null; 
    @FXML
    public ItemLote adcionarSubgrupo() {
        
        String Tamanho = cbTamanho.getSelectionModel().getSelectedItem();
        String Linha = txtLinha.getText();
        int Quantidade = Integer.parseInt(txtQuantidadeItem.getText());

        subgrupo = new ItemLote(Quantidade, Tamanho, Linha);     
        return subgrupo;
    }
    List<ItemLote> itensSalvosAntesEdit;
    public void SalvarItensOriginais(int ref){
       itensSalvosAntesEdit = lmetodo.listarSubgrupos(ref);
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
    
    int refSalva;
    public void setValores(Lotes l){
        refSalva = l.getReferencia();
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
        cbFornecedor.setValue(l.getNomeFornecedor());
    }
    
    
    public void setValoresSubGrupo(int ref){
        ItensLote = lmetodo.listarSubgrupos(ref); 
        List<ItemLote> subgruposList = ItensLote;
        ObservableList<ItemLote> listSubgrupos = FXCollections.observableArrayList(subgruposList);
        tbSubGrupo.setItems(listSubgrupos);
        colTamanho.setCellValueFactory(new PropertyValueFactory<>("Tamanho"));
        colLinha.setCellValueFactory(new PropertyValueFactory<>("Linha"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
    }
    
    public void atualizarSaida(){
        int i = 0;
        for (ItemLote item : itensSalvosAntesEdit) {
            ItemLote il = new ItemLote(itensSalvosAntesEdit.get(i).getRefeLote(),itensSalvosAntesEdit.get(i).getQuantidade(),
                    itensSalvosAntesEdit.get(i).getTamanho(),itensSalvosAntesEdit.get(i).getLinha());
               lmetodo.editarSubgrupo(il, itensSalvosAntesEdit.get(i).getId()); 
            i++;
        }
    }
    
    @FXML
    void onClickExcluir(ActionEvent event) {
        ItemLote item = tbSubGrupo.getSelectionModel().getSelectedItem();
        if (item != null){
            int id = item.getId();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Deletar?");
            alerta.setHeaderText("Ao deletar essas informações serão perdidas! ");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    ItemLoteDAO excluir = new ItemLoteDAO();
                    if (!excluir.deletarSubgrupo(item, id)){
                        alertas.alertaError("Erro na exclusão", "Exclusão não efetivada!");
                    }else {
                        tbSubGrupo.getItems().remove(item);
                        txtQuantidadeItem.setText("");
                        cbTamanho.setValue(null);
                        txtLinha.setText("");
                        btnAdicionar.setText("Adicionar");
                    }
                } 
            });
        }else{
            alertas.alertaError("Nenhum Item selecionado","Selecione um Item para poder excluir!");
        }
        
            
    }
}
