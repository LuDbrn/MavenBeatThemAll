package org.example.Perso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnnemiTest {

    @Test
    void subirDegats() {
        Ennemi ennemi = new Ennemi.Brigand();
        ennemi.subirDegats(20);
        assertEquals(40, ennemi.getPv());
    }

    @Test
    void attaquer() {
        Heros heros = new Heros(100, 20, 10);
        Ennemi ennemi = new Ennemi.Brigand();
        ennemi.attaquer(heros);
        assertEquals(91, heros.getPv());  // Réduction de 10% des dégats subit par le hero, donc le Brig fait 10 de dmg - 10% donc 9dmg
    }

    @Test
    void getPv() {
        Ennemi ennemi = new Ennemi.Brigand();
        assertEquals(50, ennemi.getPv());
    }

    @Test
    void setPv() {
        Ennemi ennemi = new Ennemi.Brigand();
        ennemi.setPv(60);
        assertEquals(60, ennemi.getPv());
    }

    @Test
    void getAttk() {
        Ennemi ennemi = new Ennemi.Brigand();
        assertEquals(10, ennemi.getAttk());
    }

    @Test
    void getDef() {
        Ennemi ennemi = new Ennemi.Brigand();
        assertEquals(50, ennemi.getDef());  // Défense de Brigand est 10
    }
}