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

    public FornecedorDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
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
    
   //  public Fornecedor ListarFornecedor(){
    //    Fornecedor f = fc.getUserInfo().get(0);
    //   CNPJFornecedor = f.getCNPJFornecedor();
 ///     NomeRepreFornecedor = f.getNomeRepreFornecedor();
    //    EmailAcesso = f.getEmailAcesso();
     //  Senha = f.getSenha();
       
     //   return f;
  //  }

 
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
