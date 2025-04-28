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

    public boolean cadastroFaccao(Faccao f) {
        String sql = "INSERT INTO faccao (CnpjFaccao, NomeRepreFaccao, EmailAcesso, Senha) VALUES (?,?,?,?)";
        try (save(sql, f))  || (Connection conn = ConexaoBD.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            
                ) {
             System.out.println(stmt);
                stmt.setLong(1, CnpjFaccao);
                stmt.setString(2, NomeRepreFaccao);
                stmt.setString(3, EmailAcesso);
                stmt.setString(4, Senha);

                int linhasAfetadas = stmt.executeUpdate();
                return linhasAfetadas > 0;
            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    

    public FaccaoDAO(long CNPJFaccao, String NomeRepreFaccao, String EmailAcesso, String Senha) {
        this.CNPJFaccao = CNPJFaccao;
        this.NomeRepreFaccao = NomeRepreFaccao;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }

    public FaccaoDAO(String NomeRepreFaccao, String EmailAcesso, String Senha) {
        this.NomeRepreFaccao = NomeRepreFaccao;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }

    public FaccaoDAO(String EmailAcesso, String Senha) {
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }

    public long getCNPJFaccao() {
        return CNPJFaccao;
    }

    public void setCNPJFaccao(long CNPJFaccao) {
        this.CNPJFaccao = CNPJFaccao;
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
