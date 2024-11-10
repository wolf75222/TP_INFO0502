package edu.info0502.tp2.poker;

public class Talon extends Paquet {
    // Constructeur : permet de créer un talon avec plusieurs paquets
    public Talon(int nombreDePaquets) {
        cartes.clear();
        for (int i = 0; i < nombreDePaquets; i++) {
            Paquet paquet = new Paquet();
            cartes.addAll(paquet.cartes);
        }
        melanger();
    }
}
