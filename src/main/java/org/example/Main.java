package org.example;

import org.example.Mapping.Carte;
import org.example.Mapping.MapGen;
import org.example.Perso.Ennemi;
import org.example.Perso.Heros;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lucas.D & Hugo.C");
        System.out.println("Chargement des paramètres de jeu en cours...");

        //Définitions des maps de la partie.
        List<Carte> cartes = MapGen.Defaultmap();
        System.out.println("---------------------");
        //Affichent les maps dispo
        System.out.println("Choisir MAP");
        for (int i = 0; i < cartes.size(); i++) {
            System.out.println((i + 1) + ". " + cartes.get(i).toString());
        }

        System.out.println("---------------------");
        // Sélection de la carte par l'utilisateur
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro de la carte : ");
        int choix = scanner.nextInt();
        Carte map = cartes.get(choix - 1);

        System.out.println("Vous avez choisi : " + map);
        System.out.println("---------------------");
        System.out.println("Préparez-vous à commencer l'aventure !");
        System.out.println("Créez votre Héro!");
        System.out.println("---------------------");
        System.out.println("1. Chevalier");
        System.out.println("2. Berserker");
        System.out.println("3. Voleur");
        System.out.println("---------------------");
        Scanner scanner2 = new Scanner(System.in);
        Heros heros= Heros.choixhero(scanner2.nextInt());
        System.out.println("Votre héros a été créé avec "+heros.getPv()+"PV, " + heros.getAttk()+ " en attaque et "+ heros.getDef() +" en défense.\n");
        // Espace de travail Hugo
        //inventaire
        int potion=3;
        int ulti= 2;
        // ----------
        int i=0;
        int position= map.getDebut();
        Random random=new Random();
        boolean jeu = true;

        while (jeu){
            System.out.println("TOUR "+ i);
            System.out.println(position+" / "+ map.getLongueur());
            System.out.println("QUE VOULEZ-VOUS FAIRE?");
            System.out.println("1. Avancer");
            System.out.println("2. Reculer");
            System.out.println("3. Utiliser Boost");
            System.out.println("4. Utiliser les potions de soin (+30PV)");
            System.out.println("5. Leave la Game");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    position += 10;
                    System.out.println("Tu avances...");
                    if (random.nextBoolean()) {
                        System.out.println("UN ENNEMI !!!");
                        Ennemi Target = null;
                        int choose = random.nextInt(3);

                        if (choose == 0) {
                            Target = new Ennemi.Brigand();
                            System.out.println("Tu croises un Brigand !");
                        } else if (choose == 1) {
                            Target = new Ennemi.Gangster();
                            System.out.println("Tu croises un Gangster !");
                        } else {
                            Target = new Ennemi.Catcheur();
                            System.out.println("Tu croises un Catcheur !");
                        }

                        // Combat
                        if (random.nextBoolean()) {
                            System.out.println("PILE! L'ennemi attaque en premier !");
                            while (Target.getPv() > 0 && heros.getPv() > 0) {
                                System.out.println("L'ennemi attaque...");
                                Target.attaquer(heros);
                                System.out.println("PV Hero " +heros.getPv());
                                if (heros.getPv() >0) {
                                    System.out.println("Tu attaque...");
                                    heros.attaquer(Target);
                                    System.out.println("PV ENNEMI " +Target.getPv());
                                }
                            }
                        }else{
                            System.out.println("FACE! Le Héros attaque en premier !");
                            while (Target.getPv() > 0 && heros.getPv() > 0) {
                                heros.attaquer(Target);
                                System.out.println("Tu attaque...");
                                System.out.println("PV Enemmi " +Target.getPv());
                                if (Target.getPv() >0) {
                                    System.out.println("L'ennemi attaque...");
                                    Target.attaquer(heros);
                                    System.out.println("PV Hero "+heros.getPv());
                                    System.out.println(heros.getPv());
                                }
                            }
                        }
                        // Check les pv
                            System.out.println("PV Héros: " + heros.getPv() + " | PV Ennemi: " + Target.getPv());

                        if (heros.getPv() <= 0) {
                            System.out.println("Tu as été vaincu !");
                            jeu = false;
                            break;
                        } else {
                            System.out.println("Tu as vaincu l'ennemi !");
                        }
                    }
                    break;
                case 2:
                    position -= 10;
                    System.out.println("Tu recules...");
                case 3:
                    if (ulti!=0) {
                        heros.ultimate();
                        System.out.println("Tu utilise ton boost...");
                        ulti-=1;
                        System.out.println("Boost "+ ulti + " / "+ "2");
                    } else {
                        System.out.println("Tu n'en a plus en stock...");
                    }
                    break;

                case 4:
                    if (potion!=0){
                        System.out.println("Vous utilisez une potion de vie !!! ");
                        System.out.println("Vous passez de " + heros.getPv() + " PV");
                        heros.heal();
                        System.out.println("à " + heros.getPv()+ " PV");
                        potion-=1;
                        System.out.println("Potion "+ potion +" / "+ "3");
                    }else {
                        System.out.println("Tu n'as plus de potion..");

                    }
                    break;
                case 5:
                    System.out.println("Vous quittez le jeu. À bientôt !");
                    jeu = false;
                    break;

                default:
                    System.out.println("Action non reconnue.");
                    break;
            }
         i+=1;
        }






//        //
//        // Esapce travail Lucas
//        // Test Heros
//        System.out.println(" Test Class Heros");
//        Heros heros = new Heros(100, 25, 10);
//        System.out.println("PV du héros initial : " + heros.getPv()); // Attendu : 100
//        System.out.println("PTAttaque du héros initial : " + heros.getAttk()); // Attendu : 25
//        heros.subirDegats(15); // 100 - 15 = 85 pv
//        System.out.println("PV du héros après dégâts : " + heros.getPv()); // Attendu : 90
//        heros.ultimate(); // test du lancement competence utlimate, rien ne se passe pour le moment
//
//        // Test Brigand
//        System.out.println("\nTest Class Brigand");
//        Ennemi.Brigand brigand = new Ennemi.Brigand();
//        System.out.println("PV initial du brigand initial : " + brigand.getPv()); // Attendu : 50
//        System.out.println("PTAttaque initial du brigand : " + brigand.getAttk()); // Attendu : 10
//        System.out.println("Defense initial du  : " + brigand.getDef()); // Attendu : 0
//        brigand.subirDegats(50);
//        System.out.println("PV du héros après dégâts : " + brigand.getPv()); // Attendu : 0
//
//        // Test Catcheur
//        System.out.println("\nTest Catcheur");
//        Ennemi.Catcheur catcheur = new Ennemi.Catcheur();
//        System.out.println("PV du catcheur initial : " + catcheur.getPv()); // Attendu : 100
//        System.out.println("Attaque du catcheur : " + catcheur.getAttk()); // Attendu : 5
//        System.out.println("PV du catcheur après dégâts : " + catcheur.getDef()); // Attendu : 70
//        catcheur.subirDegats(50);
//        System.out.println("PV du héros après dégâts : " + catcheur.getPv()); // Attendu : 90
//
//        // Test Gangster
//        System.out.println("\nTest Gangster");
//        Ennemi.Gangster gangster = new Ennemi.Gangster();
//        System.out.println("PV du catcheur initial : " + gangster.getPv()); // Attendu : 40
//        System.out.println("Attaque du catcheur : " + gangster.getAttk()); // Attendu : 15
//        System.out.println("PV du catcheur après dégâts : " + gangster.getDef()); // Attendu : 40
//        gangster.subirDegats(50);
//        System.out.println("PV du héros après dégâts : " + gangster.getPv()); // Attendu : 0
//

    }
}