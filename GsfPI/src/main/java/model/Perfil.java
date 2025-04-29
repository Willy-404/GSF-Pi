/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author Aluno
 */
public enum Perfil {
    FACCAO("Faccao"),FORNECEDOR("Fornecedor");
    
    String nome;
    
    Perfil(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public static Perfil getPerfil(String nome){
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
