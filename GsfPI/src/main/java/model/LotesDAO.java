package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
  
    public boolean cadastroLotes(Lotes l){
    String sql = "INSERT INTO lote (Referencia, Prazo, Entrada, Preco, Tecido, Marca, Colecao, Modelo, Tamanho, Quantidade, Linha) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    try  {
            save(sql, l.getReferencia(), l.getPrazo(), l.getEntrada(), l.getPreco(), l.getTecido(), l.getMarca(), l.getColecao(), l.getModelo(),
                    l.getTamanho(), l.getQuantidade(), l.getLinha());
            return true;
        } catch (SQLException e) {  
            e.printStackTrace();
            return false;
        }
    }

    //int ref tem que ser pego quando clicado no tableView isso é possivel?
    public List<Lotes> listarLotes(Lotes l, int ref){
        String sql ="Select* FROM lote ";
        List<Lotes> resultList = new ArrayList<Lotes>();

        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            // Set parameters for the prepared statement if needed
             preparedStatement.setInt(1, ref);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Create a new object for each row
                    LocalDate data;
                    data = LocalDate.parse(resultSet.getString("Prazo"));
                            
                    Lotes object = new Lotes(resultSet.getInt("ref"), data, resultSet.getInt("Quantidade") );

                    // Add the object to the list
                    resultList.add(object);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        
        
        return resultList;
    }
    
    //Perguntar se funciona
    public boolean deletarLotes(Lotes l, int ref){
    String sql = "DELETE* INTO lote WHERE (Referencia = ref) ";
           
    try  {
            delete(sql, l);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean editarLotes(Lotes l, int id){
        //COmo atualiza no banco de dados?
    String sql = "UPDATE lotes SET (Prazo= '?', Entrada= '?', Preco= '?', Tecido= '?', Marca= '?', Colecao= '?', Modelo= '?', Tamanho= '?', Quantidade= '?', Linha= '?') WHERE (Referencia = ?)";
    try  {
            
            update(sql, id, l.getReferencia(), l.getPrazo(), l.getEntrada(), l.getPreco(), l.getTecido(), l.getMarca(), l.getColecao(), l.getModelo(),
                    l.getTamanho(), l.getQuantidade(), l.getLinha() );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
   
        
    

