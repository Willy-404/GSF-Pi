package model;

public class Fornecedor {

    private long CnpjFornecedor;
    private String NomeRepreFornecedor;
    private String UsuarioFornecedor;
    private String Senha;
    private String Telefone;

    
    public Fornecedor(long CNPJFornecedor, String NomeRepreFornecedor, String EmailAcesso, String Senha, String Telefone) {
        this.CnpjFornecedor = CNPJFornecedor;
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

    public long getCnpjFornecedor() {
        return CnpjFornecedor;
    }

    public void setCnpjFornecedor(long CnpjFornecedor) {
        this.CnpjFornecedor = CnpjFornecedor;
    }

    public String getNomeRepreFornecedor() {
        return NomeRepreFornecedor;
    }

    public void setNomeRepreFornecedor(String NomeRepreFornecedor) {
        this.NomeRepreFornecedor = NomeRepreFornecedor;
    }

    public String getUsuarioFornecedor() {
        return UsuarioFornecedor;
    }

    public void setUsuarioFornecedor(String UsuarioFornecedor) {
        this.UsuarioFornecedor = UsuarioFornecedor;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

}
