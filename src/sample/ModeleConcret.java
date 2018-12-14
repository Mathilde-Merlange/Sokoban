package sample;

import java.util.ArrayList;
import java.util.List;

public class ModeleConcret implements Modele {


    /* Correspondance entier élément:
     * 0 : mur (#)  soko[0]
     * 1 : caisse ($)  soko[1]
     * 2 : destination (.)  soko[2]
     * 3 : caisse sur une zone de rangement (*)  soko[3]
     * 4 : personnage sur une zone de rangement (+)  soko[4]
     * 5 : sol ( )  soko[5]
     * 6 : soko (@)  soko[4]
     */
    public int[][] etat = {{0, 0, 0, 0, 0}, {0, 5, 2, 5, 0}, {0, 5, 1, 5, 0}, {0, 5, 4, 5, 0}, {0, 0, 0, 0, 0}};
    int posx = 3; // abscisse soko
    int posy = 2; // ordonnée soko
    int caissesRestantes=1;
    int nbM=0; // nb dép soko
    int nbC=0; // nb dép caisse
    /*
    * int valeur du déplacement (2,4,6,8)
    * -int = dép caisse
     */
    ArrayList stock = new ArrayList();

    public void move(int indice) {
        int x, y;
        switch (indice) {
            case 2:
                x = posx;
                y = posy + 1;
                echanger(x, y, posx, posy, indice);
                break;
            case 4:
                x = posx - 1;
                y = posy;
                echanger(x, y, posx, posy, indice);
                break;
            case 6:
                x = posx + 1;
                y = posy;
                echanger(x, y, posx, posy, indice);
                break;
            case 8:
                x = posx;
                y = posy - 1;
                echanger(x, y, posx, posy, indice);
                break;
        }
        System.out.println("nbc = "+nbC);
        System.out.println("nbm = "+nbM);
        for (int i=0; i<stock.size();i++) System.out.println("stock "+i +" :" + stock.get(i));
    }

    public int[] convI(int indice, int u, int v) {
        int[]t={u,v};
        switch (indice) {
            case 2:
                t[1]= t[1]+1;
                break;
            case 4:
                t[0]=t[0]-1;
                break;
            case 6:
                t[0]=t[0]+1;
                break;
            case 8:
                t[1]= t[1]-1;
                break;
        }
        return t;
    }


    public void echanger(int x, int y, int px, int py, int indice) {
        int u = x;
        int v = y;
        int[]t={u,v};
        switch (etat[x][y]) {
            case 0:
                System.out.println("You shall not pass");
                break;
            case 1: case 3:
                t=convI(indice, u, v);
                if(etat[t[0]][t[1]]==0){
                    System.out.println("do NOT move");
                    break;
                }
                t=convI(indice, u, v);
                if(etat[t[0]][t[1]]==2){
                    etat[t[0]][t[1]]=3;
                    etat[x][y]=5;
                    switchvar(x, y, px, py);
                    caissesRestantes-=1;
                    if (caissesRestantes==0){
                        System.out.println("VICTOIRE !!!!");
                    }
                    break;
                }
                switchvar(t[0], t[1], x, y); // caisse VS sol
                switchvar(x, y, px, py); // sol VS soko
                posx = x;
                posy = y;
                nbC+=1;
                nbM+=1;
                stock.add(indice);
                stock.add(-indice);
                break;
            default:
                switchvar(x, y, px, py);
                posx = x;
                posy = y;
                nbM+=1;
                stock.add(indice);
                break;
        }
    }

    public void switchvar(int x, int y, int px, int py) {
            int a, b;
            a = etat[x][y];
            b = etat[px][py];
            etat[x][y] = b;
            etat[px][py] = a;

    }

    @Override
    public int[][] getEtat() {
        return etat;
    }

}
