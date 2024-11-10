package edu.info0502.tp2.poker;

import java.util.ArrayList;
import java.util.List;

public class TableDePoker {
    private Talon talon;
    private List<Joueur> joueurs;
    private List<Carte> cartesCommunes;

    // Constructeur
    public TableDePoker(List<Joueur> joueurs) {
        this.talon = new Talon(1);
        this.joueurs = joueurs;
        this.cartesCommunes = new ArrayList<>();
    }

    // Méthode pour démarrer une partie de Texas Hold'em
    public void demarrerPartie() {
        // Distribuer deux cartes à chaque joueur (cartes cachées)
        for (Joueur joueur : joueurs) {
            List<Carte> mainJoueur = new ArrayList<>();
            mainJoueur.add(talon.tirerCarte());
            mainJoueur.add(talon.tirerCarte());
            joueur.setMain(new MainDePoker(mainJoueur));
        }



        // Flop : distribuer trois cartes communes
        cartesCommunes.add(talon.tirerCarte());
        cartesCommunes.add(talon.tirerCarte());
        cartesCommunes.add(talon.tirerCarte());

        // Turn : une carte commune
        cartesCommunes.add(talon.tirerCarte());

        // River : une carte commune
        cartesCommunes.add(talon.tirerCarte());

        // Afficher les cartes communes
        System.out.println("Cartes communes :");
        for (Carte carte : cartesCommunes) {
            System.out.println(carte);
        }
        System.out.println();

        // Évaluer les mains des joueurs
        for (Joueur joueur : joueurs) {
            // Combiner les cartes du joueur avec les cartes communes
            List<Carte> toutesCartes = new ArrayList<>(joueur.getMain().getCartes());
            toutesCartes.addAll(cartesCommunes);

            // Créer une nouvelle main avec les 7 cartes et évaluer la meilleure combinaison
            joueur.setMain(new MainDePoker(toutesCartes));

            // Afficher la main du joueur
            System.out.println(joueur.getNom() + " : ");
            System.out.println("Cartes personnelles : ");
            for (Carte carte : joueur.getMain().getCartes().subList(0, 2)) {
                System.out.println(carte);
            }
            System.out.println("Meilleure combinaison : " + joueur.getMain().getCombinaison());
            System.out.println();
        }

        // Déterminer le gagnant
        Joueur gagnant = joueurs.get(0);
        for (Joueur joueur : joueurs) {
            if (joueur.getMain().compareTo(gagnant.getMain()) > 0) {
                gagnant = joueur;
            }
        }
        System.out.println("Le gagnant est : " + gagnant.getNom() + " avec une " + gagnant.getMain().getCombinaison());
    }

}
