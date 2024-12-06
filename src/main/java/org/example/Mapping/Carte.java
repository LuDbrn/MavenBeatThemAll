package org.example.Mapping;

public class Carte {
    private String nom;
    private String lieu;
    private int debut;
    private int fin;
    private int longueur;
    public Carte(String nom, String lieu, int debut, int fin, int longueur) {
        this.nom = nom;
        this.lieu = lieu;
        this.debut = debut;
        this.fin = fin;
        this.longueur = longueur;
    }

    public Carte(String lieu, int debut, int longueur) {
        this.lieu = lieu;
        this.debut = debut;
        this.longueur = longueur;
        // Initialize other fields if necessary, or set default values
        // Default value for lieu
        this.fin = 0;   // Default value for fin
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getDebut() {
        return debut;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
    @Override
    public String toString() {
        return  "| Nom = " + nom +" - "+" Type = " + lieu + " - " +" Longueur = " + longueur;
    }
}