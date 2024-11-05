/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

public class TestFilm {
    public static void main(String[] args) {
        Film film1 = new Film("Inception", "F001", 5, "Christopher Nolan", 2010);
        System.out.println(film1);

        // Test des méthodes
        film1.setAnnee(2011);
        System.out.println("Après modification de l'année : " + film1.getAnnee());
    }
}
