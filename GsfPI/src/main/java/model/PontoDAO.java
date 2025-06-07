package model;


import dal.ConexaoBD;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Ponto;

public class PontoDAO extends GenericDAO{

    private final Connection connection;

    public PontoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public boolean cadastroHora(long cpf){
        String sql;
        Ponto verificar = select(cpf);
        if(verificar.getHoraEntradaM() == null){
            sql = "";
        }else if(verificar.getHoraSaidaM() == null){
            sql ="";
        }else if(verificar.getHoraEntradaV() == null){
            sql="";
        }else if(verificar.getHoraSaidaV() == null){
            sql = "";
        }
        return false;
    }
    
    public Ponto select(Object... parametros){
        String sql = "SELECT* FROM registrohora WHERE Cpf = ?";
        Ponto p = null;
        int id;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    //int id,long cpf , LocalDate data, LocalTime horaEntrada, LocalTime horaSaida
                          
                    Ponto objeto = new Ponto(
                        rs.getInt("id"),
                        rs.getLong("Cpf"),
                        rs.getDate("data").toLocalDate(),
                        rs.getTime("HorarioEntradaM"),
                        rs.getTime("HorarioSaidaM"),
                        rs.getTime("HorarioEntradaV"),
                        rs.getTime("HorarioSaidaMV")
                    );
                    p = objeto;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return p;
    }
    
    public List<Ponto> listarPontos() {
        List<Ponto> lista = new ArrayList<>();
        String sql = "SELECT * FROM ponto";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ponto ponto = new Ponto(
                    rs.getInt("id"),
                    rs.getLong("Cpf"),
                    rs.getDate("data").toLocalDate(),
                    rs.getTime("HorarioEntradaM"),
                    rs.getTime("HorarioSaidaM"),
                    rs.getTime("HorarioEntradaV"),
                    rs.getTime("HorarioSaidaMV")
                );
                lista.add(ponto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}