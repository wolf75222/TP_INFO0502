package edu.info0502.tp1;

public class Main {
    public static void main(String[] args) {
        // Définir le nom de la médiathèque
        Media.setNomMediatheque("Médiathèque Universitaire");

        // Créer des médias
        Livre livre = new Livre("Le Petit Prince", "LP123", 5, "Antoine de Saint-Exupéry", "978-0156012195");
        Film film = new Film("Inception", "IN456", 5, "Christopher Nolan", 2010);

        // Créer une médiathèque
        Mediatheque mediatheque = new Mediatheque();
        mediatheque.setProprietaire("Alice");

        // Ajouter des médias à la médiathèque
        mediatheque.add(livre);
        mediatheque.add(film);

        // Afficher le contenu de la médiathèque
        System.out.println(mediatheque);

        // Exemples supplémentaires
        System.out.println("Nom de la médiathèque : " + Media.getNomMediatheque());

        // Test des méthodes de Media
        Media m1 = new Livre("Le livre de la jungle", "DFTY4HG", 5, "Rudyard Kipling", "2081263246");
        System.out.println(m1);
        m1.setCote("SD77DS");
        System.out.println("Cote modifiée : " + m1.getCote());

        // Utilisation du cast pour accéder à getAuteur()
        System.out.println("Auteur : " + ((Livre) m1).getAuteur());
    }
}
