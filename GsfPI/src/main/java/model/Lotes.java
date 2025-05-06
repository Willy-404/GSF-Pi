package model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Lotes {
     private int Referencia;
    private LocalDate Prazo;
    private LocalDate Entrada;
    private Double Preco;
    private String Tecido; 
    private String Marca;
    private String Colecao;
    private String Modelo;
    private String Tamanho;
    private int Quantidade;
    private String Linha;
    
    private final IntegerProperty refP = new SimpleIntegerProperty();
    private final ObjectProperty <LocalDate> prazop = new SimpleObjectProperty<>();
    private final IntegerProperty quantidadeP = new SimpleIntegerProperty();
    
    public Lotes(int ref, LocalDate prazo, int quantidade) {
        this.refP.set(ref);
        this.prazop.set(prazo);
        this.quantidadeP.set(quantidade);
    }

    public IntegerProperty getRefP() {
        return refP;
    }

    public ObjectProperty<LocalDate> getPrazop() {
        return prazop;
    }

    public IntegerProperty getQuantidadeP() {
        return quantidadeP;
    }

    public Lotes(int Referencia, LocalDate Prazo, LocalDate Entrada, Double Preco, String Tecido, String Marca, String Colecao, String Modelo, String Tamanho, int Quantidade, String Linha) {
        this.Referencia = Referencia;
        this.Prazo = Prazo;
        this.Entrada = Entrada;
        this.Preco = Preco;
        this.Tecido = Tecido;
        this.Marca = Marca;
        this.Colecao = Colecao;
        this.Modelo = Modelo;
        this.Tamanho = Tamanho;
        this.Quantidade = Quantidade;
        this.Linha = Linha;
    }

    public int getReferencia() {
        return Referencia;
    }

    public void setReferencia(int Referencia) {
        this.Referencia = Referencia;
    }

    public LocalDate getPrazo() {
        return Prazo;
    }

    public void setPrazo(LocalDate Prazo) {
        this.Prazo = Prazo;
    }

    public LocalDate getEntrada() {
        return Entrada;
    }

    public void setEntrada(LocalDate Entrada) {
        this.Entrada = Entrada;
    }

    public Double getPreco() {
        return Preco;
    }

    public void setPreco(Double Preco) {
        this.Preco = Preco;
    }

    public String getTecido() {
        return Tecido;
    }

    public void setTecido(String Tecido) {
        this.Tecido = Tecido;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getColecao() {
        return Colecao;
    }

    public void setColecao(String Colecao) {
        this.Colecao = Colecao;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
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
