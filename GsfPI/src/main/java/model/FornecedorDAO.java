package model;

public class FornecedorDAO {
   private long CNPJFornecedor;
   private String NomeRepreFornecedor;
   private String EmailAcesso;
   private String Senha;

    public FornecedorDAO(long CNPJFornecedor, String NomeRepreFornecedor, String EmailAcesso, String Senha) {
        this.CNPJFornecedor = CNPJFornecedor;
        this.NomeRepreFornecedor = NomeRepreFornecedor;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
    }
   
   public FornecedorDAO(String NomeRepreFornecedor, String EmailAcesso, String Senha) {
        this.NomeRepreFornecedor = NomeRepreFornecedor;
        this.EmailAcesso = EmailAcesso;
        this.Senha = Senha;
   }

    public FornecedorDAO(String EmailAcesso, String Senha) {
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
