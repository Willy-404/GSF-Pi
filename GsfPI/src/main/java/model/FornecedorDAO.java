package model;

import Controller.CadastrarFornecedorController;
import Controller.CadastrarFuncionarioController;
import java.sql.SQLException;
import java.time.LocalDate;

public class FornecedorDAO extends GenericDAO {
   private long CNPJFornecedor;
   private String NomeRepreFornecedor;
   private String EmailAcesso;
   private String Senha;
    CadastrarFornecedorController fc = new CadastrarFornecedorController();
    
    public boolean cadastroFornecedor(Fornecedor f){
    String sql = "INSERT INTO funcionario (CNPJFornecedor, NomeRepreFornecedor, EmailAcesso, Senha) "
            + "VALUES (?,?,?,?,?,?,?)";
    try{
            save(sql,f.getCNPJFornecedor(),f.getNomeRepreFornecedor(), f.getEmailAcesso(), f.getSenha());
            
           
             return true;
            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    
     public Fornecedor ListarFornecedor(){
        Fornecedor f = fc.getUserInfo().get(0);
        Cpf = f.getCpf();
        NomeFuncionario = f.getNomeFuncionario();
        DataNascimento = f.getDataNascimento();
        Telefone = f.getTelefone();
        Email = f.getEmail();
        ValorHora = f.getValorHora();
        Cargo = f.getCargo();
        return f;
    }

    public FornecedorDAO(long CNPJFornecedor, String NomeRepreFornecedor, String EmailAcesso, String Senha) {
        this.CNPJFornecedor = CNPJFornecedor;
        this.NomeRepreFornecedor = NomeRepreFornecedor;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }
   
   public FornecedorDAO(String NomeRepreFornecedor, String EmailAcesso, String Senha) {
        this.NomeRepreFornecedor = NomeRepreFornecedor;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
   }

    public FornecedorDAO(String EmailAcesso, String Senha) {
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }
   
    public long getCNPJFornecedor() {
        return CNPJFornecedor;
    }

    public void setCNPJFornecedor(long CNPJFornecedor) {
        this.CNPJFornecedor = CNPJFornecedor;
    }

    public String getNomeRepreFornecedor() {
        return NomeRepreFornecedor;
    }

    public void setNomeRepreFornecedor(String NomeRepreFornecedor) {
        this.NomeRepreFornecedor = NomeRepreFornecedor;
    }

    public String getEmailAcesso() {
        return EmailAcesso;
    }

    public void setEmailAcesso(String EmailAcesso) {
        this.EmailAcesso = EmailAcesso;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
