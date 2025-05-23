package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.Fornecedor;
import model.FornecedorDAO;
import util.Alertas;
import util.Validacao;

public class CadastrarFornecedorController {
    
       private ArrayList<Fornecedor> userInfo = new ArrayList<>();
    public ArrayList<Fornecedor> getUserInfo() {
        return userInfo;
    }  

    @FXML
    private MenuBar MenuBar;
    
    @FXML
    private Button btnCadastrarForn;

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
    private TextField txtCnpj;

    @FXML
    private TextField txtContato;

  /*  @FXML
    private TextField txtEndereco;*/

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;
    
    
    Faccao f;
     public Stage stage;
     
    public void setFaccao(Faccao f) {
        this.f=f;
    }
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();

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
    void OnClickVoltar(ActionEvent event) throws IOException {
        //Verificação de itemisEmpty para mostrar alerta CONFIRMATION
        TelaHomeController.trocarTelaHome(btnVoltar, f);
    }
    
    @FXML
    void OnClickCadastrarForn(ActionEvent event) {
        long cnpjnum;
        
        if(validacao.itemisEmpty(txtCnpj.getText(),"CNPJ")){
            return;
        } else { 
            String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
            cnpjnum = Long.parseLong(cnpjSemPontos);
        }
        if (validacao.ValidaFormatoCnpj(txtCnpj.getText())) {
            return;
        } else if (validacao.ValidaTamanhoText(18,txtCnpj.getText(), "CNPJ")) {
            return;
        }else if(validacao.ItemCNPJnoSistema(txtCnpj.getText(), "fornecedor", "CnpjFornecedor", cnpjnum)){
            return;
            
        }else if(validacao.itemisEmpty(txtEmail.getText(),"Email")){
            return;
        }else if(validacao.ValidaFormatEmail(txtEmail.getText())){
            return;
            
        }else if(validacao.itemisEmpty(txtContato.getText(),"Telefone")){
            return;
        }else if(validacao.ValidaFormatTell(txtContato.getText())){
            return;
        }else if (validacao.ValidaTamanhoText(15,txtContato.getText(), "Telefone")) {
            return;
            
        }else if (validacao.itemisEmpty(txtNome.getText(),"Nome")) {
            return;
            
        }
        
        if (CadastroDeFornecedor() != true) { 
            alertas.alertaError("Erro ao cadastrar ", "Erro ao cadastrar o Fornecedor");
        } else {
            alertas.alertaInformation("Cadastro realizado com sucesso", "O Fornecedor foi cadastrado com sucesso");
        }
    }
    
    //metodo para trocar tela para cadastrar fornecedor
    public static void trocarCadFornecedor(MenuBar menuBar, Faccao f)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("Cadastro de Fornecedor");

            URL url = new File("src/main/java/view/CadastrarFornecedor.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            CadastrarFornecedorController thc = loader.getController();
            thc.setFaccao(f);
            thc.setStage(home);
            
           
            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) menuBar.getScene().getWindow()).close();
    }
    
     public boolean CadastroDeFornecedor() {
         //Perfil?
         String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
        long CNPJFornecedor = Long.parseLong(cnpjSemPontos);
        String NomeRepreFornecedor = txtNome.getText();
        String Senha = txtContato.getText();
        String EmailAcesso = txtEmail.getText();
       
        Fornecedor f = new Fornecedor(CNPJFornecedor, NomeRepreFornecedor, Senha, EmailAcesso);
        FornecedorDAO FornecMetodo = new FornecedorDAO();
        return FornecMetodo.cadastroFornecedor(f);

    }


    public void setStage(Stage home) {
        this.stage = home;
    }

}
