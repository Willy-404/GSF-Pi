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
            alertas.alertaError("Campo Vazio", "O campo "+campo+" está vazio, necessario digitar um valor");
            return true;
        }
        return false;
    }
    
     //metodo para verificar se campo está nulo com texto
    public boolean itemNull(String item, String campo){
        if(item == null){
            alertas.alertaError("Campo Vazio", "O campo "+campo+" está vazio, necessario digitar um valor");
            return true;
        }
        return false;
    }
    
    //metodo para validar o tamanho de um texto
    public boolean ValidaTamanhoText(int tamanho, String texto){
        if(texto.length() != tamanho){
            alertas.alertaError("Tamanho Incompativel!","Tamanho do texto digitado maior do que o permitido!");
           return true;
        }
        return false;
    }
    
    //metodo para validar o padrão de email 
    public boolean ValidaFormatEmail(String Email){
        String emailFormat = "^[^\\s@]+@gmail\\.com\\.br$";
        if(!Pattern.compile(emailFormat).matcher(Email).matches()){
            alertas.alertaError("Formato do email incorreto", "O padrão esperado é emailValido@gmail.com");
            return true;
        }
        return false;
    }
      
    //metodo para validar o padrão de CNPJ 
    public boolean ValidaFormatoCnpj(String cnpj){
        String cnpjFormat = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
        if(!Pattern.compile(cnpjFormat).matcher(cnpj).matches()){
             alertas.alertaError("Formato do CNPJ incorreto", "O padrão esperado é XX.XXX.XXX/XXXX-XX");
            return true;
        }
        return false;
    }
    
    //metodo para validar se existe o CNPJ no sistema
    public boolean ItemCNPJnoSistema(String cnpj, String nomeTabelaSQL, String nomeElemento, Object... parametros){
        int cnpjNum = Integer.valueOf(cnpj);
        String sql = "Select* FROM "+ nomeTabelaSQL +" WHERE "+nomeElemento+ "= ?";
        int validar = 0;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
             for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                validar++;
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
             alertas.alertaError("Formato do CPF incorreto", "O padrão esperado é XXX.XXX.XXX-XX");
            return true;
        }
        return false;
    }
    
    //metodo para validar se existe o CPF no sistema
    public boolean ValidaCPFSistema(String cpf,String nomeTabelaSQL, Object... parametros){
         int cpfNum = Integer.valueOf(cpf);
        String sql = "Select* FROM funcionario WHERE Cpf = ?";
        int validar = 0;
        try (Connection connection = ConexaoBD.conectar();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
           
            for (int i = 0; i < parametros.length; i++) {
                preparedStatement.setObject(i + 1, parametros[i]);
            }
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                validar++;
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
    
    //metodo para validar o padrão de CPF 
    public boolean ValidaFormatTell(String tell){
        String tellFormat = "^\\(\\d{2}\\)\\ \\d{5}\\-\\d{4}\\$";
        if(!Pattern.compile(tellFormat).matcher(tell).matches()){
             alertas.alertaError("Formato do CPF incorreto", "O padrão esperado é XXX.XXX.XXX-XX");
            return true;
            /*como faremos o armazenamento dos numeros sem o padrão escrito, quando voltar pro sistema tem como usar replaceAll(format, "$1 $2")
            sendo o  1 e 2 os grupos do format.*/
        }
        return false;
    }
    
    /*Será que precisa formatar a data já que o datapicker ja faz a data padrão local (Brasil no nosso caso)
    Será que precisa de validação por tamanho max de componente, exemplo: Nome max 30 caracteres, então uma 
    mensagem de error se for maior doq isso */
}
