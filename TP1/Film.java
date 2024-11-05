/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

public class Film extends Media {

    // Variables d'instance privées
    private String realisateur;   // Réalisateur du film
    private int annee;            // Année de sortie du film

    /**
     * Constructeur par défaut.
     */
    public Film() {
        super();
        this.realisateur = "";
        this.annee = 0;
    }

    /**
     * Constructeur par initialisation.
     * @param titre Le titre du film.
     * @param cote La cote du film.
     * @param note La note attribuée au film.
     * @param realisateur Le réalisateur du film.
     * @param annee L'année de sortie du film.
     */
    public Film(String titre, String cote, int note, String realisateur, int annee) {
        super(titre, cote, note);
        this.realisateur = realisateur;
        this.annee = annee;
    }

    /**
     * Constructeur par copie.
     * @param f L'objet Film à copier.
     */
    public Film(Film f) {
        super(f);
        this.realisateur = f.realisateur;
        this.annee = f.annee;
    }

    // Getters et setters pour les variables d'instance

    /**
     * Obtient le réalisateur du film.
     * @return Le réalisateur.
     */
    public String getRealisateur() {
        return realisateur;
    }

    /**
     * Définit le réalisateur du film.
     * @param realisateur Le réalisateur à définir.
     */
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    /**
     * Obtient l'année de sortie du film.
     * @return L'année de sortie.
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Définit l'année de sortie du film.
     * @param annee L'année à définir.
     */
    public void setAnnee(int annee) {
        this.annee = annee;
    }

    // Méthodes redéfinies

    /**
     * Retourne une représentation sous forme de chaîne du film.
     * @return Une chaîne contenant les informations du film.
     */
    @Override
    public String toString() {
        return "Film [titre=" + getTitre() + ", cote=" + getCote() + ", note=" + getNote() +
               ", realisateur=" + realisateur + ", annee=" + annee + "]";
    }

    /**
     * Vérifie si ce film est égal à un autre objet.
     * @param obj L'objet à comparer.
     * @return Vrai si égal, faux sinon.
     */
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        if (obj instanceof Film) {
            Film other = (Film) obj;
            return this.realisateur.equals(other.realisateur) && this.annee == other.annee;
        }
        return false;
    }

    /**
     * Crée et retourne une copie de ce film.
     * @return Un clone de ce film.
     */
    @Override
    protected Object clone() {
        return new Film(this);
    }
}
