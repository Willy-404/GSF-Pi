package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import util.Alertas;

public class PerfilDAO extends GenericDAO{
    Alertas alertas = new Alertas();
    public boolean cadastroPerfil(Perfil p) {
        String sql = "INSERT INTO perfil (CNPJ, email, senha, tipoPerfil) VALUES (?,?,?,?)";
      
        try{
            save(sql, p.getCNPJ(), p.getEmail(), p.getSenha(), p.getTipoPerfil().getNome());
            
             return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean editarPerfilCnpj(Perfil p, long Cnpj) {
        String sql = "UPDATE perfil SET CNPJ = ?, email =  ?, senha = ?, tipoPerfil = ? WHERE CNPJ = ? ";
        try {
            update(sql, Cnpj, p.getCNPJ(), p.getEmail(), p.getSenha(), p.getTipoPerfil().getNome());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
    
    public boolean editarPerfilEmail(Perfil p, String email) {
        String sql = "UPDATE perfil SET CNPJ = ?, email =  ?, senha = ?, tipoPerfil = ? WHERE email = ? ";
        try {
            update(sql, email, p.getCNPJ(), p.getEmail(), p.getSenha(), p.getTipoPerfil().getNome());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
    
    public Perfil selecionaPerfilEmail(Object... parametros) {
        String sql ="Select* FROM perfil WHERE email = ? ";
        Perfil l = null;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    TipoPerfil tp = TipoPerfil.getPerfil(rs.getString("tipoPerfil"));
                    System.out.println(tp);
                    Perfil object = new Perfil(rs.getLong("CNPJ"), rs.getString("email"), rs.getString("senha"), tp);

                    // Add the object to the list
                    l = object;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return l; 
    }
}
