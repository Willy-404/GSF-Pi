package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Faccao;
import model.FaccaoDAO;
import model.Fornecedor;
import model.FornecedorDAO;
import model.Perfil;
import model.PerfilDAO;
import model.TipoPerfil;
import util.Alertas;
import util.Validacao;

public class VisualizarPerfilController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnSairDoPerfil;

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
    private Menu menuCadastar;

    @FXML
    private TextField txtCnpj;

    @FXML
    private TextField txtContato;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtNome;
    
    @FXML
    private PasswordField txtSenha;
    
    @FXML
    private Label lblEndereco;
    
    @FXML
    private ImageView ImageSenha;
    
    @FXML
    private TextField txtSenhaVisivel;
    
     @FXML
    void onClickVerSenha(MouseEvent event) {
        if(txtSenha.isVisible()){
            String senha = txtSenha.getText();
            txtSenhaVisivel.setText(senha);
            txtSenha.setVisible(false);
            txtSenhaVisivel.setVisible(true);
            
        }else{
            String senha = txtSenhaVisivel.getText();
            txtSenha.setText(senha);
            txtSenhaVisivel.setVisible(false);
            txtSenha.setVisible(true);
        }
    }
    
    Alertas alertas = new Alertas();
    Validacao validacao = new Validacao();
    
    //Retorno dos valores da faccao Logada no sistema 
    FaccaoDAO fd = new FaccaoDAO();
    FornecedorDAO fmetodo = new FornecedorDAO();
    Perfil p;
    Faccao faccao = null;
    Fornecedor forne = null;
    boolean isFaccao;
   public Stage stage;
   
   
    public void setPerfil(Perfil f) throws SQLException {
        this.p=f;
        if(f.getTipoPerfil().toString().equals("Faccao")){
           faccao = fd.selecionar(f.getCNPJ());
           txtCnpj.setText(String.valueOf(faccao.getCNPJFaccao()).replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5"));
           txtContato.setText(faccao.getTelefone().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3"));
           txtEmail.setText(faccao.getEmailAcesso());
           txtNome.setText(faccao.getNomeRepreFaccao());
           txtSenha.setText(faccao.getSenha()); 
           lblEndereco.setVisible(false);
           txtEndereco.setVisible(false);
           isFaccao = true;
        }else{
            System.out.println(f.getCNPJ()+ " Fornecedor");
            forne = fmetodo.selecionar(f.getCNPJ());
            txtCnpj.setText(String.valueOf(forne.getCnpjFornecedor()).replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5"));
            txtNome.setText(forne.getNomeRepreFornecedor());
            txtEmail.setText(forne.getUsuarioFornecedor());
            txtSenha.setText(forne.getSenha());
            txtContato.setText(forne.getTelefone().replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3"));
            
            lblEndereco.setVisible(true);
            txtEndereco.setVisible(true); 
            txtEndereco.setText(forne.getEndereco());
            
            isFaccao = false;
        }
        
    }
        
    @FXML
    void OnClickCadFornecedor1(ActionEvent event) throws IOException {
       CadastrarFornecedorController.trocarCadFornecedor(MenuBar, p);
    }

    @FXML
    void OnClickCadFuncionario1(ActionEvent event) throws IOException {
        CadastrarFuncionarioController.trocarCadFuncionario(MenuBar, p);
    }

    @FXML
    void OnClickCadLote1(ActionEvent event) throws IOException {
        CadastroLotesController.trocarCadLotes(MenuBar, p);
    }

    @FXML
    void OnClickVisuFornecedor1(ActionEvent event) throws IOException {
        VisualizarFornecedorController.trocarVizFornecedor(MenuBar, p);
    }

    @FXML
    void OnClickVisuFuncionario1(ActionEvent event) throws IOException {
         VisualizarFuncionarioController.trocarVizFuncionario(MenuBar, p);
    }

    @FXML
    void OnClickVisuLote1(ActionEvent event) throws IOException {
        VisualizarLotesController.trocarVizLotes(MenuBar, p);
    }

    @FXML
    void OnClickVisuPonto1(ActionEvent event) throws IOException {
        VisualizarPontoController.trocarVizPonto(MenuBar, p);
    }

    @FXML
    void OnClickVisuTelaHome(ActionEvent event) throws IOException {
        TelaHomeController.trocarTelaHome(MenuBar, p);
    }
    
    @FXML
    void OnClickSair(ActionEvent event) throws IOException  {
        LoginController lc = new LoginController();
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Logoff");
        alerta.setHeaderText("Deseja fazer a saida do sistema?");
        alerta.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try{
                    lc.trocarLogin(btnSairDoPerfil);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }else{
                  alertas.alertaInformation("Logoff Cancelado", "Logoff foi cancelado com sucesso!");
            }
        });  
    }
    
      @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
        //Fazer validação para ver se algum dado foi alterado para mostrar o alert CONFIRMATION
        TelaHomeController.trocarTelaHome(btnVoltar, p);
    }
    
     @FXML
    void OnClickEditar(ActionEvent event) throws IOException {
        //seleciona o id da faccao que será modificada
        String cnpjSemTraço = txtCnpj.getText().replaceAll("[./-]", "");
        long cnpjT = Long.parseLong(cnpjSemTraço);
        String NomeRepreT = txtNome.getText();
        String EmailAcessoT = txtEmail.getText();
        String SenhaT;
            if(txtSenha.isVisible()){
                SenhaT = txtSenha.getText();
            }else{
                SenhaT = txtSenhaVisivel.getText();
            }
        String TelefoneT = txtContato.getText();
        String EnderecoT = txtEndereco.getText();
        PerfilDAO pmetodo = new PerfilDAO();
        
        if (validacao.ValidaFormatoCnpj(txtCnpj.getText())) {
            return;
        } else if ((validacao.ValidaTamanhoText(18,txtCnpj.getText()))&& (validacao.ValidaTamanhoText(14,txtCnpj.getText()))) {
            alertas.alertaError("Tamanho do campo CNPJ Incompativel","Tamanho do texto digitado no campo CNPJ fora do permitido!");
            return;
        }else if(validacao.ItemCNPJnoSistema(txtCnpj.getText(), "fornecedor", "CnpjFornecedor", cnpjT)){
                return;
         }else if(validacao.itemisEmpty(txtCnpj.getText(),"CNPJ")){
            return;
            
         }else if(validacao.itemisEmpty(txtEmail.getText(),"Email")){
            return;
        }else if(validacao.ValidaFormatEmail(txtEmail.getText())){
            return;
        }else if(validacao.ItemEmailnoSistema(txtEmail.getText(), "fornecedor", "UsuarioFornecedor", txtEmail.getText())){
            return;
            
         }else if(validacao.itemisEmpty(txtContato.getText(),"Contato")){
            return;
        }else if(validacao.ValidaFormatTell(txtContato.getText())){
            return;
        }else if ((validacao.ValidaTamanhoText(15,txtContato.getText())) && (validacao.ValidaTamanhoText(11,txtContato.getText()))) {
            alertas.alertaError("Tamanho do campo Telefone Incompativel!","Tamanho do texto digitado no campo Telefone fora do permitido!");
            return;
            
         }else if(validacao.itemisEmpty(txtNome.getText(),"Nome")){
            return;
            
         }else if(validacao.itemisEmpty(txtSenha.getText(), "Senha")){
            return;
        }else if(txtSenha.isVisible()){
            if(validacao.itemisEmpty(txtSenha.getText(),"Senha")){
                return;
            }
        }else if(txtSenhaVisivel.isVisible()){
            if(validacao.itemisEmpty(txtSenhaVisivel.getText(),"Senha")){
                return;
            }   
         }else if(txtSenha.getText().length() > 20){
            alertas.alertaError("Tamanho do campo Senha Incompativel","Tamanho do texto digitado no campo Senha fora do permitido!");
            return;
          
         }
        //fazendo o edit de Perfil e dos respectivos usuarios
        if(isFaccao){
            long id = (faccao.getCNPJFaccao());
             TipoPerfil perfil = TipoPerfil.FACCAO;
             
            Faccao fTroca = new Faccao(cnpjT,NomeRepreT,EmailAcessoT,SenhaT,TelefoneT);
            Perfil Ptroca = new Perfil(cnpjT, EmailAcessoT, SenhaT, perfil);
            FaccaoDAO fmetodo = new FaccaoDAO();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Editar?");
            alerta.setHeaderText("Deseja fazer a edição das informações?");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    if(fmetodo.editarFaccao(fTroca, id) != true || pmetodo.editarPerfilCnpj(Ptroca, id) != true){
                        alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
                    }else{
                        alertas.alertaInformation("Edição Concluida", "Edição concluída com sucesso!");
                        try {
                            setPerfil(Ptroca);
                            TelaHomeController.trocarTelaHome(btnEditar, p);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            Logger.getLogger(VisualizarPerfilController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    alertas.alertaInformation("Edição Cancelada", "Edição cancelada com sucesso!!");
                }
            });     
        }else{
           if(validacao.itemisEmpty(txtEndereco.getText(),"Endereço")){
                return; 
           }
            long id = (forne.getCnpjFornecedor());
            TipoPerfil perfil = TipoPerfil.FORNECEDOR;
            
            Fornecedor fTroca = new Fornecedor(cnpjT,NomeRepreT, EmailAcessoT, SenhaT, TelefoneT, EnderecoT);
            Perfil Ptroca = new Perfil(cnpjT, EmailAcessoT, SenhaT, perfil);
            FornecedorDAO fmetodo = new FornecedorDAO();
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Editar?");
            alerta.setHeaderText("Deseja fazer a edição das informações?");
            alerta.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    if(fmetodo.editarFornecedor(fTroca, id) != true || pmetodo.editarPerfilCnpj(Ptroca, id) != true){
                        alertas.alertaError("Erro na Edição", "Ocorreu um problema na edição!");
                    }else{
                        alertas.alertaInformation("Edição Concluida", "Edição concluída com sucesso!");
                        try {
                            setPerfil(Ptroca);TelaHomeController.trocarTelaHome(btnEditar, p);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (IOException ex) {
                            Logger.getLogger(VisualizarPerfilController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }else{
                    alertas.alertaInformation("Edição Cancelada", "Edição cancelada com sucesso!!");
                }
            });     
        }
        
    }

   public static void TrocarVisualizarPerfil(Button btnPerfil, Perfil f) throws IOException, SQLException {
        Stage visuPerfil = new Stage();
        visuPerfil.setMaximized(true);
        visuPerfil.setTitle("Visualizar Perfil");

        URL url = new File("src/main/java/view/VisualizarPerfil.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
          VisualizarPerfilController thc = loader.getController();
            thc.setPerfil(f);
            thc.setStage(visuPerfil);

        Scene cena = new Scene(root);
        visuPerfil.setScene(cena);
        visuPerfil.show();
        
        ((Stage) btnPerfil.getScene().getWindow()).close();
        
    }

    public void setStage(Stage visuPerfil) {
        this.stage = visuPerfil;
    }

   
}