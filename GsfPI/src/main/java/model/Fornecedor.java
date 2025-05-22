package model;

public class Fornecedor {

    private long CNPJFornecedor;
    private String NomeRepreFornecedor;
    private String EmailAcesso;
    private String Senha;

    public Fornecedor(long CNPJFornecedor, String NomeRepreFornecedor, String EmailAcesso, String Senha) {
        this.CNPJFornecedor = CNPJFornecedor;
        this.NomeRepreFornecedor = NomeRepreFornecedor;
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
