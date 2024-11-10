package edu.info0502.tp1;

public class Livre extends Media {
    // Attributs d'instance privés
    private String auteur;
    private String isbn;

    // Constructeur par défaut
    public Livre() {
        super();
        this.auteur = "";
        this.isbn = "";
    }

    // Constructeur par initialisation
    public Livre(String titre, String cote, int note, String auteur, String isbn) {
        super(titre, cote, note);
        this.auteur = auteur;
        this.isbn = isbn;
    }

    // Constructeur par copie
    public Livre(Livre other) {
        super(other);
        this.auteur = other.auteur;
        this.isbn = other.isbn;
    }

    // Getters et Setters
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Redéfinition de clone()
    @Override
    public Livre clone() {
        return new Livre(this);
    }

    // Redéfinition de equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Livre) {
            Livre other = (Livre) obj;
            return super.equals(other) && this.auteur.equals(other.auteur) && this.isbn.equals(other.isbn);
        }
        return false;
    }

    // Redéfinition de toString()
    @Override
    public String toString() {
        return "Livre [Titre=" + getTitre() + ", Cote=" + getCote() + ", Note=" + getNote() + ", Auteur=" + auteur
                + ", ISBN=" + isbn + "]";
    }
}
