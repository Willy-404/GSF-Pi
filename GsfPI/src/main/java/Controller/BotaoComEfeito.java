package Controller;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.paint.Color;

public class BotaoComEfeito {

    public static void aplicarEfeito(Button botao) {
        // Estilo inicial
        botao.setStyle("-fx-background-color:  #5496c5; -fx-text-fill: white; -fx-font-size: 14px; -fx-background-radius: 100px; -fx-cursor: hand;");
        DropShadow sombraNormal = new DropShadow(6, Color.rgb(0, 0, 0, 0.3));
        sombraNormal.setOffsetY(2);
        botao.setEffect(sombraNormal);

        // Ao pressionar
        botao.setOnMousePressed(e -> {
            InnerShadow inner = new InnerShadow(8, Color.rgb(0, 0, 0, 0.4));
            inner.setOffsetY(2);
            botao.setEffect(inner);
            botao.setScaleX(0.98);
            botao.setScaleY(0.98);
            botao.setTranslateY(1);
        });

        // Ao soltar
        botao.setOnMouseReleased(e -> {
            botao.setEffect(sombraNormal);
            botao.setScaleX(1);
            botao.setScaleY(1);
            botao.setTranslateY(0);
        });
    }
}