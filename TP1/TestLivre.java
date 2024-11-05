/*
TP 1: Retour sur Java
Université de Reims Champagne Ardennes
Despoullains Romain
*/

package TP1;

public class TestLivre {
    public static void main(String[] args) {
        Livre livre1 = new Livre("Le Petit Prince", "L001", 5, "Antoine de Saint-Exupéry", "978-0156013987");
        System.out.println(livre1);

        // Test des méthodes
        livre1.setNote(4);
        System.out.println("Après modification de la note : " + livre1.getNote());
    }
}
