
package model;


public class ItemLote {
    
    private int Referencia;
    private String Linha;
    private int Quantidade;

    public ItemLote(int Referencia, String Linha, int Quantidade) {
        this.Referencia = Referencia;
        this.Linha = Linha;
        this.Quantidade = Quantidade;
    }

    public int getReferencia() {
        return Referencia;
    }

    public void setReferencia(int Referencia) {
        this.Referencia = Referencia;
    }

    public String getLinha() {
        return Linha;
    }

    public void setLinha(String Linha) {
        this.Linha = Linha;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    
    
    
}
