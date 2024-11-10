package edu.info0502.tp2.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paquet {
    protected List<Carte> cartes;

    // Constructeur par défaut : crée un paquet standard de 52 cartes
    public Paquet() {
        cartes = new ArrayList<>();
        for (Carte.Couleur couleur : Carte.Couleur.values()) {
            for (Carte.Valeur valeur : Carte.Valeur.values()) {
                cartes.add(new Carte(couleur, valeur));
            }
        }
    }

    // Méthode pour mélanger le paquet
    public void melanger() {
        Collections.shuffle(cartes);
    }

    // Méthode pour tirer une carte du dessus du paquet
    public Carte tirerCarte() {
        if (!cartes.isEmpty()) {
            return cartes.remove(0);
        } else {
            return null;
        }
    }

    // Méthode pour afficher le paquet
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Carte carte : cartes) {
            sb.append(carte.toString()).append("\n");
        }
        return sb.toString();
    }

    // Getter pour le nombre de cartes restantes
    public int getNombreDeCartes() {
        return cartes.size();
    }
}
