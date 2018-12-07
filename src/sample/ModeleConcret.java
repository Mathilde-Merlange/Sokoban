package sample;

public class ModeleConcret implements Modele {



   /* Correspondance entier élément:
   * 0 : mur (#)
   * 1 : caisse ($)
   * 2 : destination (.)
   * 3 : caisse sur une zone de rangement (*)
   * 4 : personnage sur une zone de rangement (+)
   * 5 : sol ( )
   * 6 : soko (@)
    */
    public int[][] etat = {{0,1,2,3},{4,5,6,7}};
    int posx; // abscisse soko
    int posy; // ordonnée soko


    public void move(int indice) {
    }

    @Override
    public int[][] getEtat() {
        return etat;
    }

}
