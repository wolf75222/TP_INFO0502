package edu.info0502.tp2.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue au jeu de Poker !");
        System.out.println("Veuillez choisir le type de jeu :");
        System.out.println("1 - Poker standard");
        System.out.println("2 - Texas Hold'em");
        System.out.print("Votre choix : ");

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                jouerPokerStandard();
                break;
            case 2:
                jouerTexasHoldem();
                break;
            default:
                System.out.println("Choix invalide. Veuillez relancer le programme et choisir 1 ou 2.");
                break;
        }

        scanner.close();
    }

    // Méthode pour jouer une partie de poker standard
    private static void jouerPokerStandard() {
        // Créer un talon (paquet de cartes mélangé)
        Talon talon = new Talon(1);

        // Créer des joueurs
        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add(new Joueur("Alice"));
        joueurs.add(new Joueur("Bob"));
        joueurs.add(new Joueur("Charlie"));
        joueurs.add(new Joueur("David"));

        // Distribuer les cartes aux joueurs
        for (Joueur joueur : joueurs) {
            List<Carte> cartesMain = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Carte carte = talon.tirerCarte();
                if (carte != null) {
                    cartesMain.add(carte);
                }
            }
            joueur.setMain(new MainDePoker(cartesMain));
        }

        // Afficher les mains des joueurs
        for (Joueur joueur : joueurs) {
            System.out.println(joueur.getNom() + " : " + joueur.getMain());
        }

        // Déterminer le gagnant
        Joueur gagnant = joueurs.get(0);
        for (Joueur joueur : joueurs) {
            if (joueur.getMain().compareTo(gagnant.getMain()) > 0) {
                gagnant = joueur;
            }
        }
        System.out.println("Le gagnant est : " + gagnant.getNom());
    }

    // Méthode pour jouer une partie de Texas Hold'em
    private static void jouerTexasHoldem() {
        // Créer des joueurs
        List<Joueur> joueurs = new ArrayList<>();
        joueurs.add(new Joueur("Alice"));
        joueurs.add(new Joueur("Bob"));
        joueurs.add(new Joueur("Charlie"));
        joueurs.add(new Joueur("David"));

        // Créer une table de poker
        TableDePoker table = new TableDePoker(joueurs);

        // Démarrer une partie de Texas Hold'em
        table.demarrerPartie();
    }
}
