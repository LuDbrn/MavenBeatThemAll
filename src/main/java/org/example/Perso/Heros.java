package org.example.Perso;

public class Heros implements Personnage {
    private int attaque;
    private int defense;
    private int pv;
    private boolean competenceUtilise;

    public Heros(int pv, int attaque, int defense) {
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.competenceUtilise = false;
    }

    @Override
    public void subirDegats(int pointsDegats) {
        this.pv = this.pv-pointsDegats*100/this.defense;
    }

    //Implementation des methodes de Personnage.
    public void attaquer(Personnage cible) {
        cible.subirDegats(this.attaque);
    }

    @Override
    public void ultimate() {
        this.attaque= this.attaque +20;
    }

    @Override
    public int getPv() {
        return pv;
    }

    @Override
    public void setPv() {

    }
    public void heal() {
        if (this.pv+30>100) {
            this.pv = 100;
        } else{
            this.pv+=30;
        }
    }

    @Override
    public int getAttk() {
        return attaque;
    }

    @Override
    public int getDef() {
        return defense;
    }
    public static Heros choixhero(int x){
        if (x==1){
            Heros heros = new Heros(100, 15, 100); // PV, Attaque, Défense
            return heros;
        } else if (x==2){
            Heros heros = new Heros(100, 10, 150); // PV, Attaque, Défense.
            return heros;
        } else if (x==3){
            Heros heros = new Heros(100, 20, 75); // PV, Attaque, Défense
            return heros;
        } else{
            return null;
        }
    }
}
