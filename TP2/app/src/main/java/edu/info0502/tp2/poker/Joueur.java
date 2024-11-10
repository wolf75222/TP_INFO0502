package edu.info0502.tp2.poker;

public class Joueur {
    private String nom;
    private MainDePoker main;

    // Constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour la main
    public MainDePoker getMain() {
        return main;
    }

    public void setMain(MainDePoker main) {
        this.main = main;
    }

    // Getter pour le nom
    public String getNom() {
        return nom;
    }
}
