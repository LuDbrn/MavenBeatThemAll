package org.example.Mapping;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void getNom() {
        Carte carte = new Carte("Forêt", "pont de bois", 0,250,250);
        assertEquals("Forêt", carte.getNom());
    }

    @Test
    void setNom() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setNom("Désert");
        assertEquals("Désert", carte.getNom());
    }

    @Test
    void getLieu() {
        Carte carte = new Carte("Forêt", 100, 0);
        assertEquals("Forêt", carte.getLieu());
    }

    @Test
    void setLieu() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setLieu("Jungle");
        assertEquals("Jungle", carte.getLieu());
    }

    @Test
    void getDebut() {
        Carte carte = new Carte("Forêt", 100, 0);
        assertEquals(0, carte.getDebut());
    }

    @Test
    void setDebut() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setDebut(10);
        assertEquals(10, carte.getDebut());
    }

    @Test
    void getFin() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setFin(200);
        assertEquals(200, carte.getFin());
    }

    @Test
    void setFin() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setFin(300);
        assertEquals(300, carte.getFin());
    }

    @Test
    void getLongueur() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setLongueur(100);
        assertEquals(100, carte.getLongueur());
    }

    @Test
    void setLongueur() {
        Carte carte = new Carte("Forêt", 100, 0);
        carte.setLongueur(200);
        assertEquals(200, carte.getLongueur());
    }

    @Test
    void testToString() {
        Carte carte = new Carte("L'IMT", "Cours d'électronique", 0, 250, 250);
        assertEquals("| Nom = L'IMT -  Type = Cours d'électronique -  Longueur = 250", carte.toString());
    }
}
