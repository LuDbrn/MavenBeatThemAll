package org.example.Mapping;

import java.util.ArrayList;
import java.util.List;

public class MapGen {

    // Méthode pour créer une liste de cartes prédéfinies
    public static List<Carte> Defaultmap() {
        List<Carte> cartes = new ArrayList<>();

        // Ajouter des cartes prédéfinies
        cartes.add(new Carte("L'IMT ", "Cours d'électronique", 0, 250, 250));
        cartes.add(new Carte("Egypte ", "Désert", 0, 150, 150));
        cartes.add(new Carte("L'Internet ", "Google DC ", 0, 100, 100));

        return cartes;
    }

    // Méthode pour une carte personnalisée
    public static Carte MakePersoMap(String nom, String lieu, int longueur) {
        return new Carte(nom, lieu, 0, longueur, longueur);
    }
}
