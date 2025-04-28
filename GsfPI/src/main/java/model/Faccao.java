package model;

import java.io.Serializable;

public class Faccao implements Serializable {

    private long CNPJFaccao;
    private String NomeRepreFaccao;
    private String EmailAcesso;
    private String Senha;

    public Faccao(long CNPJFaccao, String NomeRepreFaccao, String EmailAcesso, String Senha) {
        this.CNPJFaccao = CNPJFaccao;
        this.NomeRepreFaccao = NomeRepreFaccao;
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
