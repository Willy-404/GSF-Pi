package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class LotesDAO extends GenericDAO {
    private int Referencia;
    private LocalDate Prazo;
    private LocalDate Entrada;
    private Double Preco;
    private String Tecido; 
    private String Marca;
    private String Colecao;
    private String Modelo;
    private String Tamanho;
    private int Quantidade;
    private String Linha;
    
    private TableView<Lotes> tabelaLotes;
    private TableColumn<Lotes, Integer> colRef;
    private TableColumn<Lotes, Integer> colQuanti;
    private TableColumn<Lotes, LocalDate> colPrazo;
  
    public boolean cadastroLotes(Lotes l){
    String sql = "INSERT INTO lote (Referencia, Prazo, Entrada, Preco, Tecido, Marca, Colecao, Modelo, Tamanho, Quantidade, Linha) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    try  {
            save(sql, l);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Lotes listarLotes(Lotes l, Integer ref){
        String sql ="Select* FROM lote WHERE (Referencia = ref) ";
        /*Pegar a lista com o metodo list (quando for feito), Mas preciso retornar os valores entao tem que retornar um Lote
        try {
            list(sql, l);
            
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        */
        
        
        return l;
    }

    public int getReferencia() {
        return Referencia;
    }

    public void setReferencia(int Referencia) {
        this.Referencia = Referencia;
    }

    public LocalDate getPrazo() {
        return Prazo;
    }

    public void setPrazo(LocalDate Prazo) {
        this.Prazo = Prazo;
    }

    public LocalDate getEntrada() {
        return Entrada;
    }

    public void setEntrada(LocalDate Entrada) {
        this.Entrada = Entrada;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double Preco) {
        this.Preco = Preco;
    }

    public String getTecido() {
        return Tecido;
    }

    public void setTecido(String Tecido) {
        this.Tecido = Tecido;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getColecao() {
        return Colecao;
    }

    public void setColecao(String Colecao) {
        this.Colecao = Colecao;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getLinha() {
        return Linha;
    }

    public void setLinha(String Linha) {
        this.Linha = Linha;
    }
    
    
}
   
        
    

