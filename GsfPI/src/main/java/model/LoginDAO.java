package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO extends GenericDAO{
    
	// Método para verificar se o banco esta online
	public Boolean bancoOnline() {
		Connection con = conectarDAO();
		if (con != null) {
			try {
				conectarDAO().close();
			} catch (SQLException e) {
			}
			return true;
		} else
			return false;
	}
    
 //	 Método para autenticar usuários
	public Perfil autenticar(String login, String senha) throws SQLException {
		String sql = "SELECT * FROM perfil WHERE email=? AND senha=?";
		Perfil p = null;
		Connection con = conectarDAO();
		if (con != null) {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
                            long CNPJ = rs.getLong("CNPJ");
                            String EmailAcesso = rs.getString("email");
                            String Senha = rs.getString("senha");
                            TipoPerfil perfil = TipoPerfil.getPerfil(rs.getString("tipoPerfil"));
				p = new Perfil(CNPJ, EmailAcesso, Senha, perfil);
  
			}

			rs.close();
			stmt.close();
			conectarDAO().close();
                        System.out.println("passou pelo banco?");
                                
			return p;
		} else {
			return null;
			
		}

	}
        
       
    
    
}
