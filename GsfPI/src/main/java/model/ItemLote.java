
package model;


public class ItemLote {
    
    
    private String Tamanho;
    private String Linha;
    private int Quantidade;

    public ItemLote(String Tamanho,  String Linha, int Quantidade) {
        this.Tamanho = Tamanho;
        this.Linha = Linha;
        this.Quantidade = Quantidade;
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
