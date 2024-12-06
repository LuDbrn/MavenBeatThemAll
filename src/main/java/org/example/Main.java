package org.example;

import org.example.Mapping.Carte;
import org.example.Mapping.MapGen;
import org.example.Perso.Ennemi;
import org.example.Perso.Heros;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lucas.D & Hugo.C");

        //Définitions des maps de la partie.
        List<Carte> cartes = MapGen.Defaultmap();
        System.out.println("---------------------");
        //Affiche les maps dispo
        System.out.println("Choisir MAP");
        for (int i = 0; i < cartes.size(); i++) {
            System.out.println((i + 1) + ". " + cartes.get(i).toString());
        }
        System.out.print("4. "+"| CUSTOM"+"\r\n");
        System.out.println("---------------------");


        // Sélection de la carte par l'utilisateur
        Scanner scanner = new Scanner(System.in);
        Carte map;
        System.out.print("Faites votre choix: ");
        int choix = scanner.nextInt();
        if (choix == 4){
            map= MapGen.MakePersoMap();
        }
        else {
            map = cartes.get(choix - 1);
        }
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

        // Inventaire
        int potion=3;
        int ulti= 2;
        // Variables de Jeu
        int i=0;
        int position= map.getDebut();
        Random random=new Random();
        boolean jeu = true;
        // Jeu
        int confirm=0;
        while(confirm !=1){
            System.out.println("Commencer la partie");
            System.out.println("1. Oui");
            System.out.println("2. Attendre");
            Scanner confirmer = new Scanner(System.in);
            confirm= Integer.parseInt(confirmer.next());
        }
        while (jeu){
            System.out.println("TOUR "+ i);
            System.out.println(position+" / "+ map.getLongueur());
            System.out.println("QUE VOULEZ-VOUS FAIRE?");
            System.out.println("1. Avancer");
            System.out.println("2. Reculer");
            System.out.println("3. Utiliser Boost");
            if (heros.getPv()<30){
                System.out.println("4. Utiliser les potions de soin (+30PV) (recommandé)");
            }else{System.out.println("4. Utiliser les potions de soin (+30PV)");}

            System.out.println("5. Looter");
            System.out.println("6. Leave la Game");

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
                                Target.attaquer(heros);
                                if (heros.getPv() >0) {
                                    heros.attaquer(Target);
                                    System.out.println("HERO | ENNEMI");
                                    System.out.println(heros.getPv()+"   |   "+ Target.getPv());
                                }
                            }
                        }else{
                            System.out.println("FACE! Le Héros attaque en premier !");
                            while (Target.getPv() > 0 && heros.getPv() > 0) {
                                heros.attaquer(Target);
                                if (Target.getPv() >0) {
                                    Target.attaquer(heros);
                                    System.out.println("HERO | ENNEMI");
                                    System.out.println(heros.getPv()+"   |   "+ Target.getPv());
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
                    System.out.println("Vous fouillez les environs");
                    potion+=random.nextInt(0,2);
                    break;

                case 6:
                    System.out.println("Vous quittez le jeu. À bientôt !");
                    jeu = false;
                    break;

                default:
                    System.out.println("Action non reconnue.");
                    break;

            }
            i+=1;
        }
    }
}