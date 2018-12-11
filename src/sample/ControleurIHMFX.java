package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;
        vue.gridPane.setOnKeyPressed(new MyAction());
        vue.gridPane.requestFocus();
    }

    class MyAction implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {

            KeyCode input = event.getCode();
            if (input.equals(KeyCode.LEFT)) {
                System.out.println("LEFT");
                controleur.move(4);
            } else if (input.equals(KeyCode.RIGHT)) {
                System.out.println("RIGHT");
                controleur.move(6);
            } else if (input.equals(KeyCode.UP)) {
                System.out.println("UP");
                controleur.move(8);
            } else if (input.equals(KeyCode.DOWN)) {
                System.out.println("DOWN");
                controleur.move(2);
            }
        }
    }
}
