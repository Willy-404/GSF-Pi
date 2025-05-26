/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class ItemLoteDAO extends GenericDAO{
    
    private String Tamanho;
    private int Quantidade;
    private String Linha;

    public boolean cadastroSubgrupo(ItemLote l) {
    String sql = "INSERT INTO itemlote (Tamanho, Linha, Quantidade) "
            + "VALUES (?,?,?)";
    try  {
            save(sql, l.getTamanho(), l.getLinha(), l.getQuantidade());
            return true;
        } catch (SQLException e) {  
            e.printStackTrace();
            return false;
        }
    }
    
    
}
