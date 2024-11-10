package edu.info0502.tp1;

public class Media implements Cloneable {
    // Attributs d'instance privés
    private String titre;
    private StringBuffer cote;
    private int note;

    // Attribut de classe privé
    private static String nomMediatheque = "Médiathèque par défaut";

    // Constructeur par défaut
    public Media() {
        this.titre = "";
        this.cote = new StringBuffer();
        this.note = 0;
    }

    // Constructeur par initialisation
    public Media(String titre, String cote, int note) {
        this.titre = titre;
        this.cote = new StringBuffer(cote);
        this.note = note;
    }

    // Constructeur par copie
    public Media(Media other) {
        this.titre = other.titre;
        this.cote = new StringBuffer(other.cote);
        this.note = other.note;
    }

    // Getters et Setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public StringBuffer getCote() {
        return new StringBuffer(this.cote);
    }

    public void setCote(String cote) {
        this.cote = new StringBuffer(cote);
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    // Méthodes de classe
    public static String getNomMediatheque() {
        return nomMediatheque;
    }

    public static void setNomMediatheque(String nom) {
        nomMediatheque = nom;
    }

    // Redéfinition de clone()
    @Override
    public Media clone() {
        return new Media(this);
    }

    // Redéfinition de equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Media) {
            Media other = (Media) obj;
            return this.titre.equals(other.titre) && this.cote.toString().equals(other.cote.toString())
                    && this.note == other.note;
        }
        return false;
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        return "Media [Titre=" + titre + ", Cote=" + cote + ", Note=" + note + "]";
    }
}
