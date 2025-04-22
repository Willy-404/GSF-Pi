package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LotesDAO extends GenericDAO {
    private int Referencia;
    private LocalDateTime Prazo;
    private LocalDateTime Entrada;
    private LocalDateTime Saida;
    private Double Preco;
    private String Tecido; 
    private String MarcaLote;
    private String Colecao;
    private String Modelo;
  
    public static boolean cadastroLotes(int Referencia, LocalDateTime Prazo, LocalDateTime Entrada, LocalDateTime Saida, Double Preco, String Tecido,
    String MarcaLote, String Colecao, String Modelo){
    String sql = "INSERT INTO lote (Referencia, Prazo, Entrada, Saida, Preco, Tecido, MarcaLote, Colecao, Modelo) VALUES (?,?,?,?,?,?,?,?,?)";
    try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Referencia);
            stmt.setTimestamp(2, Timestamp.valueOf(Prazo));
            stmt.setTimestamp(3, Timestamp.valueOf(Entrada));  
            stmt.setTimestamp(4, Timestamp.valueOf(Saida)); 
            stmt.setDouble(5, Preco); 
            stmt.setString(6, Tecido); 
            stmt.setString(7, MarcaLote); 
            stmt.setString(8, Colecao); 
            stmt.setString(9, Modelo); 

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
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

    public LocalDateTime getPrazo() {
        return Prazo;
    }

    public void setPrazo(LocalDateTime Prazo) {
        this.Prazo = Prazo;
    }

    public LocalDateTime getEntrada() {
        return Entrada;
    }

    public void setEntrada(LocalDateTime Entrada) {
        this.Entrada = Entrada;
    }

    public LocalDateTime getSaida() {
        return Saida;
    }

    public void setSaida(LocalDateTime Saida) {
        this.Saida = Saida;
    }

    public double getPreco() {
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

    public String getMarcaLote() {
        return MarcaLote;
    }

    public void setMarcaLote(String MarcaLote) {
        this.MarcaLote = MarcaLote;
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
    
    
}
