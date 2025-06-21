package model;

import Controller.CadastrarFornecedorController;
import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends GenericDAO {
   private long CNPJFornecedor;
   private String NomeRepreFornecedor;
   private String UsuarioFornecedor;
   private String Senha;
   private String Telefone;
   private String Endereco;

    
    public boolean cadastroFornecedor(Fornecedor f){
    String sql = "INSERT INTO fornecedor (CnpjFornecedor, NomeRepreFornecedor, UsuarioFornecedor, Senha, Contato, endereco) "
            + "VALUES (?,?,?,?,?,?)";
    try{
            save(sql,f.getCnpjFornecedor(),f.getNomeRepreFornecedor(), f.getUsuarioFornecedor(), f.getSenha(), f.getTelefone(),f.getEndereco());
            
           
             return true;
            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    
     public boolean editarFornecedor(Fornecedor f, long Cnpj) {
        String sql = "UPDATE fornecedor SET CnpjFornecedor = ?, NomeRepreFornecedor =  ?, UsuarioFornecedor = ?, Senha = ?, Contato = ?, endereco = ? WHERE CnpjFornecedor = ? ";
        try {
            update(sql,Cnpj, f.getCnpjFornecedor(), f.getNomeRepreFornecedor(), f.getUsuarioFornecedor(), f.getSenha(), f.getTelefone(), f.getEndereco());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
     
     public List<Fornecedor> ListarFornecedor() {
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> resultList = new ArrayList<Fornecedor>();

        try (Connection connection = ConexaoBD.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    
                    Fornecedor object = new Fornecedor(resultSet.getLong("CnpjFornecedor"), resultSet.getString("NomeRepreFornecedor"),
                        resultSet.getString("UsuarioFornecedor"), resultSet.getString("Senha"), resultSet.getString("Contato"), resultSet.getString("endereco"));
                    
                    resultList.add(object);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        return resultList;
    }
     
     public Fornecedor pesquisa( Object... parametros ) throws SQLException {
         String sql ="Select* FROM fornecedor WHERE NomeRepreFornecedor = ? ";
        Fornecedor l = null;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                            
                   Fornecedor object = new Fornecedor(resultSet.getLong("CnpjFornecedor"), resultSet.getString("NomeRepreFornecedor"),
                        resultSet.getString("UsuarioFornecedor"), resultSet.getString("Senha"), resultSet.getString("Contato"), resultSet.getString("endereco"));
                    
                    l = object;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return l; 
    }
 
    public long getCNPJFornecedor() {
        return CNPJFornecedor;
    }

    public void setCNPJFornecedor(long CNPJFornecedor) {
        this.CNPJFornecedor = CNPJFornecedor;
    }

    public String getNomeRepreFornecedor() {
        return NomeRepreFornecedor;
    }

    public void setNomeRepreFornecedor(String NomeRepreFornecedor) {
        this.NomeRepreFornecedor = NomeRepreFornecedor;
    }

    public String getUsuarioFornecedor() {
        return UsuarioFornecedor;
    }

    public void setUsuarioFornecedor(String UsuarioFornecedor) {
        this.UsuarioFornecedor = UsuarioFornecedor;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
