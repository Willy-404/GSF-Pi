package model;

import Controller.LoginController;
import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FaccaoDAO extends GenericDAO {

    private long CnpjFaccao;
    private String NomeRepreFaccao;
    private String EmailAcesso;
    private String Senha;
    private String Telefone;
    private String Perfil;
    LoginController lc = new LoginController();
    public boolean cadastroFaccao(Faccao f) {
        String sql = "INSERT INTO faccao (CnpjFaccao, NomeRepreFaccao, EmailAcesso, Senha, Telefone) VALUES (?,?,?,?,?)";
      
        try{
            save(sql, f.getCNPJFaccao(), f.getNomeRepreFaccao(), f.getEmailAcesso(), f.getSenha(), f.getTelefone());
            
           
             return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    
   
    public Faccao ListaFaccao(ArrayList<Faccao> user){
        Faccao f = user.get(0);
        CnpjFaccao = f.getCNPJFaccao();
        NomeRepreFaccao = f.getNomeRepreFaccao();
        Senha = f.getSenha();
        EmailAcesso = f.getEmailAcesso();
        Telefone = f.getTelefone();
        return f;   
        
        
    }

    public boolean editarFaccao(Faccao f, long id){
        long CnpjT = f.getCNPJFaccao();
        String NomeRepreFaccaoT = f.getNomeRepreFaccao();
        String EmailAcessoT = f.getEmailAcesso();
        String SenhaT = f.getSenha();
        String TelefoneT = f.getTelefone();
        
        String sql = "UPDATE faccao SET CnpjFaccao = ?, NomeRepreFaccao =  ?, EmailAcesso = ?, Senha = ?, Telefone = ? WHERE CnpjFaccao = ? ";
        try{
            update(sql,id, f.getCNPJFaccao(), f.getNomeRepreFaccao(), f.getEmailAcesso(), f.getSenha(), f.getTelefone());
            
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        
         }
    }
    
   public Faccao selecionar(Object... parametros){
       Faccao f = null;
       String sql ="Select* FROM faccao WHERE CnpjFaccao = ? ";
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                
                    Faccao object = new Faccao(rs.getLong("CnpjFaccao"), rs.getString("NomeRepreFaccao"), rs.getString("EmailAcesso"), 
                            rs.getString("Senha"), rs.getString("Telefone"));
                    
                    f = object;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
       
       return f;
   }

    public long getCNPJFaccao() {
        return CnpjFaccao;
    }

    public void setCNPJFaccao(long CNPJFaccao) {
        this.CnpjFaccao = CNPJFaccao;
    }

    public String getNomeRepreFaccao() {
        return NomeRepreFaccao;
    }

    public void setNomeRepreFaccao(String NomeRepreFaccao) {
        this.NomeRepreFaccao = NomeRepreFaccao;
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
