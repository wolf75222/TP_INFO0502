package edu.info0502.tp2.poker;

public class Carte implements Comparable<Carte> {
    // Enums pour les couleurs et les valeurs
    public enum Couleur {
        COEUR, CARREAU, TREFLE, PIQUE
    }

    public enum Valeur {
        DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7),
        HUIT(8), NEUF(9), DIX(10), VALET(11), DAME(12), ROI(13), AS(14);

        private final int valeur;

        Valeur(int valeur) {
            this.valeur = valeur;
        }

        public int getValeur() {
            return valeur;
        }
    }

    // Attributs
    private final Couleur couleur;
    private final Valeur valeur;

    // Constructeur
    public Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    // Getters
    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }

    // Méthodes héritées
    @Override
    public String toString() {
        return valeur + " de " + couleur;
    }

    @Override
    public int compareTo(Carte autre) {
        return Integer.compare(this.valeur.getValeur(), autre.valeur.getValeur());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Carte) {
            Carte autre = (Carte) obj;
            return this.valeur == autre.valeur && this.couleur == autre.couleur;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return valeur.hashCode() + couleur.hashCode() * 31;
    }
}
