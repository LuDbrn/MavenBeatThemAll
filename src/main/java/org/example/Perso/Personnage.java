package org.example.Perso;

public interface Personnage
{
    int pv = 0;
    int attk =0;
    int def = 0;

    //
    void subirDegats(int pointsDegats);

    //Cette classe Serviera de base pour le PP et les méchants//


    // Doit être utilisé qu'une fois//
    void ultimate();

    //Getter et Setter pour PV
    int getPv();
    void setPv();

    //Getters pour Def et Attk
    int getAttk();
    int getDef();
}
