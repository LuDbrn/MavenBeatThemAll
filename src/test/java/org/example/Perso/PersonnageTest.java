package org.example.Perso;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    @Test
    void subirDegats() {
        Personnage personnage = new Heros(100, 20, 10);
        personnage.subirDegats(15);
        assertEquals(85, personnage.getPv());
    }

    @Test
    void ultimate() {
        Personnage personnage = new Heros(100, 20, 10);
        personnage.ultimate();
        // Add specific assertions depending on the expected behavior of ultimate
    }

    @Test
    void getPv() {
        Personnage personnage = new Heros(100, 20, 10);
        assertEquals(100, personnage.getPv());
    }

    @Test
    void setPv() {
        Personnage personnage = new Heros(100, 20, 10);
        personnage.setPv(120);
        assertEquals(120, personnage.getPv());
    }

    @Test
    void getAttk() {
        Personnage personnage = new Heros(100, 20, 10);
        assertEquals(20, personnage.getAttk());
    }

    @Test
    void getDef() {
        Personnage personnage = new Heros(100, 20, 10);
        assertEquals(10, personnage.getDef());
    }
}