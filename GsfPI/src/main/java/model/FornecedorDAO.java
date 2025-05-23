package model;

import Controller.CadastrarFornecedorController;
import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FornecedorDAO extends GenericDAO {
   private long CNPJFornecedor;
   private String NomeRepreFornecedor;
   private String EmailAcesso;
   private String Senha;
    CadastrarFornecedorController fc = new CadastrarFornecedorController();
    
    public boolean cadastroFornecedor(Fornecedor f){
    String sql = "INSERT INTO funcionario (CNPJFornecedor, NomeRepreFornecedor, EmailAcesso, Senha) "
            + "VALUES (?,?,?,?,?,?,?)";
    try{
            save(sql,f.getCNPJFornecedor(),f.getNomeRepreFornecedor(), f.getEmailAcesso(), f.getSenha());
            
           
             return true;
            }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        }
    
     public List<Fornecedor> ListarFornecedor() {
        ObservableList<Fornecedor> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM fornecedor";
        List<Fornecedor> resultList = new ArrayList<Fornecedor>();

        try (Connection connection = ConexaoBD.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Create a new object for each row
                    
                    Fornecedor object = new Fornecedor(resultSet.getLong("CnpjFornecedor"), resultSet.getString("NomeRepreFornecedor"),
                        resultSet.getString("UsuarioFornecedor"), resultSet.getString("Senha"));
                    // Add the object to the list
                    resultList.add(object);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        return resultList;
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

    public String getEmailAcesso() {
        return EmailAcesso;
    }

    public void setEmailAcesso(String EmailAcesso) {
        this.EmailAcesso = EmailAcesso;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}
