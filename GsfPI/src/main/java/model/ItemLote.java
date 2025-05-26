
package model;


public class ItemLote {
    
    
    private int Quantidade;
    private String Tamanho;
    private String Linha;

    public ItemLote(String Tamanho, int Quantidade, String Linha) {
        this.Tamanho = Tamanho;
        this.Quantidade = Quantidade;
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
