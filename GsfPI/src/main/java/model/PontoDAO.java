package model;


import dal.ConexaoBD;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PontoDAO extends GenericDAO{

    
    public boolean cadastroHora(long cpf, LocalDate data, int id, Time hora){
        String sql;
        Ponto p = select(cpf);
        try{
            if(p == null){
                sql = "INSERT INTO registrohora (idRegistroHora,Cpf,DataRegistro) VALUES (?,?,?)";
                save(sql, id, cpf, data);
            }
            if(p.getHoraEntradaM() == null){
                sql = "UPDATE registrohora SET HorarioEntradaM = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, hora, cpf, data);
                return true;
            }else if(p.getHoraSaidaM() == null){
                sql ="UPDATE registrohora SET HorarioSaidaM = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, data, cpf, hora);
                return true;
            }else if(p.getHoraEntradaV() == null){
                sql="UPDATE registrohora SET HorarioEntradaV = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, data, cpf, hora);
               return true;
            }else if(p.getHoraSaidaV() == null){
                sql = "UPDATE registrohora SET HorarioSaidaV = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, data, cpf, hora);
                return true;
            }else{
               return false;
            }
        }catch (SQLException e) {  
            e.printStackTrace();
            return false;
        }
    }
    
    public Ponto select(Object... parametros){
        String sql = "SELECT* FROM registrohora WHERE Cpf = ?";
        Ponto p = null;
        LocalTime hem, hev, hsm, hsv;
        int id;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    if(rs.getTime("HorarioEntradaM") == null){
                        hem = LocalTime.MIN;
                    }else{
                        hem = rs.getTime("HorarioEntrada").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaM") == null){
                        hsm = LocalTime.MIN;
                    }else{
                        hsm = rs.getTime("HorarioSaidaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioEntradaV") == null){
                        hev = LocalTime.MIN;
                    }else{
                        hev = rs.getTime("HorarioSaidaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaV") == null){
                        hsv = LocalTime.MIN;
                    }else{
                        hsv = rs.getTime("HorarioSaidaV").toLocalTime();
                    }
                    
                    p = new Ponto(
                        rs.getInt("idRegistroHora"),
                        rs.getLong("Cpf"),
                        rs.getDate("DataRegistro").toLocalDate(),
                        hem,
                        hsm,
                        hev,
                        hsv
                    );
                    return p;
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
        LocalTime hem, hev, hsm, hsv;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    if(rs.getTime("HorarioEntradaM") == null){
                        hem = LocalTime.MIN;
                    }else{
                        hem = rs.getTime("HorarioEntrada").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaM") == null){
                        hsm = LocalTime.MIN;
                    }else{
                        hsm = rs.getTime("HorarioSaidaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioEntradaV") == null){
                        hev = LocalTime.MIN;
                    }else{
                        hev = rs.getTime("HorarioSaidaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaV") == null){
                        hsv = LocalTime.MIN;
                    }else{
                        hsv = rs.getTime("HorarioSaidaV").toLocalTime();
                    }
                    Ponto ponto = new Ponto(
                        rs.getInt("idRegistroHora"),
                        rs.getLong("Cpf"),
                        rs.getDate("DataRegistro").toLocalDate(),
                        hem,
                        hsm,
                        hev,
                        hsv
                    );
                    lista.add(ponto);
                }
            }
        }  catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        return lista;
    }
    
    public int numId(){
        String sql = "SELECT* FROM registrohora";
        int i = 0;
         try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while(rs.next()){
                   i++;
                }
            }
        }  catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
         return i;
    }
}