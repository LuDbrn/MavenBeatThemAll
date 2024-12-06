package org.example.Perso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerosTest {

    @Test
    void heal() {
        Heros heros = new Heros(100, 20, 10);
        heros.subirDegats(30);
        heros.heal();
        assertEquals(100, heros.getPv());
    }

    @Test
    void choixhero() {
        Heros heros = Heros.choixhero(1);  // Assuming 1 is Chevalier
        assertNotNull(heros);
        assertEquals(100, heros.getPv());
    }

    @Test
    void subirDegats() {
        Heros heros = new Heros(100, 20, 10);
        heros.subirDegats(20);
        assertEquals(82, heros.getPv());
    }

    @Test
    void attaquer() {
        Heros heros = new Heros(100, 20, 10);
        Ennemi ennemi = new Ennemi.Brigand();
        heros.attaquer(ennemi);
        assertEquals(40, ennemi.getPv());
    }

    @Test
    void getPv() {
        Heros heros = new Heros(100, 20, 10);
        assertEquals(100, heros.getPv());
    }

    @Test
    void setPv() {
        Heros heros = new Heros(100, 20, 10);
        heros.setPv(120);
        assertEquals(120, heros.getPv());
    }

    @Test
    void getAttk() {
        Heros heros = new Heros(100, 20, 10);
        assertEquals(20, heros.getAttk());
    }

    @Test
    void getDef() {
        Heros heros = new Heros(100, 20, 10);
        assertEquals(10, heros.getDef());
    }
}