package model;

import Controller.LoginController;
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
        String sql = "INSERT INTO faccao (CnpjFaccao, NomeRepreFaccao, EmailAcesso, Senha, Telefone, Perfil) VALUES (?,?,?,?,?,?)";
      
        try{
            save(sql, f.getCNPJFaccao(), f.getNomeRepreFaccao(), f.getEmailAcesso(), f.getSenha(), f.getTelefone(), f.getPerfil().getNome());
            
           
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
        Perfil perfil = f.getPerfil();
        String sql = "UPDATE faccao SET CnpjFaccao = ?, NomeRepreFaccao =  ?, EmailAcesso = ?, Senha = ?, Telefone = ?, perfil = ? WHERE CnpjFaccao = ? ";
        try{
            update(sql,id, f.getCNPJFaccao(), f.getNomeRepreFaccao(), f.getEmailAcesso(), f.getSenha(), f.getTelefone(), f.getPerfil().getNome());
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        
         }
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
