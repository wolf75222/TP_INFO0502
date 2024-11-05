/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

import java.util.Vector;

public class Mediatheque {

    // Variables d'instance privées
    private String proprietaire;       // Nom du propriétaire
    private Vector<Media> medias;      // Collection de médias

    /**
     * Constructeur par défaut.
     */
    public Mediatheque() {
        this.proprietaire = "";
        this.medias = new Vector<Media>();
    }

    /**
     * Constructeur par copie.
     * @param m La médiathèque à copier.
     */
    public Mediatheque(Mediatheque m) {
        this.proprietaire = m.proprietaire;
        this.medias = new Vector<Media>(m.medias);
    }

    /**
     * Obtient le nom du propriétaire.
     * @return Le nom du propriétaire.
     */
    public String getProprietaire() {
        return proprietaire;
    }

    /**
     * Définit le nom du propriétaire.
     * @param proprietaire Le nom à définir.
     */
    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    /**
     * Ajoute un média à la médiathèque.
     * @param media Le média à ajouter.
     */
    public void add(Media media) {
        medias.add(media);
    }

    /**
     * Retourne une représentation sous forme de chaîne de la médiathèque.
     * @return Une chaîne représentant la médiathèque.
     */
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
