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
    public int[][] etat = { {3,3,3,3,3},{3,4,4,4,3},{3,4,5,4,3},{3,4,4,4,3},{3,3,3,3,3} };
    int posx = 2; // abscisse soko
    int posy = 2; // ordonnée soko


    public void move(int indice) {
        int x,y;
        switch(indice){
            case 2:
                x=posx;
                y=posy+1;
                echanger(x,y,posx,posy);
                posx=x;
                posy=y;
                break;
            case 4:
                x=posx-1;
                y=posy;
                echanger(x,y,posx,posy);
                posx=x;
                posy=y;
                break;
            case 6:
                x=posx+1;
                y=posy;
                echanger(x,y,posx,posy);
                posx=x;
                posy=y;
                break;
            case 8:
                x=posx;
                y=posy-1;
                echanger(x,y,posx,posy);
                posx=x;
                posy=y;
                break;
        }
    }

    public void echanger(int x,int y,int px,int py){
        int a,b;
        a=etat[x][y];
        b=etat[px][py];
        etat[x][y]=b;
        etat[px][py]=a;
    }

    @Override
    public int[][] getEtat() {
        return etat;
    }

}
