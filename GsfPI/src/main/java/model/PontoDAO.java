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
    FuncionarioDAO fmetodo = new FuncionarioDAO();
    public boolean cadastroHora(long cpf, LocalDate data, Time hora) throws SQLException{
        String sql, txtHoraS, txtHoraE;
        Ponto p = select(cpf, data);
        Funcionario f = fmetodo.select(p.getCpf());
        float contaSalario, horaS, horaE, horaET, horaST;
        int id=0, horaEI, horaSI;
        try{
            if(p == null){
                id = numId();
                sql = "INSERT INTO registrohora (idRegistroHora,Cpf,DataRegistro, HorarioEntradaM) VALUES (?,?,?,?)";
                save(sql, id, cpf, data, hora);
                return true;
            }else if(p.getHoraSaidaM() == null){
                sql ="UPDATE registrohora SET HorarioSaidaM = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, hora, data);
                
                //Fazer o calculo de cada horarios fechado, pra ficar mais facil;
                txtHoraS = String.valueOf(hora).replaceAll("[:]", ".");
                txtHoraE = String.valueOf(p.getHoraEntradaM()).replaceAll("[:]", ".");
                
                horaE = Float.parseFloat(txtHoraE);
                horaEI = (int)horaE;
                horaET = ((horaE - horaEI)/60)+ horaEI;
                
                horaS = Float.parseFloat(txtHoraS);
                horaSI =(int)horaS;
                horaST = ((horaE - horaEI)/60)+ horaEI;
                
                contaSalario = ((horaST - horaET)* f.getValorHora()) + p.getSalarioDoDia();
                sql = "UPDATE registrohora SET SalarioDoDia = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, contaSalario, data);
                return true;
            }else if(p.getHoraEntradaV() == null){
                sql="UPDATE registrohora SET HorarioEntradaV = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, hora, data);
               return true;
            }else if(p.getHoraSaidaV() == null){
                sql = "UPDATE registrohora SET HorarioSaidaV = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, cpf, hora, data);
                 
                txtHoraS = String.valueOf(hora).replaceAll("[:]", ".");
                txtHoraE = String.valueOf(p.getHoraEntradaM()).replaceAll("[:]", ".");
                
                horaE = Float.parseFloat(txtHoraE);
                horaEI = (int)horaE;
                horaET = ((horaE - horaEI)/60)+ horaEI;
                
                horaS = Float.parseFloat(txtHoraS);
                horaSI =(int)horaS;
                horaST = ((horaE - horaEI)/60)+ horaEI;
                
                contaSalario = ((horaST - horaET)* f.getValorHora()) + p.getSalarioDoDia();
                sql = "UPDATE registrohora SET SalarioDoDia = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, contaSalario, data);
                return true;
            }else if(p.getHorarioEntradaEx() == null){
                sql = "UPDATE registrohora SET HorarioEntradaEx = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, cpf, hora, data);
                return true;
            }else if(p.getHorarioSaidaEx() == null){
                sql = "UPDATE registrohora SET HorarioSaidaEx = ? WHERE DataRegistro = ? AND Cpf = ?";
                 update(sql, cpf, hora, data);
                 
                txtHoraS = String.valueOf(hora).replaceAll("[:]", ".");
                txtHoraE = String.valueOf(p.getHoraEntradaM()).replaceAll("[:]", ".");
                
                horaE = Float.parseFloat(txtHoraE);
                horaEI = (int)horaE;
                horaET = ((horaE - horaEI)/60)+ horaEI;
                
                horaS = Float.parseFloat(txtHoraS);
                horaSI =(int)horaS;
                horaST = ((horaE - horaEI)/60)+ horaEI;
                
                contaSalario = ((horaST - horaET)* f.getValorHora()) + p.getSalarioDoDia();
                sql = "UPDATE registrohora SET SalarioDoDia = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, cpf, contaSalario, data);
                return true;
            }else{
                alertas.alertaError("Cadastros Feitos para o dia de hoje", "Foram feitos os 6 registros do dia de hoje."
                        + "Chame um responsavel para fazer o registro de forma Manual!");
                return false;
            }
        }catch (SQLException e) {  
            e.printStackTrace();
            alertas.alertaError("Erro ao cadastrar", "Erro ao cadastrar o Horario!");
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
                        hse,
                        rs.getFloat("SalarioDoDia")
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
                        hse,
                        rs.getFloat("SalarioDoDia")
                    );
                    lista.add(ponto);
                }
            }
        }  catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }

        return lista;
    }
    
    public List<Ponto> pesquisa(String sql, Object... parametros){
        List<Ponto> lista = new ArrayList<>();
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
                        hse,
                        rs.getFloat("SalarioDoDia")                            
                    );
                    lista.add(ponto);
                }
            }
        }catch (SQLException e) {
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
    
    public boolean editarHorario(Ponto p) throws SQLException{
        String sql, txtHoraS, txtHoraE;
        float contaSalario, horaS, horaE, horaET, horaST;
        int horaSI, horaEI;
        Ponto pSelect;
        Funcionario f = fmetodo.select(p.getCpf());
         try{
            sql ="UPDATE registrohora SET HorarioEntradaM = ?, HorarioSaidaM = ?, HorarioEntradaV = ?, HorarioSaidaV = ?, HorarioEntradaEx = ?,"
                    + "HorarioSaidaEx = ? WHERE DataRegistro = ? AND Cpf = ?";
            update(sql, p.getCpf(),p.getHoraEntradaM(),p.getHoraSaidaM(),p.getHoraEntradaV(),p.getHoraSaidaV(),p.getHorarioEntradaEx(),
                    p.getHorarioSaidaEx(),p.getData());
            //Conta pro salario de dia 
            if((p.getHoraEntradaM() != null) && (p.getHoraSaidaM() != null)){
                txtHoraS = String.valueOf(p.getHoraSaidaM()).replaceAll("[:]", ".");
                txtHoraE = String.valueOf(p.getHoraEntradaM()).replaceAll("[:]", ".");
                
                horaE = Float.parseFloat(txtHoraE);
                horaEI = (int)horaE;
                horaET = ((horaE - horaEI)/60)+ horaEI;
                
                horaS = Float.parseFloat(txtHoraS);
                horaSI =(int)horaS;
                horaST = ((horaE - horaEI)/60)+ horaEI;
                
                contaSalario = ((horaST - horaET)* f.getValorHora()) + p.getSalarioDoDia();
                sql = "UPDATE registrohora SET SalarioDoDia = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, p.getCpf(), contaSalario, p.getData());
            }
            pSelect = select(p.getData(), p.getCpf());
            if((p.getHoraEntradaV() != null) && (p.getHoraSaidaV() != null)){
                txtHoraS = String.valueOf(p.getHoraSaidaV()).replaceAll("[:]", ".");
                txtHoraE = String.valueOf(p.getHoraEntradaV()).replaceAll("[:]", ".");
                 
                horaE = Float.parseFloat(txtHoraE);
                horaEI = (int)horaE;
                horaET = ((horaE - horaEI)/60)+ horaEI;
                
                horaS = Float.parseFloat(txtHoraS);
                horaSI =(int)horaS;
                horaST = ((horaE - horaEI)/60)+ horaEI;
                
                contaSalario = ((horaST - horaET)* f.getValorHora()) + p.getSalarioDoDia();
                sql = "UPDATE registrohora SET SalarioDoDia = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, p.getCpf(), contaSalario, p.getData());
            }
            pSelect = select(p.getData(), p.getCpf());
            if((p.getHorarioEntradaEx()!= null) && (p.getHorarioSaidaEx()!= null)){
                txtHoraS = String.valueOf(p.getHorarioSaidaEx()).replaceAll("[:]", ".");
                txtHoraE = String.valueOf(p.getHorarioEntradaEx()).replaceAll("[:]", ".");
                 
                horaE = Float.parseFloat(txtHoraE);
                horaEI = (int)horaE;
                horaET = ((horaE - horaEI)/60)+ horaEI;
                
                horaS = Float.parseFloat(txtHoraS);
                horaSI =(int)horaS;
                horaST = ((horaE - horaEI)/60)+ horaEI;
                
               contaSalario = ((horaST - horaET)* f.getValorHora()) + p.getSalarioDoDia();
                sql = "UPDATE registrohora SET SalarioDoDia = ? WHERE DataRegistro = ? AND Cpf = ?";
                update(sql, p.getCpf(), contaSalario, p.getData());
            }
            return true;
         }catch (SQLException e) {  
            e.printStackTrace();
            return false;
        }
    }
}