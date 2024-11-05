/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

public class Media {

    // Variable de classe (privée)
    private static String nom;

    // Variables d'instance (privées)
    private String titre;          // Titre du média
    private StringBuffer cote;     // Cote du média
    private int note;              // Note attribuée au média

    /**
     * Constructeur par défaut.
     * Initialise les variables d'instance avec des valeurs par défaut.
     */
    public Media() {
        this.titre = "";
        this.cote = new StringBuffer();
        this.note = 0;
    }

    /**
     * Constructeur par initialisation.
     * @param titre Le titre du média.
     * @param cote La cote du média.
     * @param note La note attribuée au média.
     */
    public Media(String titre, String cote, int note) {
        this.titre = titre;
        this.cote = new StringBuffer(cote);
        this.note = note;
    }

    /**
     * Constructeur par copie.
     * @param m L'objet Media à copier.
     */
    public Media(Media m) {
        this.titre = m.titre;
        this.cote = new StringBuffer(m.cote);
        this.note = m.note;
    }

    // Getters et setters pour les variables d'instance

    /**
     * Obtient le titre du média.
     * @return Le titre.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Définit le titre du média.
     * @param titre Le titre à définir.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Obtient une copie de la cote du média.
     * Retourne un nouveau StringBuffer pour éviter la modification externe.
     * @return Une copie de la cote.
     */
    public StringBuffer getCote() {
        return new StringBuffer(this.cote);
    }

    /**
     * Définit la cote du média.
     * @param cote La cote à définir.
     */
    public void setCote(String cote) {
        this.cote = new StringBuffer(cote);
    }

    /**
     * Obtient la note du média.
     * @return La note.
     */
    public int getNote() {
        return note;
    }

    /**
     * Définit la note du média.
     * @param note La note à définir.
     */
    public void setNote(int note) {
        this.note = note;
    }

    // Méthodes de classe pour obtenir et modifier 'nom'

    /**
     * Obtient le nom de la médiathèque.
     * @return Le nom de la médiathèque.
     */
    public static String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la médiathèque.
     * @param nom Le nom à définir.
     */
    public static void setNom(String nom) {
        Media.nom = nom;
    }

    // Méthodes redéfinies

    /**
     * Retourne une représentation sous forme de chaîne du média.
     * @return Une chaîne contenant le titre, la cote et la note.
     */
    @Override
    public String toString() {
        return "Media [titre=" + titre + ", cote=" + cote + ", note=" + note + "]";
    }

    /**
     * Vérifie si ce média est égal à un autre objet.
     * @param obj L'objet à comparer.
     * @return Vrai si égal, faux sinon.
     */
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

    /**
     * Crée et retourne une copie de ce média.
     * @return Un clone de ce média.
     */
    @Override
    protected Object clone() {
        return new Media(this);
    }
}
