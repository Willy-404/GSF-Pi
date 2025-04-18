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
	public FaccaoDAO autenticar(String login, String senha) throws SQLException {
		String sql = "SELECT * FROM faccao WHERE EmailAcesso=? AND Senha=?";
		FaccaoDAO faccao = null;
		Connection con = conectarDAO();
		if (con != null) {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
                            long CNPJFaccao = rs.getInt("CnpjFaccao");
                            String NomeRepreFaccao = rs.getString("NomeRepreFaccao");
                            String EmailAcesso = rs.getString("EmailAcesso");
                            String Senha = rs.getString("Senha");
				faccao = new FaccaoDAO(CNPJFaccao, NomeRepreFaccao, EmailAcesso, Senha);
  
			}

			rs.close();
			stmt.close();
			conectarDAO().close();
                        System.out.println("passou pelo banco?");
                                
			return faccao;
		} else {
			return null;
			
		}

	}
    
    
}
