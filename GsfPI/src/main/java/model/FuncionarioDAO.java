package model;

import Controller.CadastrarFuncionarioController;
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
    CadastrarFuncionarioController fc = new CadastrarFuncionarioController();
    
    public boolean cadastroFuncionario(Funcionario f){
    String sql = "INSERT INTO funcionario (Cpf, NomeFuncionario, DataNascimento, Telefone, Email, ValorHora, Cargo) "
            + "VALUES (?,?,?,?,?,?,?)";
    try{
            save(sql,f.getCpf(),f.getNomeFuncionario(), f.getDataNascimento(), f.getTelefone(), f.getEmail(), f.getValorHora(), f.getCargo());
            
           
             return true;
            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    
    public Funcionario ListarFuncionario(){
        Funcionario f = fc.getUserInfo().get(0);
        Cpf = f.getCpf();
        NomeFuncionario = f.getNomeFuncionario();
        DataNascimento = f.getDataNascimento();
        Telefone = f.getTelefone();
        Email = f.getEmail();
        ValorHora = f.getValorHora();
        Cargo = f.getCargo();
        return f;
    }
    
    public boolean editarFuncionario(Funcionario f, String Cpf){
        String CpfE = f.getCpf();
        String NomeFuncionarioE = f.getNomeFuncionario();
        LocalDate DataNascimentoE = f.getDataNascimento();
        String TelefoneE = f.getTelefone();
        String EmailE = f.getEmail();
        Float ValorHoraE = f.getValorHora();
        String CargoE = f.getCargo();
        String sql = "UPDATE funcionario SET Cpf = ?, NomeFuncionario =  ?, DataNascimento = ?, Telefone = ?, Email = ?, ValorHora = ?, Cargo = ? WHERE Cpf = ? ";
        try{
            update(sql,Cpf, f.getNomeFuncionario(), f.getDataNascimento(), f.getTelefone(), f.getEmail(), f.getValorHora(),f.getCargo());
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        
         }
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
