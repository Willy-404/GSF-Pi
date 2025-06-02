package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import model.Faccao;
import util.Alertas;
import util.Validacao;

public class PontoEletronicoController {

    @FXML
    private MenuBar MenuBar;

    @FXML
    private Button btnConfirmarPonto;

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
    Faccao f;

    public void setFaccao(Faccao f) {
        this.f = f; 
    }
    
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
    
    Alertas alertas = new Alertas();
    
      @FXML
    void OnClickConfirmarPonto(ActionEvent event) {
        Long cpfnum;
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
        }
        
        if(validacao.ValidaCPFExiste(txtCpfPonto.getText(), "funcionario", "Cpf", cpfnum)){
            return;  
        }else{
            
            
        }
        
    }

    

}
