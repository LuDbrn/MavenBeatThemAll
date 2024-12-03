package org.example.Perso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnnemiTest {

    @Test
    void subirDegats() {
        Ennemi ennemi = new Ennemi.Brigand();
        ennemi.subirDegats(20);
        assertEquals(30, ennemi.getPv());  // Brigand has 50 initial PV
    }

    @Test
    void attaquer() {
        Heros heros = new Heros(100, 20, 10);
        Ennemi ennemi = new Ennemi.Brigand();
        ennemi.attaquer(heros);
        assertEquals(90, heros.getPv());  // Assuming brigand attack reduces 10 PV
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
        assertEquals(0, ennemi.getDef());
    }
}