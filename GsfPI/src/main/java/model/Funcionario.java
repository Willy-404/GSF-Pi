package model;

import java.time.LocalDate;

public class Funcionario {
    private long Cpf;
    private String NomeFuncionario;
    private LocalDate DataNascimento;
    private String Telefone;
    private String Email;
    private Float ValorHora;
    private String Cargo;

    public Funcionario(long Cpf, String NomeFuncionario, LocalDate DataNascimento, String Telefone, String Email, Float ValorHora, String Cargo) {
        this.Cpf = Cpf;
        this.NomeFuncionario = NomeFuncionario;
        this.DataNascimento = DataNascimento;
        this.Telefone = Telefone;
        this.Email = Email;
        this.ValorHora = ValorHora;
        this.Cargo = Cargo;
    }

    public Funcionario(long Cpf, String NomeFuncionario) {
        this.Cpf = Cpf;
        this.NomeFuncionario = NomeFuncionario;
    }

    public long getCpf() {
        return Cpf;
    }

    public void setCpf(long Cpf) {
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
