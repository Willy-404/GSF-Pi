package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.Funcionario;
import model.FuncionarioDAO;
import model.Perfil;
import model.PontoDAO;
import util.Alertas;
import util.Validacao;

public class PontoEletronicoController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnConfirmarPonto;
    
        @FXML
    private Button btnVoltar;

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
    private TextField txtCpfPonto;
    Perfil f;
    private Stage stage;

    public void setPerfil(Perfil f) {
        this.f = f; 
    }
    
    Validacao validacao = new Validacao();
    Alertas alertas = new Alertas();
    PontoDAO pMetodo = new PontoDAO();
    
    
  @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        if (txtCpfPonto.getText().isEmpty()) {
                        CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                        CadastroLotesController.trocarCadLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                        VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                        VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                        VisualizarLotesController.trocarVizLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                       VisualizarPontoController.trocarVizPonto(MenuBar, f); 
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
        if (txtCpfPonto.getText().isEmpty()) {
                        TelaHomeController.trocarTelaHome(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
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
    FuncionarioDAO fmetodo = new FuncionarioDAO();
    Long cpfnum;
      @FXML
    void OnClickConfirmarPonto(ActionEvent event) throws SQLException {
        
        if(validacao.itemisEmpty(txtCpfPonto.getText(),"CPF")){
            return;
        } else { 
            String cpfSemPontos = txtCpfPonto.getText().replaceAll("[.-]", "");
            cpfnum = Long.parseLong(cpfSemPontos);
        }
        if (validacao.ValidaFormatoCpf(txtCpfPonto.getText())) {
            return;
        } else if ((validacao.ValidaTamanhoText(14,txtCpfPonto.getText())) && (validacao.ValidaTamanhoText(11,txtCpfPonto.getText()))) {
            alertas.alertaError("Tamanho do campo CPF Incompativel!","Tamanho do texto digitado no campo CPF fora do permitido!");
            return;
        } else if(validacao.ValidaCPFExiste(cpfnum, cpfnum)){
            return;  
        }
        
        if(cadastroDePonto() != true){
            return;
        } else {
            Funcionario f = fmetodo.select(cpfnum);
            alertas.alertaInformation("Cadastro realizado com sucesso "+f.getNomeFuncionario(), "Horario cadastrado com sucesso!");
            txtCpfPonto.setText("");
        }
                
        }   

    private boolean cadastroDePonto() throws SQLException {
        long cpfNum = Long.parseLong(txtCpfPonto.getText());
        int id = pMetodo.numId();
        Time hora = Time.valueOf(LocalTime.now().truncatedTo(MINUTES));
        return pMetodo.cadastroHora(cpfNum, LocalDate.now(), hora);
    }
       
    public static void trocarPonto(Button button, Perfil f)throws IOException {
       Stage ponto = new Stage();
        ponto.setMaximized(true);
        ponto.setTitle("Ponto Eletrônico");

        URL url = new File("src/main/java/view/PontoEletronico.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        PontoEletronicoController thc = loader.getController();
        thc.setPerfil(f);
        thc.setStage(ponto);

        Scene cena = new Scene(root);
        ponto.setScene(cena);
        ponto.show();
        
        ((Stage) button.getScene().getWindow()).close();
    }
    
        @FXML
    void OnClickVoltar(ActionEvent event) throws IOException {
        SaidaPontoController.trocarSaidaPonto(btnVoltar, f, "Ponto");
    }
   
    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }
    }

