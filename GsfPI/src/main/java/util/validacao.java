/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.regex.Pattern;

/**
 *
 * @author fwand
 */

public class validacao {
    //objeto de alertas para mensagens 
    Alertas alertas = new Alertas();
    
    //metodo para validar o tamanho de um texto
    public boolean ValidaTamanhoText(int tamanho, String texto){
        if(texto.length() != tamanho){
            alertas.alertaError("Tamanho Incompativel!","Tamanho do texto digitado maior do que o permitido!");
           return false;
        }
        
        return true;
    }
    
    //metodo para validar o padrão de email 
    public boolean ValidaEmail(String Email){
        String emailFormat = "^[^\\s@]+@gmail\\.com\\.br$";;
        if(!Pattern.compile(emailFormat).matcher(Email).matches()){
            alertas.alertaError("Formato do email incorreto", "O padrão esperado é emailvalido@gmail.com");
            return false;
        }
        
        return true;
    }
    
    //metodo para verificar se campo está vazio com texto
    public boolean itemVazioComTxt(String item, String campo){
        if(item.isEmpty()){
            alertas.alertaError("Campo Vazio", "O campo "+campo+" está vazio, necessario digitar um valor");
            return false;
        }
        
        return true;
    }
    
    //metodo para verificar se campo está vazio sem texto
    public boolean itemVazio(String item){
        if(item.isEmpty()){
            return false;
        }
        
        return true;
    }
    
    //metodo para validar o padrão de CNPJ 
    public boolean ValidaFormatoCnpj(String cnpj){
        String cnpjFormat = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$";
        if(!Pattern.compile(cnpjFormat).matcher(cnpj).matches()){
             alertas.alertaError("Formato do CNPJ incorreto", "O padrão esperado é XX.XXX.XXX/XXXX-XX");
            return false;
        }
        return true;
    }
    
    //metodo para validar se existe o CNPJ no sistema
    public boolean ValidaCNPJSistema(){
        
        return true;
    }
    
    //metodo para validar o padrão de CPF 
    public boolean ValidaFormatoCpf(String cpf){
        String cpfFormat = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
        if(!Pattern.compile(cpfFormat).matcher(cpf).matches()){
             alertas.alertaError("Formato do CPF incorreto", "O padrão esperado é XXX.XXX.XXX-XX");
            return false;
        }
        return true;
    }
    
    //metodo para validar se existe o CPF no sistema
    public boolean ValidaCPFSistema(){
        
        return true;
    }
    
    //metodo para validar o padrão de CPF 
    public boolean ValidaTell(String tell){
        String tellFormat = "^\\(\\d{2}\\)\\ \\d{5}\\-\\d{4}\\$";
        if(!Pattern.compile(tellFormat).matcher(tell).matches()){
             alertas.alertaError("Formato do CPF incorreto", "O padrão esperado é XXX.XXX.XXX-XX");
            return false;
            /*como faremos o armazenamento dos numeros sem o padrão escrito, quando voltar pro sistema tem como usar replaceAll(format, "$1 $2")
            sendo o  1 e 2 os grupos do format.*/
        }
        return true;
    }
    
    /*Será que precisa formatar a data já que o datapicker ja faz a data padrão local (Brasil no nosso caso)
    Será que precisa de validação por tamanho max de componente, exemplo: Nome max 30 caracteres, então uma 
    mensagem de error se for maior doq isso */
}
