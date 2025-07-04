package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import model.Funcionario;
import model.FuncionarioDAO;
import model.Perfil;
import util.Alertas;
import util.Validacao;

public class CadastrarFuncionarioController {
  
    private ArrayList<Funcionario> userInfo = new ArrayList<>();
    public ArrayList<Funcionario> getUserInfo() {
        return userInfo;
    }    
   @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnCadastroFunca;

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
    private Menu menuCadastrar;

    @FXML
    private Menu menuHome;

    @FXML
    private Menu menuVisualizar;

    @FXML
    private ComboBox<String> cbCargo;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEmail;

    @FXML
    private FlowPane txtEndereco;

    @FXML
    private DatePicker txtNascimento;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;
    
     @FXML
    private Label lblTitulo;

    Perfil f;
    public Stage stage;
    

    public void setPerfil(Perfil r) {
        this.f = r;
    }
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao(); 
    @FXML
    public void initialize() {
        cbCargo.getItems().addAll("Costureira","Manual");
        
    }
    
     @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        CadastroLotesController.trocarCadLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                         VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
            }else{
                alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
            }                     alerta.showAndWait().ifPresent(response -> {
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
               alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        VisualizarLotesController.trocarVizLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
               alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        VisualizarPontoController.trocarVizPonto(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                        TelaHomeController.trocarTelaHome(MenuBar, f);
        }else{
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastroFunca.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
        //Verificação de itemisEmpty para mostrar alerta CONFIRMATION
            if (txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                    &&  txtContato.getText().isEmpty() && cbCargo.getSelectionModel().getSelectedItem() == null && txtSalario.getText().isEmpty()) {
                TelaHomeController.trocarTelaHome(btnVoltar, f);
            } else {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Sair?");
                if(btnCadastroFunca.getText().equals("Editar")){
                    alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
                }else{
                    alerta.setHeaderText("Ao sair as informações apresentadas serão perdidas! ");
                }   
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
    void onClickCadastroFunca(ActionEvent event) throws IOException  {
        long cpfnum;
        boolean isEdit = false;
        if(btnCadastroFunca.getText().equals("Editar")){
            isEdit = true;
        }
        //Nome, Cpf, Contato(telefone), Data de nascimento (trocar para datapicker). e no direito com, Email, Cargo, Salario.
        if (validacao.itemisEmpty(txtNome.getText(),"Nome")) {
            return;
            
        }else if(validacao.itemisEmpty(txtEmail.getText(),"Email")){
            return;
        }else if(validacao.ValidaFormatEmail(txtEmail.getText())){
            return;
            
        }else if(validacao.itemisEmpty(txtCpf.getText(),"CPF")){
            return;
        } else { 
            String cpfSemPontos = txtCpf.getText().replaceAll("[.-]", "");
            cpfnum = Long.parseLong(cpfSemPontos);
        }
        if (validacao.ValidaFormatoCpf(txtCpf.getText())) {
            return;
        } else if ((validacao.ValidaTamanhoText(14,txtCpf.getText())) && (validacao.ValidaTamanhoText(11,txtCpf.getText()))) {
            alertas.alertaError("Tamanho do campo CPF Incompativel!","Tamanho do texto digitado no campo CPF fora do permitido!");
            return;
        }else if(isEdit == false){
            if(validacao.ValidaCPFSistema(txtCpf.getText(), "funcionario", "Cpf", cpfnum)){
                return;   
            }
        }else if(validacao.itemisEmpty(cbCargo.getSelectionModel().getSelectedItem(),"Cargo")){
            return;
            
        }else if(validacao.itemisEmpty(txtContato.getText(),"Telefone")){
            return;
        }else if(validacao.ValidaFormatTell(txtContato.getText())){
            return;
        }else if ((validacao.ValidaTamanhoText(15,txtContato.getText())) && (validacao.ValidaTamanhoText(11,txtContato.getText()))) {
            alertas.alertaError("Tamanho do campo Telefone Incompativel!","Tamanho do texto digitado no campo Telefone fora do permitido!");
            return;
               
        }else if(validacao.itemisEmpty(txtSalario.getText(),"Salario")){
             return;
        }else if(validacao.ValidarFormat("^\\d+[.,]\\d{1,2}$", txtSalario.getText(), "Formato do Salário incorreto", "O padrão esperado é XXXXX,XX!")){
            return;
        }
        if(isEdit == false){
            if (CadastroDeFuncionario() != true) { 
                alertas.alertaError("Erro ao cadastrar ", "Erro ao cadastrar o Funcionário!");
            } else {
                alertas.alertaInformation("Cadastro realizado com sucesso", "Funcionário cadastrado com sucesso!");
                txtNome.setText("");
                txtCpf.setText("");
                txtContato.setText("");
                txtNascimento.setValue(null);
                txtEmail.setText("");
                txtSalario.setText("");
                cbCargo.setValue(null);
            }
        }else{
            FuncionarioDAO funcionarioMetodo = new FuncionarioDAO();
            String valorTexto = txtSalario.getText().replaceAll("[,]", ".");
            float valorSalario = Float.parseFloat(valorTexto);
            LocalDate DataNascimento = txtNascimento.getValue();
            Funcionario funcionario = new Funcionario(cpfnum, txtNome.getText(), DataNascimento, txtContato.getText(), 
                    txtEmail.getText(), valorSalario, cbCargo.getValue());
            if(funcionarioMetodo.editarFuncionario(funcionario, cpfItemTrocado) != true){
                 alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
            }else {
                 alertas.alertaInformation("Edição Concluida", "Edição concluída com sucesso!");
                 VisualizarFuncionarioController.trocarVizFuncionario(btnCadastroFunca, f);
            }
        }
        
        
    }
        //Metodo para trocar pra tela Cadastrar funcionario pelo menubar
    public static void trocarCadFuncionario(MenuBar menuBar, Perfil f) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Cadastro de Funcionário");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        CadastrarFuncionarioController thc = loader.getController();
            thc.setPerfil(f);
            thc.setStage(home);
            thc.setTextButon("Cadastrar");
            thc.setTextLabel("Cadastro de Funcionário");

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) menuBar.getScene().getWindow()).close();
    }
    
    //Metodo pra trocar de tela para editar
    public static void trocarCadFuncionario(TableView tabela, Perfil f, Funcionario funcionario) throws IOException {
        Stage home = new Stage();
        home.setMaximized(true);
        home.setTitle("Edição de Funcionário");

        URL url = new File("src/main/java/view/CadastrarFuncionario.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        CadastrarFuncionarioController thc = loader.getController();
            thc.setPerfil(f);
            thc.setStage(home);
            thc.setTextButon("Editar");
            thc.setTextLabel("Edição de Funcionário");
            thc.setValores(funcionario);

        Scene cena = new Scene(root);
        home.setScene(cena);
        home.show();

        ((Stage) tabela.getScene().getWindow()).close();
    }

    public boolean CadastroDeFuncionario() {
        String cpfSemPontos = txtCpf.getText().replaceAll("[.-]", "");
        long Cpf = Long.parseLong(cpfSemPontos);
        String NomeFuncionario = txtNome.getText();
        LocalDate DataNascimento = txtNascimento.getValue();
        String Telefone = txtContato.getText();
        String Email = txtEmail.getText();
        String valorComPonto = txtSalario.getText().replaceAll("[,]", ".");
        float ValorHora = Float.parseFloat(valorComPonto);
        String Cargo = cbCargo.getSelectionModel().getSelectedItem();

        Funcionario f = new Funcionario(Cpf, NomeFuncionario, DataNascimento, Telefone, Email, ValorHora, Cargo);
        FuncionarioDAO FuncaMetodo = new FuncionarioDAO();
        return FuncaMetodo.cadastroFuncionario(f);

    }

    public void setStage(Stage home) {
      this.stage = home;  
    }
    
    public void setTextButon(String txtButton){
        btnCadastroFunca.setText(txtButton);
    }
    
    public void setTextLabel(String txtLabel){
        lblTitulo.setText(txtLabel);
    }
    
    long cpfItemTrocado;
    public void setValores(Funcionario f){
            cpfItemTrocado = f.getCpf();
            txtNome.setText(f.getNomeFuncionario());
            txtCpf.setText(String.valueOf(f.getCpf()).replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4"));
            txtContato.setText(f.getTelefone().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3"));
            txtNascimento.setValue(f.getDataNascimento());
            txtEmail.setText(f.getEmail());
            String salarioFormatado = String.valueOf(f.getValorHora()).replaceAll("[.]", ",");
            txtSalario.setText(salarioFormatado);
            cbCargo.setValue(f.getCargo());
    }
}
