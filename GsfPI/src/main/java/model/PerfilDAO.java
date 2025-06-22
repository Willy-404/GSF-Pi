package model;

import java.sql.SQLException;
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
    
    public boolean editarPerfil(Perfil p, long Cnpj) {
        String sql = "UPDATE perfil SET CNPJ = ?, email =  ?, senha = ?, tipoPerfil = ? WHERE CNPJ = ? ";
        try {
            update(sql, Cnpj, p.getCNPJ(), p.getEmail(), p.getSenha(), p.getTipoPerfil().getNome());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }
}
