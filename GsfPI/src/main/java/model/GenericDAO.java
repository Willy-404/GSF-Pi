package model;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//Classe abstrata não pode ser instanciada, é um modelo para as classes que irão herdar seu comportamento
//Esta classe facilita para que não precisemos em todas as Classes DAO executar todo este código, 
//iremos apenas passar os parâmetros
public abstract class GenericDAO {

    private Connection conexao;

    // Protected pois pertencem a esta classe, somente podem ser usadas por classes
    // que herdam desta
    protected GenericDAO() {
        this.conexao = ConexaoBD.conectar();
    }

    // Método que retorna a conexaao
    protected Connection conectarDAO() {
        this.conexao = ConexaoBD.conectar();
        return conexao;
    }

    protected void save(String insertSql, Object... parametros ) throws SQLException {
        PreparedStatement pstmt = conectarDAO().prepareStatement(insertSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        conexao.close();
    }

    // Método para atualizar
    protected void update(String updateSql, Object id, Object... parametros) throws SQLException {
        PreparedStatement pstmt = conectarDAO().prepareStatement(updateSql);
        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
        conexao.close();
    }

    // Método para deletar
    protected void delete(String deleteSql, Object... parametros) throws SQLException {
        PreparedStatement pstmt = conectarDAO().prepareStatement(deleteSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }

        pstmt.execute();
        pstmt.close();
        conexao.close();
    }
    
    /* Pensar em um metodo que faça isso, Mas não sabemos fazer essas modificações. Retornar o Lotes ou outro objeto é possivel? 
    protected Object list(String listSql, Object... parametros) throws SQLException{
        PreparedStatement pstmt = conectarDAO().prepareStatement(listSql);

        for (int i = 0; i < parametros.length; i++) {
            pstmt.setObject(i + 1, parametros[i]);
        }
        
        Object x = pstmt;
        
        pstmt.execute();
        pstmt.close();
        conexao.close();
        return x;
    } */
}
