package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FaccaoDAO extends GenericDAO {

    private long CnpjFaccao;
    private String NomeRepreFaccao;
    private String EmailAcesso;
    private String Senha;
    private String Telefone;
    private String Perfil;

    public boolean cadastroFaccao(Faccao f) {
        String sql = "INSERT INTO faccao (CnpjFaccao, NomeRepreFaccao, EmailAcesso, Senha, Telefone, Perfil) VALUES (?,?,?,?,?,Faccao)";
      
        try{
            save(sql, f);
             return true;
            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    
    /* Pensando em como fazer
    public void ListaFaccao(Faccao f, String Email){
        String sql = "Select* faccao WHEN (EmailAcesso) VALUE (Email)";
        CnpjFaccao = f.getCNPJFaccao();
        NomeRepreFaccao = f.getNomeRepreFaccao();
        EmailAcesso = f.getEmailAcesso();
        Telefone = f.getTelefone();
        System.out.println(f);
        
        
    }*/

   

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
