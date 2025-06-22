package model;

import java.io.Serializable;

public class Faccao implements Serializable {

    private long CNPJFaccao;
    private String NomeRepreFaccao;
    private String EmailAcesso;
    private String Senha;
    private String Telefone;

    public Faccao(long CNPJFaccao, String NomeRepreFaccaoP, String EmailAcesso, String Senha, String Telefone) {
        this.CNPJFaccao = CNPJFaccao;
        this.NomeRepreFaccao = NomeRepreFaccaoP;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
        this.Telefone = Telefone;
    }


    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
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
