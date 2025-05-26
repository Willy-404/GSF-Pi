package model;

import java.time.LocalDate;

public class Lotes {
    private int Referencia;
    private LocalDate Prazo;
    private LocalDate Entrada;
    private float Preco;
    private String Tecido; 
    private String Marca;
    private String Colecao;
    private String Modelo;
    private int Quantidade;

    public Lotes(int Referencia, LocalDate Prazo, int Quantidade) {
        this.Referencia = Referencia;
        this.Prazo = Prazo;
        this.Quantidade = Quantidade;
    }

    public Lotes(int Referencia, LocalDate Prazo, LocalDate Entrada, float Preco, String Tecido, String Marca, String Colecao, String Modelo) {
        this.Referencia = Referencia;
        this.Prazo = Prazo;
        this.Entrada = Entrada;
        this.Preco = Preco;
        this.Tecido = Tecido;
        this.Marca = Marca;
        this.Colecao = Colecao;
        this.Modelo = Modelo;
    }

    public Lotes(int Referencia, LocalDate Prazo, LocalDate Entrada, float Preco, String Tecido, String Marca, String Colecao, String Modelo, int Quantidade) {
        this.Referencia = Referencia;
        this.Prazo = Prazo;
        this.Entrada = Entrada;
        this.Preco = Preco;
        this.Tecido = Tecido;
        this.Marca = Marca;
        this.Colecao = Colecao;
        this.Modelo = Modelo;
        this.Quantidade = Quantidade;
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

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
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

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }  
    
}
