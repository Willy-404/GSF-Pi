package model;

public class Fornecedor {

    private long CNPJFornecedor;
    private String NomeRepreFornecedor;
    private String UsuarioFornecedor;
    private String Senha;
    private String Telefone;

    
    public Fornecedor(long CNPJFornecedor, String NomeRepreFornecedor, String EmailAcesso, String Senha, String Telefone) {
        this.CNPJFornecedor = CNPJFornecedor;
        this.NomeRepreFornecedor = NomeRepreFornecedor;
        this.UsuarioFornecedor = EmailAcesso;
        this.Senha = Senha;
        this.Telefone = Telefone;
    }
    
    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
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
        return UsuarioFornecedor;
    }

    public void setEmailAcesso(String EmailAcesso) {
        this.UsuarioFornecedor = EmailAcesso;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

}
