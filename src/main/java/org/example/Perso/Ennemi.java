package org.example.Perso;

public class Ennemi implements Personnage {
  //accessible aux classes dans le même paquetage et à toute classe dérivée en dehors du paquetage
    protected int pv;  //
    protected int attk;
    protected int def;
//Constructor
    public Ennemi(int pv, int attaque, int def) {
        this.pv = pv;
        this.attk = attaque;
        this.def = def;
    }

    @Override
    public void subirDegats(int pointsDegats) {
        int degatsSubis = pointsDegats * (100 - this.def) / 100; // Défense en pourcentage
        this.pv = Math.max(this.pv - degatsSubis, 0); // Réduction des PV, minimum 0
    }

    public void attaquer(Personnage cible) {
        cible.subirDegats(this.attk);
    }

    @Override
    public void ultimate() {

    }

    @Override
    public int getPv() {
        return pv;
    }

    @Override
    public void setPv(int pv) {
        this.pv = pv; // Met à jour les points de vie
    }

    @Override
    public int getAttk() {
        return attk;
    }

    @Override
    public int getDef() {
        return def;
    }

    public static class Brigand extends Ennemi {
        public Brigand() {
            super(50, 5,5); //super () appele un constructeur ou une méthode de sa classe parente
        }
    }

    public static class Catcheur extends Ennemi {
        public Catcheur() {
            super(100, 5,0); // Pleins de PV
        }
    }

    public static class Gangster extends Ennemi {
        public Gangster() {
            super(40, 10,5); // Attaque de loin
        }
}
}
