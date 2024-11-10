package edu.info0502.tp1;

import java.util.Vector;

public class Mediatheque {
    // Attributs d'instance
    private String proprietaire;
    private Vector<Media> medias;

    // Constructeur par défaut
    public Mediatheque() {
        this.proprietaire = "";
        this.medias = new Vector<>();
    }

    // Constructeur par copie
    public Mediatheque(Mediatheque other) {
        this.proprietaire = other.proprietaire;
        this.medias = new Vector<>(other.medias);
    }

    // Getters et Setters
    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Vector<Media> getMedias() {
        return medias;
    }

    // Méthode pour ajouter un média
    public void add(Media media) {
        this.medias.add(media);
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Médiathèque de ").append(proprietaire).append(" :\n");
        for (Media media : medias) {
            sb.append(media.toString()).append("\n");
        }
        return sb.toString();
    }
}
