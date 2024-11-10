package edu.info0502.tp1;

public class Film extends Media {
    // Attributs d'instance privés
    private String realisateur;
    private int annee;

    // Constructeur par défaut
    public Film() {
        super();
        this.realisateur = "";
        this.annee = 0;
    }

    // Constructeur par initialisation
    public Film(String titre, String cote, int note, String realisateur, int annee) {
        super(titre, cote, note);
        this.realisateur = realisateur;
        this.annee = annee;
    }

    // Constructeur par copie
    public Film(Film other) {
        super(other);
        this.realisateur = other.realisateur;
        this.annee = other.annee;
    }

    // Getters et Setters
    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // Redéfinition de clone()
    @Override
    public Film clone() {
        return new Film(this);
    }

    // Redéfinition de equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Film) {
            Film other = (Film) obj;
            return super.equals(other) && this.realisateur.equals(other.realisateur) && this.annee == other.annee;
        }
        return false;
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        return "Film [Titre=" + getTitre() + ", Cote=" + getCote() + ", Note=" + getNote() + ", Réalisateur="
                + realisateur + ", Année=" + annee + "]";
    }
}
