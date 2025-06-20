package model;


import dal.ConexaoBD;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.Alertas;

public class PontoDAO extends GenericDAO{

    Alertas alertas = new Alertas();
    public boolean cadastroHora(long cpf, LocalDate data, Time hora){
        String sql;
        Ponto p = select(cpf, data);
        int id=0;
        try{
            if(p == null){
                id = numId();
                sql = "INSERT INTO registrohora (idRegistroHora,Cpf,DataRegistro, HorarioEntradaM) VALUES (?,?,?,?)";
                save(sql, id, cpf, data, hora);
                return true;
            }
             if(p.getHoraSaidaM() == null){
                sql ="UPDATE registrohora SET HorarioSaidaM = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, hora, data);
                return true;
            }else if(p.getHoraEntradaV() == null){
                sql="UPDATE registrohora SET HorarioEntradaV = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, hora, data);
               return true;
            }else if(p.getHoraSaidaV() == null){
                sql = "UPDATE registrohora SET HorarioSaidaV = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, cpf, hora, data);
                return true;
            }else if(p.getHorarioEntradaEx() == null){
                sql = "UPDATE registrohora SET HorarioEntradaEx = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, cpf, hora, data);
                return true;
            }else if(p.getHorarioSaidaEx() == null){
                sql = "UPDATE registrohora SET HorarioSaidaEx = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, cpf, hora, data);
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
        String sql = "SELECT FROM registrohora WHERE Cpf = ? AND DataRegistro = ?";
        Ponto p = null;
        LocalTime hem, hev, hsm, hsv, hee, hse;
        int id;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    if(rs.getTime("HorarioEntradaM") == null){
                        hem = null;
                    }else{
                        hem = rs.getTime("HorarioEntradaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaM") == null){
                        hsm = null;
                    }else{
                        hsm = rs.getTime("HorarioSaidaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioEntradaV") == null){
                        hev = null;
                    }else{
                        hev = rs.getTime("HorarioEntradaV").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaV") == null){
                        hsv = null;
                    }else{
                        hsv = rs.getTime("HorarioSaidaV").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioEntradaEx") == null){
                        hee = null;
                    }else{
                        hee = rs.getTime("HorarioEntradaEx").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaEx") == null){
                        hse = null;
                    }else{
                        hse = rs.getTime("HorarioSaidaEx").toLocalTime();
                    }
                    
                    p = new Ponto(
                        rs.getInt("idRegistroHora"),
                        rs.getLong("Cpf"),
                        rs.getDate("DataRegistro").toLocalDate(),
                        hem,
                        hsm,
                        hev,
                        hsv,
                        hee,
                        hse
                    );
                    return p;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        return p;
    }
    
    public List<Ponto> listarPontos(Object... parametros) {
        List<Ponto> lista = new ArrayList<>();
        String sql = "SELECT * FROM registrohora WHERE Cpf = ?";
         LocalTime hem, hev, hsm, hsv, hee, hse;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                     if(rs.getTime("HorarioEntradaM") == null){
                        hem = null;
                    }else{
                        hem = rs.getTime("HorarioEntradaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaM") == null){
                        hsm = null;
                    }else{
                        hsm = rs.getTime("HorarioSaidaM").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioEntradaV") == null){
                        hev = null;
                    }else{
                        hev = rs.getTime("HorarioEntradaV").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaV") == null){
                        hsv = null;
                    }else{
                        hsv = rs.getTime("HorarioSaidaV").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioEntradaEx") == null){
                        hee = null;
                    }else{
                        hee = rs.getTime("HorarioEntradaEx").toLocalTime();
                    }
                    
                    if(rs.getTime("HorarioSaidaEx") == null){
                        hse = null;
                    }else{
                        hse = rs.getTime("HorarioSaidaEx").toLocalTime();
                    }
                    
                    Ponto ponto = new Ponto(
                        rs.getInt("idRegistroHora"),
                        rs.getLong("Cpf"),
                        rs.getDate("DataRegistro").toLocalDate(),
                        hem,
                        hsm,
                        hev,
                        hsv, 
                        hee,
                        hse
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
    
    public boolean editarHorario(Ponto p){
        String sql;
         try{
            sql ="UPDATE registrohora SET HorarioEntradaM = ?, HorarioSaidaM = ?, HorarioEntradaV = ?, HorarioSaidaV = ?, HorarioEntradaEx = ?,"
                    + "HorarioSaidaEx = ? WHERE DataRegistro = ? AND Cpf = ?";
            update(sql, p.getCpf(),p.getHoraEntradaM(),p.getHoraSaidaM(),p.getHoraEntradaV(),p.getHoraSaidaV(),p.getHorarioEntradaEx(),
                    p.getHorarioSaidaEx(),p.getData());
            return true;
         }catch (SQLException e) {  
            e.printStackTrace();
            return false;
        }
    }
}