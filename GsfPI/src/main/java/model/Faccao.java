package model;

public class Faccao {
    private int CNPJFaccao;
    private String NomeRepreFaccao;
    private String EmailAcesso;
    private String Senha;

    
    public Faccao(int CNPJFaccao, String NomeRepreFaccao, String EmailAcesso, String Senha) {
        this.CNPJFaccao = CNPJFaccao;
        this.NomeRepreFaccao = NomeRepreFaccao;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }
    
     public Faccao(String NomeRepreFaccao, String EmailAcesso, String Senha) {
        this.NomeRepreFaccao = NomeRepreFaccao;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }

    public Faccao(String EmailAcesso, String Senha) {
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }
    
    public int getCNPJFaccao() {
        return CNPJFaccao;
    }

    public void setCNPJFaccao(int CNPJFaccao) {
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
