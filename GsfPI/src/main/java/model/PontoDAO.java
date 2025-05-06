package model;


import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Ponto;

public class PontoDAO {

    private final Connection connection;

    public PontoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Ponto> listarPontos() {
        List<Ponto> lista = new ArrayList<>();
        String sql = "SELECT * FROM ponto";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Ponto ponto = new Ponto(
                    rs.getInt("id"),
                    rs.getString("nome_funcionario"),
                    rs.getDate("data").toLocalDate(),
                    rs.getTime("entrada").toLocalTime(),
                    rs.getTime("saida").toLocalTime(),
                    rs.getDouble("horas_trabalhadas")
                );
                lista.add(ponto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}