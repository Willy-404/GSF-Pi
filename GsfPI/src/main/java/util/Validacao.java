package util;

import dal.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class Validacao {
    //objeto de alertas para mensagens 
    Alertas alertas = new Alertas();
    
    //metodo para verificar se campo está vazio com texto
    public boolean itemisEmpty(String item, String campo){
        if(item.isEmpty()){
            alertas.alertaError("Campo Vazio", "O campo "+campo+" está vazio, necessario digitar um valor!");
            return true;
        }
        return false;
    }
    
     //metodo para verificar se campo está nulo com texto
    public boolean itemNull(String item, String campo){
        if(item == null){
            alertas.alertaError("Campo Vazio", "O campo "+campo+" está vazio, necessario digitar um valor!");
            return true;
        }
        return false;
    }
    
    //metodo para validar o tamanho de um texto
    public boolean ValidaTamanhoText(int tamanho, String texto, String campo){
        if(texto.length() != tamanho){
            alertas.alertaError("Tamanho do campo " +campo+ " Incompativel!","Tamanho do texto digitado no campo "+ campo +" fora do permitido!");
           return true;
        }
        return false;
    }
    
    //metodo para validar o padrão de email 
    public boolean ValidaFormatEmail(String Email){
        String emailFormat = "^[^\\s@]+@gmail\\.com$";
        if(!Pattern.compile(emailFormat).matcher(Email).matches()){
            alertas.alertaError("Formato do email incorreto", "O padrão esperado é emailValido@gmail.com!");
            return true;
        }
        return false;
    }
    
    public boolean ItemEmailnoSistema(String email, String nomeTabelaSQL, String nomeElemento, Object... parametros){
        int validar = 0;
        String sql = "Select "+nomeElemento+ " FROM "+ nomeTabelaSQL +" WHERE "+nomeElemento+ " = ?", rs = null;
        System.out.println(sql);
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
             for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    rs = resultSet.getString(nomeElemento);
                    System.out.println(rs);
                    System.out.println(email);
                }
                if(rs.equals(email)){
                    validar++;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        if(validar != 0){
            alertas.alertaError("Email no sistema","O Email digitado já esta no sistema! \n Digite outro Email válido para realizar o cadastro!");
            return true;
        }else {
            return false;
        }
    }
      
    //metodo para validar o padrão de CNPJ 
    public boolean ValidaFormatoCnpj(String cnpj){
        String cnpjFormat = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
        if(!Pattern.compile(cnpjFormat).matcher(cnpj).matches()){
             alertas.alertaError("Formato do CNPJ incorreto", "O padrão esperado é XX.XXX.XXX/XXXX-XX!");
            return true;
        }
        return false;
    }
    
    //metodo para validar se existe o CNPJ no sistema
    public boolean ItemCNPJnoSistema(String cnpj, String nomeTabelaSQL, String nomeElemento, Object... parametros){
        String cnpjSemPontos = cnpj.replaceAll("[./-]", ""), sql = "Select "+nomeElemento+ " FROM "+ nomeTabelaSQL +" WHERE "+nomeElemento+ " = ?";
        long cnpjnum = Long.parseLong(cnpjSemPontos), rs = 0;
        int validar = 0;
        
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
             for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    rs = resultSet.getLong(nomeElemento);
                }
                if(rs == cnpjnum){
                    validar++;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        if(validar != 0){
            alertas.alertaError("CNPJ no sistema","O CNPJ digitado já esta no sistema! \n Digite outro CNPJ válido para realizar o cadastro!");
            return true;
        }else {
            return false;
        }
    }
    
    //metodo para validar o padrão de CPF 
    public boolean ValidaFormatoCpf(String cpf){
        String cpfFormat = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        if(!Pattern.compile(cpfFormat).matcher(cpf).matches()){
             alertas.alertaError("Formato do CPF incorreto", "O padrão esperado é XXX.XXX.XXX-XX!");
            return true;
        }
        return false;
    }
    
    //metodo para validar se existe o CPF no banco de dados 
    public boolean ValidaCPFSistema(String cpf, Object... parametros){
        String cpfSemPontos = cpf.replaceAll("[.-]", ""), sql = "Select Cpf FROM funcionario WHERE Cpf = ?" ;
        long cpfNum = Long.parseLong(cpfSemPontos), rs = 0;
        int validar = 0;
       
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
             for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    rs = resultSet.getLong("Cpf");
                }
                if(rs == cpfNum){
                    validar++;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        if(validar != 0){
            alertas.alertaError("CPF no sistema","O CPF digitado já esta no sistema! \n Digite outro CPF válido para realizar o cadastro!");
            return true;
        }else {
            return false;
        }

    }
    
    //Valida se existe a referencia no banco de dados
    public boolean ValidaRefSistema(String ref, Object... parametros){
        String sql = "Select Referencia FROM lote WHERE Referencia = ?" ;
        int refInt = Integer.parseInt(ref), rs = 0;
        int validar = 0;
       
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
             for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
                    rs = resultSet.getInt("Referencia");
                }
                if(rs == refInt){
                    validar++;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
        if(validar != 0){
            alertas.alertaError("Referenccia no sistema","A Referencia digitada já esta no sistema! \n Digite outra Referencia válida para realizar o cadastro!");
            return true;
        }else {
            return false;
        }

    }
    //metodo para validar o padrão de Telefone 
    public boolean ValidaFormatTell(String tell){
        String tellFormat = "^\\(\\d{2}\\) \\d{5}-\\d{4}$";
        if(!Pattern.compile(tellFormat).matcher(tell).matches()){
             alertas.alertaError("Formato do Telefone incorreto", "O padrão esperado é (XX) XXXXX-XXXX!");
            return true;
            /*como faremos o armazenamento dos numeros sem o padrão escrito, quando voltar pro sistema tem como usar replaceAll(format, "$1 $2")
            sendo o  1 e 2 os grupos do format.*/
        }
        return false;
    }
    
    public boolean ValidarFormat(String format, String texto, String tituloAlerta, String textoAlerta){
        if(!Pattern.compile(format).matcher(texto).matches()){
            alertas.alertaError(tituloAlerta, textoAlerta);
            return true;
        }
        return false;
    }
    /*Será que precisa formatar a data já que o datapicker ja faz a data padrão local (Brasil no nosso caso), 
    formato de data caso necessario ^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$.
    Será que precisa de validação por tamanho max de componente, exemplo: Nome max 30 caracteres, então uma 
    mensagem de error se for maior doq isso.
    */
}
