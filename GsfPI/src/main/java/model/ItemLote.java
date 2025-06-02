
package model;


public class ItemLote {
    
    private int RefeLote;

    public int getRefeLote() {
        return RefeLote;
    }

    public void setRefeLote(int RefeLote) {
        this.RefeLote = RefeLote;
    }
    private int Quantidade;
    private String Tamanho;
    private String Linha;

    public ItemLote(int Quantidade,  String Tamanho, String Linha) {
        this.Quantidade = Quantidade;
        this.Tamanho = Tamanho;
        this.Linha = Linha;
    }

    public ItemLote(int RefeLote, int Quantidade, String Tamanho, String Linha) {
        this.RefeLote = RefeLote;
        this.Quantidade = Quantidade;
        this.Tamanho = Tamanho;
        this.Linha = Linha;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getLinha() {
        return Linha;
    }

    public void setLinha(String Linha) {
        this.Linha = Linha;
    }
    
}
