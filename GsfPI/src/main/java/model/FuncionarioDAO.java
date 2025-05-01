package model;

import java.sql.SQLException;
import java.time.LocalDate;

public class FuncionarioDAO extends GenericDAO{
    private String Cpf;
    private String NomeFuncionario;
    private LocalDate DataNascimento;
    private String Telefone;
    private String Email;
    private Float ValorHora;
    private String Cargo;
    
    public boolean cadastroFuncionario(Funcionario l){
    String sql = "INSERT INTO funcionario (Cpf, NomeFuncionario, DataNascimento, Telefone, Email, ValorHora, Cargo) "
            + "VALUES (?,?,?,?,?,?,?)";
    try  {
            save(sql, l);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FuncionarioDAO(String Cpf, String NomeFuncionario, LocalDate DataNascimento, String Telefone, String Email, Float ValorHora, String Cargo) {
        this.Cpf = Cpf;
        this.NomeFuncionario = NomeFuncionario;
        this.DataNascimento = DataNascimento;
        this.Telefone = Telefone;
        this.Email = Email;
        this.ValorHora = ValorHora;
        this.Cargo = Cargo;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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
