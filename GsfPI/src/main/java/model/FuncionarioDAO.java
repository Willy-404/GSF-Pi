package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO extends GenericDAO{
    private long CPF;
    private String NomeFuncionario;
    private String DataNascimento;
    private String Telefone;
    private Float ValorHora;
    private String Cargo;
    
    public static boolean cadastroFuncionario(long CPF, String NomeFuncionario, String DataNascimento, String Telefone, String ValorHora, String Cargo){
        String sql = "INSERT INTO funcionario (CPF, NomeFuncionario, Telefone, Email, ValorHora, Cargo) VALUES (?,?,?,?,?,?)";
         try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, CPF );
            stmt.setString(2, NomeFuncionario);
            stmt.setString(3, DataNascimento);  
            stmt.setString(4, Telefone); 
            stmt.setString(5, ValorHora);  
            stmt.setString(6, Cargo); 
           

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FuncionarioDAO(long CPF, String NomeFuncionario, String DataNascimento, String Telefone, Float ValorHora, String Cargo) {
        this.CPF = CPF;
        this.NomeFuncionario = NomeFuncionario;
        this.DataNascimento = DataNascimento;
        this.Telefone = Telefone;
        this.ValorHora = ValorHora;
        this.Cargo = Cargo;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public String getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(String DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Float getValorHora() {
        return ValorHora;
    }

    public void setValorHora(Float ValorHora) {
        this.ValorHora = ValorHora;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
}
