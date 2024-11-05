/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

public class Livre extends Media {

    // Variables d'instance privées
    private String auteur;   // Auteur du livre
    private String isbn;     // ISBN du livre

    /**
     * Constructeur par défaut.
     */
    public Livre() {
        super();
        this.auteur = "";
        this.isbn = "";
    }

    /**
     * Constructeur par initialisation.
     * @param titre Le titre du livre.
     * @param cote La cote du livre.
     * @param note La note attribuée au livre.
     * @param auteur L'auteur du livre.
     * @param isbn Le numéro ISBN du livre.
     */
    public Livre(String titre, String cote, int note, String auteur, String isbn) {
        super(titre, cote, note);
        this.auteur = auteur;
        this.isbn = isbn;
    }

    /**
     * Constructeur par copie.
     * @param l L'objet Livre à copier.
     */
    public Livre(Livre l) {
        super(l);
        this.auteur = l.auteur;
        this.isbn = l.isbn;
    }

    // Getters et setters pour les variables d'instance

    /**
     * Obtient l'auteur du livre.
     * @return L'auteur.
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Définit l'auteur du livre.
     * @param auteur L'auteur à définir.
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    /**
     * Obtient le numéro ISBN du livre.
     * @return Le numéro ISBN.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Définit le numéro ISBN du livre.
     * @param isbn Le numéro ISBN à définir.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Méthodes redéfinies

    /**
     * Retourne une représentation sous forme de chaîne du livre.
     * @return Une chaîne contenant les informations du livre.
     */
    @Override
    public String toString() {
        return "Livre [titre=" + getTitre() + ", cote=" + getCote() + ", note=" + getNote() +
               ", auteur=" + auteur + ", isbn=" + isbn + "]";
    }

    /**
     * Vérifie si ce livre est égal à un autre objet.
     * @param obj L'objet à comparer.
     * @return Vrai si égal, faux sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (obj instanceof Livre) {
            Livre other = (Livre) obj;
            return this.auteur.equals(other.auteur) && this.isbn.equals(other.isbn);
        }
        return false;
    }

    /**
     * Crée et retourne une copie de ce livre.
     * @return Un clone de ce livre.
     */
    @Override
    protected Object clone() {
        return new Livre(this);
    }
}
