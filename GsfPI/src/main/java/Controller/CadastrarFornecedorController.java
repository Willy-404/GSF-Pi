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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.Fornecedor;
import model.FornecedorDAO;
import model.Perfil;
import model.PerfilDAO;
import model.TipoPerfil;
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
    private PasswordField txtSenha;

    @FXML
    private TextField txtEndereco;
    
    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;
    
      @FXML
    private Label lblTitulo;
    
    Perfil f;
     public Stage stage;
     
    public void setPerfil(Perfil f) {
        this.f=f;
    }
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();

    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
        if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                        CadastrarFornecedorController.trocarCadFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
        if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
        if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty()  && txtEndereco.getText().isEmpty()) {
                        CadastroLotesController.trocarCadLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
        if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                         VisualizarFornecedorController.trocarVizFornecedor(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
                alerta.setHeaderText("Ao sair as informações alteradas serão perdidas! ");
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
         if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                       VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, f); 
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
         if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                        VisualizarLotesController.trocarVizLotes(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
         if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                        VisualizarPontoController.trocarVizPonto(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
         if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                        TelaHomeController.trocarTelaHome(MenuBar, f);
        } else {
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Sair?");
            if(btnCadastrarForn.getText().equals("Editar")){
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
    void OnClickVoltar(ActionEvent event) throws IOException {
        //Verificação de itemisEmpty para mostrar alerta CONFIRMATION
            if (txtCnpj.getText().isEmpty() && txtEmail.getText().isEmpty() && txtNome.getText().isEmpty()
                &&  txtContato.getText().isEmpty() && txtEndereco.getText().isEmpty()) {
                TelaHomeController.trocarTelaHome(btnVoltar, f);
            } else {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Sair?");
                if(btnCadastrarForn.getText().equals("Editar")){
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
    void OnClickCadastrarForn(ActionEvent event) throws IOException {
        long cnpjnum;
        boolean isEdit = false;
        if(btnCadastrarForn.getText().equals("Editar")){
            isEdit = true;
        }
        
        if(validacao.itemisEmpty(txtCnpj.getText(),"CNPJ")){
            return;
        } else { 
            String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
            cnpjnum = Long.parseLong(cnpjSemPontos);
        }
        if (validacao.ValidaFormatoCnpj(txtCnpj.getText())) {
            return;
        } else if ((validacao.ValidaTamanhoText(18,txtCnpj.getText()))&& (validacao.ValidaTamanhoText(14,txtCnpj.getText()))) {
            alertas.alertaError("Tamanho do campo CNPJ Incompativel","Tamanho do texto digitado no campo CNPJ fora do permitido!");
            return;
        }else if(isEdit == false){
            if(validacao.ItemCNPJnoSistema(txtCnpj.getText(), "fornecedor", "CnpjFornecedor", cnpjnum)){
                return;
            }
        }else if(validacao.itemisEmpty(txtEmail.getText(),"Email")){
            return;
        }else if(validacao.ValidaFormatEmail(txtEmail.getText())){
            return;
        }else if(validacao.ItemEmailnoSistema(txtEmail.getText(), "fornecedor", "UsuarioFornecedor", txtEmail.getText())){
            return;
              
        }else if (validacao.itemisEmpty(txtNome.getText(),"Nome")) {
            return;
            
        }else if(validacao.itemisEmpty(txtSenha.getText(), "Senha")){
            return;
        }else if(txtSenha.getText().length() > 20){
            alertas.alertaError("Tamanho do campo Senha Incompativel","Tamanho do texto digitado no campo Senha fora do permitido!");
            return;
            
        }else if(validacao.itemisEmpty(txtContato.getText(),"Telefone")){
            return;
        }else if(validacao.ValidaFormatTell(txtContato.getText())){
            return;
        }else if ((validacao.ValidaTamanhoText(15,txtContato.getText())) && (validacao.ValidaTamanhoText(11,txtContato.getText()))) {
            alertas.alertaError("Tamanho do campo Telefone Incompativel!","Tamanho do texto digitado no campo Telefone fora do permitido!");
            return;
            
        }else if(validacao.itemisEmpty(txtEndereco.getText(), "Endereco")){
            return;
        }
        
        if(isEdit == false){
            if (CadastroDeFornecedor() != true) { 
                alertas.alertaError("Erro ao cadastrar ", "Erro ao cadastrar o Fornecedor");
            } else {
                 String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
                long Cnpj = Long.parseLong(cnpjSemPontos);
                String EmailAcesso = txtEmail.getText();
                String Senha = txtSenha.getText();
                TipoPerfil perfil = TipoPerfil.FORNECEDOR;
            
                Perfil p = new Perfil(Cnpj, EmailAcesso, Senha, perfil);
                PerfilDAO pmetodo = new PerfilDAO();
                pmetodo.cadastroPerfil(p);
                
                alertas.alertaInformation("Cadastro realizado com sucesso", "Fornecedor cadastrado com sucesso");
                txtCnpj.setText("");
                txtContato.setText("");
                txtEmail.setText("");
                txtSenha.setText("");
                txtNome.setText("");
                txtEndereco.setText("");
            }
        }else{
            FornecedorDAO fornecedorMetodo = new FornecedorDAO();
                
            String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
            long CNPJFornecedor = Long.parseLong(cnpjSemPontos);
            String NomeRepreFornecedor = txtNome.getText();
            String Senha = txtSenha.getText();
            String EmailAcesso = txtEmail.getText();
            String Telefone = txtContato.getText();
            String Endereco = txtEndereco.getText();
            TipoPerfil perfil = TipoPerfil.FORNECEDOR;
            
            Perfil p = new Perfil(CNPJFornecedor, EmailAcesso, Senha, perfil);
            PerfilDAO pmetodo = new PerfilDAO();
            
            Fornecedor fornecedor = new Fornecedor(CNPJFornecedor, NomeRepreFornecedor, EmailAcesso, Senha, Telefone, Endereco);
            if(fornecedorMetodo.editarFornecedor(fornecedor, cnpjItemTrocado) != true || pmetodo.editarPerfilCnpj(p, cnpjItemTrocado) != true){
                 alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
            }else {
                 alertas.alertaInformation("Edição Concluida", "Edição concluída com sucesso!");
                 VisualizarFornecedorController.trocarVizFornecedor(btnCadastrarForn, f);
            }
        }
    }
    
    //metodo para trocar tela para cadastrar fornecedor
    public static void trocarCadFornecedor(MenuBar menuBar, Perfil f)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("Cadastro de Fornecedor");

            URL url = new File("src/main/java/view/CadastrarFornecedor.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            CadastrarFornecedorController thc = loader.getController();
            thc.setPerfil(f);
            thc.setStage(home);
            thc.setTextButon("Cadastrar");
            thc.setTextLabel("Cadastro de Fornecedor");
           
            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) menuBar.getScene().getWindow()).close();
    }
    
     //Metodo pra trocar de tela para editar
    public static void trocarCadFornecedor(TableView tabela, Perfil f, Fornecedor fornecedor)throws IOException {
          Stage home = new Stage();
            home.setMaximized(true);
            home.setTitle("Edição de Fornecedor");

            URL url = new File("src/main/java/view/CadastrarFornecedor.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            CadastrarFornecedorController thc = loader.getController();
            thc.setPerfil(f);
            thc.setStage(home);
            thc.setTextButon("Editar");
            thc.setTextLabel("Edição de Fornecedor");
            thc.setValores(fornecedor);
           
            Scene cena = new Scene(root);
            home.setScene(cena);
            home.show();

            ((Stage) tabela.getScene().getWindow()).close();
    }
    
     public boolean CadastroDeFornecedor() {
         //Perfil?
         String cnpjSemPontos = txtCnpj.getText().replaceAll("[./-]", "");
        long CNPJFornecedor = Long.parseLong(cnpjSemPontos);
        String NomeRepreFornecedor = txtNome.getText();
        String Senha = txtSenha.getText();
        String EmailAcesso = txtEmail.getText();
        String Telefone = txtContato.getText();
        String Endereco = txtEndereco.getText();
       
        Fornecedor f = new Fornecedor(CNPJFornecedor, NomeRepreFornecedor,EmailAcesso, Senha, Telefone, Endereco);
        FornecedorDAO FornecMetodo = new FornecedorDAO();
        return FornecMetodo.cadastroFornecedor(f);

    }


    public void setStage(Stage home) {
        this.stage = home;
    }
    public void setTextButon(String txtButton){
        btnCadastrarForn.setText(txtButton);
    }
    
    public void setTextLabel(String txtLabel){
        lblTitulo.setText(txtLabel);
    }
    Long cnpjItemTrocado;
    public void setValores (Fornecedor f){
        cnpjItemTrocado = f.getCnpjFornecedor();
        txtCnpj.setText(String.valueOf(f.getCnpjFornecedor()).replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5"));
        txtContato.setText(f.getTelefone().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3"));
        txtEmail.setText(f.getUsuarioFornecedor());
        txtSenha.setText(f.getSenha());
        txtNome.setText(f.getNomeRepreFornecedor());
        txtEndereco.setText(f.getEndereco());
    }
}
