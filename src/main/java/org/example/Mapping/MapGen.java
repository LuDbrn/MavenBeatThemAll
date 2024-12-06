package org.example.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapGen {

    // Méthode pour créer une liste de cartes prédéfinies
    public static List<Carte> Defaultmap() {
        List<Carte> cartes = new ArrayList<>();

        // Ajouter des cartes prédéfinies
        cartes.add(new Carte("Cantine du Crous ", "Restaurant", 0, 250, 250));
        cartes.add(new Carte("Bureau de M.Temperville ", "Urbain", 0, 150, 150));
        cartes.add(new Carte("L'Internet ", "Google DC ", 0, 100, 100));

        return cartes;
    }

    // Méthode pour une carte personnalisée
    public static Carte MakePersoMap() {
        System.out.println("Nom de la map : ");
        Scanner name = new Scanner(System.in);
        String nom= name.nextLine();
        System.out.println("Type de la map : ");
        Scanner location = new Scanner(System.in);
        String lieu= location.next();
        System.out.println("Durée de la map : ");
        Scanner finfin = new Scanner(System.in);
        int fin= Integer.parseInt(finfin.next());
        return new Carte(nom, lieu, 0,fin , fin);
    }
}
