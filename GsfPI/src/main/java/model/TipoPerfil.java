package model;

public enum TipoPerfil {
    FACCAO("Faccao"),FORNECEDOR("Fornecedor");
    
    String nome;
    
    TipoPerfil(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static TipoPerfil getPerfil(String nome){
        if(nome.equals("Faccao")){
            return FACCAO;
        }if(nome.equals("Fornecedor")){
            return FORNECEDOR;
        }else{
            return null;
        }
    }

    @Override
    public String toString() {
        return nome; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
