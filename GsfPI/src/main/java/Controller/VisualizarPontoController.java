package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import model.Funcionario;
import model.FuncionarioDAO;
import model.Ponto;
import model.PontoDAO;
import util.Alertas;

public class VisualizarPontoController {

   
    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnBuscar;

    @FXML
    private ComboBox<String> cbMes;
    
    @FXML
    private TableView<Funcionario> TabelaIdentificação;

    @FXML
    private TableView<Ponto> TabelaPonto;

    @FXML
    private TableColumn<Funcionario, Long> colCpf;

    @FXML
    private TableColumn<Ponto, LocalDate> colData;

    @FXML
    private TableColumn<Ponto, LocalTime> colEntrada;

    @FXML
    private TableColumn<Ponto, LocalTime> colEntrada1;
    
     @FXML
    private TableColumn<Ponto, LocalTime> colEntradaEx;

    @FXML
    private TableColumn<Funcionario, String> colNome;

    @FXML
    private TableColumn<Ponto, LocalTime> colSaida;

    @FXML
    private TableColumn<Ponto, LocalTime> colSaida1;
    
     @FXML
    private TableColumn<Ponto, LocalTime> colSaidaEx;

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
    private Label txtCpf;

    @FXML
    private Label txtNome;

    @FXML
    private TextField txtPesquisa;
    
    @FXML
    private Button btnPesquisaMes;
    
    Faccao f;

    public void setFaccao(Faccao f) {
        this.f=f;
    }
    
    PontoDAO pmetodo = new PontoDAO();
    FuncionarioDAO fmetodo = new FuncionarioDAO();
    public Stage stage;
    Alertas alertas = new Alertas();
    
    private void carregarPonto(long cpf) {
         //Ao puxar para a table view temos que voltar ao padrão pedido nos outros momentos, se usa replaceAll?
        List<Ponto> pontoList = pmetodo.listarPontos(cpf);
        ObservableList<Ponto> listaObPonto = FXCollections.observableArrayList(pontoList);
        TabelaPonto.setItems(listaObPonto);
        
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colEntrada.setCellValueFactory(new PropertyValueFactory<>("HoraEntradaM"));
        colSaida.setCellValueFactory(new PropertyValueFactory<>("HoraSaidaM"));
        colEntrada1.setCellValueFactory(new PropertyValueFactory<>("HoraEntradaV"));
        colSaida1.setCellValueFactory(new PropertyValueFactory<>("HoraSaidaV"));
        colEntradaEx.setCellValueFactory(new PropertyValueFactory<>("HorarioEntradaEx"));
        colSaidaEx.setCellValueFactory(new PropertyValueFactory<>("HorarioSaidaEx"));
    }
    private void carregarFuncionario(){
        List<Funcionario> funcList = fmetodo.ListarFuncionario();
        ObservableList<Funcionario> listaObFunc = FXCollections.observableArrayList(funcList);
        TabelaIdentificação.setItems(listaObFunc);
        
        colCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        colNome.setCellValueFactory(new PropertyValueFactory("NomeFuncionario"));
    }
    
    @FXML
    public void initialize() {
        carregarFuncionario();
        btnPesquisaMes.setVisible(false);
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
    void onSelecionaItem(MouseEvent event){
         if(event.getClickCount() == 2){
             Funcionario fun = TabelaIdentificação.getSelectionModel().getSelectedItem();
             String cpf = String.valueOf(fun.getCpf());
             txtCpf.setText(cpf);
             txtNome.setText(fun.getNomeFuncionario());
             cbMes.getItems().addAll("JANEIRO","FEVEREIRO","MARÇO","ABRIL","MAIO","JUNHO","JULHO","AGOSTO","SETEMBRO","OUTUBRO","NOVEMBRO","DEZEMBRO");
             btnPesquisaMes.setVisible(true);
             carregarPonto(fun.getCpf());
         }
    }
    
    @FXML
    void onSelectHora(MouseEvent event) throws IOException {
        if(event.getClickCount() == 2){
            Ponto p = TabelaPonto.getSelectionModel().getSelectedItem();
            EditHorariosController.trocarTelaEditHora(TabelaPonto, f, p);
        }
    }
     public static void trocarVizPonto(MenuBar menuBar, Faccao f)throws IOException {
       Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Ponto Eletrônico");

        URL url = new File("src/main/java/view/VisualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        VisualizarPontoController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(visuPonto);

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
        
        ((Stage) menuBar.getScene().getWindow()).close();
    }
     
      public static void trocarVizPonto(Button button, Faccao f)throws IOException {
       Stage visuPonto = new Stage();
        visuPonto.setMaximized(true);
        visuPonto.setTitle("Visualizar Ponto Eletrônico");

        URL url = new File("src/main/java/view/VisualizarPonto.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        VisualizarPontoController thc = loader.getController();
        thc.setFaccao(f);
        thc.setStage(visuPonto);

        Scene cena = new Scene(root);
        visuPonto.setScene(cena);
        visuPonto.show();
       
        ((Stage) button.getScene().getWindow()).close();
    }

    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }
    
    Funcionario funcionarioPesq;
    @FXML
    void onClickPesquisa(ActionEvent event) throws SQLException{
        //Pesquisa pelo nome do funcionario
        if(!txtPesquisa.getText().equals("")){
            funcionarioPesq = fmetodo.pesquisa(txtPesquisa.getText());
            if(funcionarioPesq == null){
                alertas.alertaError("Nenhum Funcionário Encontrado", "O Funcionário não existe no sistema, digite um nome valido!");
                txtPesquisa.setText("");
                carregarFuncionario();
            }else{
                ObservableList<Funcionario> listaFuncionario = FXCollections.observableArrayList(funcionarioPesq);
                TabelaIdentificação.setItems(listaFuncionario);
                colCpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
                colNome.setCellValueFactory(new PropertyValueFactory<>("NomeFuncionario"));
            }
        }else {
            carregarFuncionario();
        }
    }
    
    List<Ponto> pontoPesq = new ArrayList<>();
    @FXML
    void onClickPesquisaMes(ActionEvent event) throws SQLException{
        //Pesquisa dos meses de horario 
        String sql;
        long cpf = Long.parseLong(txtCpf.getText());
        if(cbMes.getSelectionModel().getSelectedItem() !=  null){
            if(cbMes.getSelectionModel().getSelectedItem().equals("JANEIRO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 1";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("FEVEREIRO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 2";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("MARÇO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 3";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("ABRIL")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 4";
               pontoPesq = pmetodo.pesquisa(sql);  
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("MAIO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 5";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("JUNHO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 6";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("JULHO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 7";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("AGOSTO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 8";
               pontoPesq = pmetodo.pesquisa(sql);  
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("SETEMBRO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 9";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("OUTUBRO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 10";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("NOVEMBRO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 11";
               pontoPesq = pmetodo.pesquisa(sql); 
               
            }else if(cbMes.getSelectionModel().getSelectedItem().equals("DEZEMBRO")){
               sql = "SELECT* FROM registrohora WHERE MONTH(DataRegistro) = 12";
               pontoPesq = pmetodo.pesquisa(sql); 
            }
            
            if(pontoPesq == null){
                alertas.alertaError("Nenhum Registro nesse mês foi Encontrado", "O Registro desse mês não existe no sistema, selecione um mês com registros validos!");
                txtPesquisa.setText("");
                carregarPonto(cpf);
            }else{
                ObservableList<Ponto> listaObPonto = FXCollections.observableArrayList(pontoPesq);
                TabelaPonto.setItems(listaObPonto);

                colData.setCellValueFactory(new PropertyValueFactory<>("data"));
                colEntrada.setCellValueFactory(new PropertyValueFactory<>("HoraEntradaM"));
                colSaida.setCellValueFactory(new PropertyValueFactory<>("HoraSaidaM"));
                colEntrada1.setCellValueFactory(new PropertyValueFactory<>("HoraEntradaV"));
                colSaida1.setCellValueFactory(new PropertyValueFactory<>("HoraSaidaV"));
                colEntradaEx.setCellValueFactory(new PropertyValueFactory<>("HorarioEntradaEx"));
                colSaidaEx.setCellValueFactory(new PropertyValueFactory<>("HorarioSaidaEx"));
            }
        }else {
            carregarPonto(cpf);
        }
    }

}
