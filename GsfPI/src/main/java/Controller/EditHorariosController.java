package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Faccao;
import model.Ponto;
import model.PontoDAO;
import util.Alertas;

public class EditHorariosController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnConfirmar;

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

    public static void trocarTelaEditHora(TableView t, Faccao f, Ponto p) throws IOException{
        Stage ponto = new Stage();
        ponto.setMaximized(true);
        ponto.setTitle("Editar Horários");

        URL url = new File("src/main/java/view/EditHorarios.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        
        EditHorariosController thc = loader.getController();
        thc.setFaccao(f);
        thc.setValores(p);
        thc.setStage(ponto);

        Scene cena = new Scene(root);
        ponto.setScene(cena);
        ponto.show();
        
        ((Stage) t.getScene().getWindow()).close();
    }
    
    private Stage stage;
    
    public void setStage(Stage visuPonto) {
        this.stage = visuPonto;
    }
    
    Faccao f;
    public void setFaccao(Faccao f) {
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
    
    @FXML
    void onClickConfirmar(ActionEvent event) throws IOException {
        //Fazer Verificações
        LocalTime hem, hev, hsm, hsv, hee, hse;
        if(txtEntradaM.getText().equals("")){
            hem = null;
        }else{
            hem = LocalTime.parse(txtEntradaM.getText());
        }
        
        if(txtEntradaV.getText().equals("")){
            hev = null;
        }else{
            hev = LocalTime.parse(txtEntradaV.getText());
        }
        
        if(txtEntradaE.getText().equals("")){
            hee = null;
        }else{
            hee = LocalTime.parse(txtEntradaE.getText());
        }
        
        if(txtSaidaM.getText().equals("")){
            hsm = null;
        }else{
            hsm = LocalTime.parse(txtSaidaM.getText());
        }
        
        if(txtSaidaV.getText().equals("")){
            hsv = null;
        }else{
            hsv = LocalTime.parse(txtSaidaV.getText());
        }
        
        if(txtSaidaE.getText().equals("")){
            hse = null;
        }else{
            hse = LocalTime.parse(txtSaidaE.getText());
        }
        
        Ponto pUpdate = new Ponto(pontoSalvo.getId(), pontoSalvo.getCpf(), pontoSalvo.getData(), hem, hsm, hev, hsv, hee, hse);
       
        if(metodo.editarHorario(pUpdate)){
            alertas.alertaInformation("Edição Concluída", "A edição foi feita com sucesso!");
            VisualizarPontoController.trocarVizPonto(btnConfirmar, f);
        }else{
            alertas.alertaError("Erro ao editar", "Erro ao editar!");
        }
    }
   
}
    

