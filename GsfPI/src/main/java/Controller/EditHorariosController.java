package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Funcionario;
import model.FuncionarioDAO;
import model.Perfil;
import model.Ponto;
import model.PontoDAO;
import util.Alertas;
import util.Validacao;

public class EditHorariosController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;
    
    @FXML
    private MenuBar MenuBar;
    
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
    private Label lblTitulo;

    @FXML
    private TextField txtEntradaE;

    @FXML
    private TextField txtEntradaM;

    @FXML
    private TextField txtEntradaV;

    @FXML
    private TextField txtSaidaE;

    @FXML
    private TextField txtSaidaM;

    @FXML
    private TextField txtSaidaV;

    public static void trocarTelaEditHora(TableView t, Perfil f, Ponto p) throws IOException{
        Stage ponto = new Stage();
        ponto.setTitle("Editar Horários");

        URL url = new File("src/main/java/view/EditHorarios.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        EditHorariosController thc = loader.getController();
        thc.setPerfil(f);
        thc.setValores(p);
        thc.setStage(ponto);

        ponto.initOwner(t.getScene().getWindow());
        ponto.initModality(javafx.stage.Modality.WINDOW_MODAL);
        ponto.setResizable(false);
        
        Scene cena = new Scene(root);
        ponto.setScene(cena);
        ponto.showAndWait();
        
        ((Stage) t.getScene().getWindow()).close();
    }
    
    private Stage stage;
    
    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }
    
    Perfil f;
    public void setPerfil(Perfil f) {
        this.f = f; 
    }
    
    Ponto pontoSalvo; 
    public void setValores(Ponto p){
         if(p.getHoraEntradaM() == null){
             txtEntradaM.setText("");
         }else{
            txtEntradaM.setText(String.valueOf(p.getHoraEntradaM()));
         }
         
         if(p.getHoraSaidaM() == null){
             txtSaidaM.setText("");
         }else{
            txtSaidaM.setText(String.valueOf(p.getHoraSaidaM()));
         }
         
         if(p.getHoraEntradaV() == null){
             txtEntradaV.setText("");
         }else{
            txtEntradaV.setText(String.valueOf(p.getHoraEntradaV()));
         }
         
         if(p.getHoraSaidaV() == null){
             txtSaidaV.setText("");
         }else{
            txtSaidaV.setText(String.valueOf(p.getHoraSaidaV()));
         }
         
         if(p.getHorarioEntradaEx() == null){
             txtEntradaE.setText("");
         }else{
            txtEntradaE.setText(String.valueOf(p.getHorarioEntradaEx()));
         }
         if(p.getHorarioSaidaEx() == null){
             txtSaidaE.setText("");
         }else{
            txtSaidaE.setText(String.valueOf(p.getHorarioSaidaEx()));
         }
         pontoSalvo = p;
     }
     
    @FXML
    void onClickCancelar(ActionEvent event) throws IOException {
        VisualizarPontoController.trocarVizPonto(btnCancelar, f);
    }
    
    Alertas alertas = new Alertas();
    PontoDAO metodo = new PontoDAO();
    FuncionarioDAO fmetodo = new FuncionarioDAO();
    Validacao validacao = new Validacao();
    @FXML
    void onClickConfirmar(ActionEvent event) throws IOException, SQLException {
        //Fazer Verificações
        LocalTime hem, hev, hsm, hsv, hee, hse;
        float salario = 0, horaS = 0, horaE=0;
        Funcionario fun = fmetodo.select(pontoSalvo.getCpf());
        String txthoraS, txthoraE;
        //Periodo Matutino 
        if(txtEntradaM.getText().equals("")){
            hem = null;
        }else{
            String[] partes = txtEntradaM.getText().split(":");
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
            String horaFormatada = String.format("%02d:%02d", hora, minuto);
            hem = LocalTime.parse(horaFormatada);
            
            txthoraE = String.valueOf(hem).replaceAll("[:]", ".");
            horaE = Float.parseFloat(txthoraE);
        }
        
        if(txtSaidaM.getText().equals("")){
            hsm = null;
        }else{
            String[] partes = txtSaidaM.getText().split(":");
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
            String horaFormatada = String.format("%02d:%02d", hora, minuto);
            hsm = LocalTime.parse(horaFormatada);
            
            txthoraS = String.valueOf(hsm).replaceAll("[:]", ".");
            horaS = Float.parseFloat(txthoraS);
        }
        
        if(horaE == 0 && horaS == 0){
           horaE = 1; 
           horaS = 1; 
        }else if(horaE == 0 || horaS == 0){        
            alertas.alertaError("Horário Matutino Incompleto", "Informe os valores de Entrada e Saída!");
            return;
        }else{
            salario = (horaS - horaE) * fun.getValorHora();
            horaE = 0; 
            horaS = 0; 
        }
        
        //Periodo Vespertino
        if(txtEntradaV.getText().equals("")){
            hev = null;
        }else{
            String[] partes = txtEntradaV.getText().split(":");
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
            String horaFormatada = String.format("%02d:%02d", hora, minuto);
            hev = LocalTime.parse(horaFormatada);
            
            txthoraE = String.valueOf(hev).replaceAll("[:]", ".");
            horaE = Float.parseFloat(txthoraE);
        }
        
        if(txtSaidaV.getText().equals("")){
            hsv = null;
        }else{
            String[] partes = txtSaidaV.getText().split(":");
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
            String horaFormatada = String.format("%02d:%02d", hora, minuto);
            hsv = LocalTime.parse(horaFormatada);
            
            txthoraS = String.valueOf(hsv).replaceAll("[:]", ".");
            horaS = Float.parseFloat(txthoraS);
        }
        
        if(horaE == 0 && horaS == 0){
           horaE = 1; 
           horaS = 1; 
        }else if(horaE == 0 || horaS == 0){        
            alertas.alertaError("Horário Vespertino Incompleto", "Informe os valores de Entrada e Saída!");
            return;
        }else{
            salario = ((horaS - horaE) * fun.getValorHora())+ salario;
            horaE = 0; 
            horaS = 0; 
        }
        
        //Periodo Extra
        if(txtEntradaE.getText().equals("")){
            hee = null;
        }else{
            String[] partes = txtEntradaE.getText().split(":");
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
            String horaFormatada = String.format("%02d:%02d", hora, minuto);
            hee = LocalTime.parse(horaFormatada);
            
            txthoraE = String.valueOf(hee).replaceAll("[:]", ".");
            horaE = Float.parseFloat(txthoraE);
        }
        
        if(txtSaidaE.getText().equals("")){
            hse = null;
        }else{
            String[] partes = txtSaidaE.getText().split(":");
            int hora = Integer.parseInt(partes[0]);
            int minuto = Integer.parseInt(partes[1]);
            String horaFormatada = String.format("%02d:%02d", hora, minuto);
            hse = LocalTime.parse(horaFormatada);
            
            txthoraS = String.valueOf(hse).replaceAll("[:]", ".");
            horaS = Float.parseFloat(txthoraS);
        }
        
        if(horaE == 0 && horaS == 0){
           horaE = 1; 
           horaS = 1; 
        }else if(horaE == 0 || horaS == 0){        
            alertas.alertaError("Horário Extra Incompleto", "Informe os valores de Entrada e Saída!");
        }else{
            salario = ((horaS - horaE) * fun.getValorHora())+ salario;
        }
        
        Ponto pUpdate = new Ponto(pontoSalvo.getId(), pontoSalvo.getCpf(), pontoSalvo.getData(), hem, hsm, hev, hsv, hee, hse, salario);
       
        if(metodo.editarHorario(pUpdate)){
            alertas.alertaInformation("Edição Concluída", "Edição concluída com sucesso!");
            VisualizarPontoController.trocarVizPonto(btnConfirmar, f);
        }else{
            alertas.alertaError("Erro ao editar", "Erro ao editar!");
        }
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
   
}
    

