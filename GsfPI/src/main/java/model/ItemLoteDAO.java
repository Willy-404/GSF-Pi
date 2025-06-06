package model;

import dal.ConexaoBD;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemLoteDAO extends GenericDAO{
    
    private int RefeLote;
    private String Tamanho;
    private String Linha;
    private int Quantidade;
    private int id;
    Random random = new Random();

    public boolean cadastroSubgrupo(ItemLote l) {
    String sql = "INSERT INTO itemlote ( id, referenciaLote, Quantidade, Tamanho, Linha) "
            + "VALUES (?,?,?,?,?)";
    id = random.nextInt(100);
    try  {
            save(sql, id, l.getRefeLote(), l.getQuantidade(), l.getTamanho(), l.getLinha());
            return true;
        } catch (SQLException e) {  
            e.printStackTrace();
            return false;
        }
    }
    public List<ItemLote> listarSubgrupos(Object... parametros){
        String sql ="Select* FROM itemLote WHERE referenciaLote = ?";
        List<ItemLote> resultList = new ArrayList<ItemLote>();

        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            for (int i = 0; i < parametros.length; i++) {
                 preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Create a new object for each row

                    ItemLote object = new ItemLote(resultSet.getInt("Quantidade"),resultSet.getString("Tamanho"),resultSet.getString("Linha"));

                    // Add the object to the list
                    resultList.add(object);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        
        
        return resultList;
    } 
    
    public boolean deletarSubgrupo(ItemLote l, int ref){
    String sql = "DELETE FROM itemlote WHERE Referencia = ? ";
           
    try  {
            delete(sql, l);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean editarSubgrupo(ItemLote l, int id){
        //COmo atualiza no banco de dados?
    String sql = "UPDATE ItemLote SET Quantidade= ?, Tamanho=?, Linha=?";
    try  {
            
            update(sql, id, l.getQuantidade(), l.getTamanho(), l.getLinha());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }  

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String Tamanho) {
        this.Tamanho = Tamanho;
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
