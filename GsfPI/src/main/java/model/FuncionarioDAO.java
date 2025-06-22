package model;

import Controller.CadastrarFuncionarioController;
import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionarioDAO extends GenericDAO {

    private long Cpf;
    private String NomeFuncionario;
    private LocalDate DataNascimento;
    private String Telefone;
    private String Email;
    private Float ValorHora;
    private String Cargo;
    
    public boolean cadastroFuncionario(Funcionario f) {
        String sql = "INSERT INTO funcionario (Cpf, NomeFuncionario, DataNascimento, Telefone, Email, ValorHora, Cargo) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            save(sql, f.getCpf(), f.getNomeFuncionario(), f.getDataNascimento(), f.getTelefone(), f.getEmail(), f.getValorHora(), f.getCargo());

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Funcionario funciSelecionado(long cpf){
        Funcionario f;
        try {
            f=select(cpf);
           return f;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Funcionario select(Object... parametros ) throws SQLException {
         String sql ="Select* FROM funcionario WHERE Cpf = ?";
        Funcionario f = null;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                
                    LocalDate dataNascimento = LocalDate.parse(resultSet.getString("DataNascimento"));
                            
                    Funcionario object = new Funcionario(resultSet.getLong("Cpf"), resultSet.getString("NomeFuncionario"),
                        dataNascimento, resultSet.getString("Telefone"), resultSet.getString("Email"),
                        resultSet.getFloat("ValorHora"),resultSet.getString("Cargo"));

                    // Add the object to the list
                    f = object;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return f; 
    }

    public List<Funcionario> ListarFuncionario() {
        ObservableList<Funcionario> lista = FXCollections.observableArrayList();
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> resultList = new ArrayList<Funcionario>();

        try (Connection connection = ConexaoBD.conectar(); PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Create a new object for each row
                    LocalDate dataNascimento = LocalDate.parse(resultSet.getString("DataNascimento"));
                    
                    Funcionario object = new Funcionario(resultSet.getLong("Cpf"), resultSet.getString("NomeFuncionario"),
                        dataNascimento, resultSet.getString("Telefone"), resultSet.getString("Email"),
                        resultSet.getFloat("ValorHora"),resultSet.getString("Cargo"));
                    // Add the object to the list
                    resultList.add(object);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        return resultList;
    }
    
    public Funcionario pesquisa( Object... parametros ) throws SQLException {
         String sql ="Select* FROM funcionario WHERE NomeFuncionario = ? ";
        Funcionario l = null;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
                 preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                
                     LocalDate dataNascimento = LocalDate.parse(resultSet.getString("DataNascimento"));
                    
                    Funcionario object = new Funcionario(resultSet.getLong("Cpf"), resultSet.getString("NomeFuncionario"),
                        dataNascimento, resultSet.getString("Telefone"), resultSet.getString("Email"),
                        resultSet.getFloat("ValorHora"),resultSet.getString("Cargo"));
                    // Add the object to the list
                    l = object;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return l; 
    }

    public boolean editarFuncionario(Funcionario f, long Cpf) {
        String sql = "UPDATE funcionario SET Cpf = ?, NomeFuncionario =  ?, DataNascimento = ?, Telefone = ?, Email = ?, ValorHora = ?, Cargo = ? WHERE Cpf = ? ";
        try {
            update(sql, Cpf, f.getCpf(), f.getNomeFuncionario(), f.getDataNascimento(), f.getTelefone(), f.getEmail(), f.getValorHora(), f.getCargo());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    public long getCpf() {
        return Cpf;
    }

    public void setCpf(long Cpf) {
        this.Cpf = Cpf;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Float getValorHora() {
        return ValorHora;
    }

    public void setValorHora(Float ValorHora) {
        this.ValorHora = ValorHora;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

}
