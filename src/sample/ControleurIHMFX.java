package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    Button depH;
    Button depB;
    Button depG;
    Button depD;

    ControleurIHMFX(Controleur controleur, VueIHMFX vue) {
        this.controleur = controleur;
        this.vue = vue;

        for (int i=0; i<vue.myButton.length;i++)
            vue.myButton[i].setOnAction(new MyAction(i));

        depH = new Button("haut");
        depB = new Button("bas");
        depG = new Button("gauche");
        depD = new Button("droite");

        depH.setOnAction(new ActionHaut());
        depB.setOnAction(new ActionBas());
        depG.setOnAction(new ActionGauche());
        depD.setOnAction(new ActionDroite());
    }

    class ActionHaut implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.move(8);
        }
    }

    class ActionBas implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.move(2);
        }
    }

    class ActionGauche implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.move(4);
        }
    }

    class ActionDroite implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.move(6);
        }
    }

    class MyAction implements EventHandler<ActionEvent> {
        int indice;

        MyAction(int indice) {
            this.indice = indice;
        }

        @Override
        public void handle(ActionEvent event) {
            controleur.move(indice);
        }
    }
}