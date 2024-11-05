/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

public class TestMediatheque {
    public static void main(String[] args) {
        Mediatheque mediatheque = new Mediatheque();
        mediatheque.setProprietaire("Jean Dupont");

        Livre livre = new Livre("1984", "L002", 4, "George Orwell", "978-0451524935");
        Film film = new Film("The Matrix", "F002", 5, "The Wachowskis", 1999);

        mediatheque.add(livre);
        mediatheque.add(film);

        System.out.println(mediatheque);
    }
}
