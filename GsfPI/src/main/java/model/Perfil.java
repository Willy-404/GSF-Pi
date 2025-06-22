package model;

public class Perfil {
    private long CNPJ;
    private String email;
    private String senha;
    private TipoPerfil tipoPerfil;

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(TipoPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Perfil(long CNPJ, String email, String senha, TipoPerfil tipoPerfil) {
        this.CNPJ = CNPJ;
        this.email = email;
        this.senha = senha;
        this.tipoPerfil = tipoPerfil;
    }
}
