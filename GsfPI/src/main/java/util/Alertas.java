/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author fwand
 */
public class Alertas {
    public void alertaError(String titulo, String mensagem){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(mensagem);
        alerta.showAndWait();
    }
    
    public void alertaInformation(String titulo, String mensagem){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(mensagem);
        alerta.showAndWait();
    }
}
