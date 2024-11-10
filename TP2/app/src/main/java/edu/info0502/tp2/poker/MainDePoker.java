package edu.info0502.tp2.poker;

import java.util.*;

public class MainDePoker implements Comparable<MainDePoker> {
    private List<Carte> cartes;

    // Enumération des combinaisons possibles
    public enum Combinaison {
        HAUTEUR(1), PAIRE(2), DOUBLE_PAIRE(3), BRELAN(4), SUITE(5),
        COULEUR(6), FULL(7), CARRE(8), QUINTE_FLUSH(9), QUINTE_FLUSH_ROYALE(10);

        private final int force;

        Combinaison(int force) {
            this.force = force;
        }

        public int getForce() {
            return force;
        }
    }

    private Combinaison combinaison;
    private List<Integer> valeursDesCartes;

    // Constructeur
    public MainDePoker(List<Carte> cartes) {
        this.cartes = new ArrayList<>(cartes);
        evaluerMain();
    }

    // Méthode pour évaluer la main
    private void evaluerMain() {
        // Trier les cartes par valeur décroissante
        Collections.sort(cartes, Collections.reverseOrder());
        valeursDesCartes = new ArrayList<>();
        Map<Integer, Integer> occurrences = new HashMap<>();
        Map<Carte.Couleur, Integer> occurrencesCouleurs = new HashMap<>();

        for (Carte carte : cartes) {
            int valeur = carte.getValeur().getValeur();
            valeursDesCartes.add(valeur);

            // Compter les occurrences des valeurs
            occurrences.put(valeur, occurrences.getOrDefault(valeur, 0) + 1);

            // Compter les occurrences des couleurs
            Carte.Couleur couleur = carte.getCouleur();
            occurrencesCouleurs.put(couleur, occurrencesCouleurs.getOrDefault(couleur, 0) + 1);
        }

        boolean estSuite = verifierSuite();
        boolean estCouleur = occurrencesCouleurs.containsValue(5);

        if (estSuite && estCouleur) {
            if (valeursDesCartes.get(0) == 14) {
                combinaison = Combinaison.QUINTE_FLUSH_ROYALE;
            } else {
                combinaison = Combinaison.QUINTE_FLUSH;
            }
        } else if (occurrences.containsValue(4)) {
            combinaison = Combinaison.CARRE;
        } else if (occurrences.containsValue(3) && occurrences.containsValue(2)) {
            combinaison = Combinaison.FULL;
        } else if (estCouleur) {
            combinaison = Combinaison.COULEUR;
        } else if (estSuite) {
            combinaison = Combinaison.SUITE;
        } else if (occurrences.containsValue(3)) {
            combinaison = Combinaison.BRELAN;
        } else if (Collections.frequency(occurrences.values(), 2) == 2) {
            combinaison = Combinaison.DOUBLE_PAIRE;
        } else if (occurrences.containsValue(2)) {
            combinaison = Combinaison.PAIRE;
        } else {
            combinaison = Combinaison.HAUTEUR;
        }

        // Pour les comparaisons ultérieures, on construit une liste des valeurs des
        // cartes en ordre de priorité
        valeursDesCartes = construireListeComparaison(occurrences);
    }

    // Méthode pour vérifier si la main est une suite
    private boolean verifierSuite() {
        List<Integer> valeursUnique = new ArrayList<>(new HashSet<>(valeursDesCartes));
        Collections.sort(valeursUnique, Collections.reverseOrder());

        // Cas particulier pour l'As pouvant être utilisé comme 1 dans une suite
        // A-2-3-4-5
        if (valeursUnique.equals(Arrays.asList(14, 5, 4, 3, 2))) {
            return true;
        }

        for (int i = 0; i < valeursUnique.size() - 4; i++) {
            int valeurCourante = valeursUnique.get(i);
            boolean estSuite = true;
            for (int j = 1; j < 5; j++) {
                if (!valeursUnique.contains(valeurCourante - j)) {
                    estSuite = false;
                    break;
                }
            }
            if (estSuite) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour construire la liste des valeurs pour la comparaison des mains
    private List<Integer> construireListeComparaison(Map<Integer, Integer> occurrences) {
        List<Integer> listeComparaison = new ArrayList<>();

        // Créer des listes pour chaque type d'occurrence
        List<Integer> quadruples = new ArrayList<>();
        List<Integer> triples = new ArrayList<>();
        List<Integer> doubles = new ArrayList<>();
        List<Integer> simples = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int valeur = entry.getKey();
            int count = entry.getValue();
            if (count == 4) {
                quadruples.add(valeur);
            } else if (count == 3) {
                triples.add(valeur);
            } else if (count == 2) {
                doubles.add(valeur);
            } else {
                simples.add(valeur);
            }
        }

        // Ajouter les valeurs dans l'ordre de priorité pour la comparaison
        if (!quadruples.isEmpty()) {
            listeComparaison.addAll(quadruples);
        }
        if (!triples.isEmpty()) {
            listeComparaison.addAll(triples);
        }
        if (!doubles.isEmpty()) {
            Collections.sort(doubles, Collections.reverseOrder());
            listeComparaison.addAll(doubles);
        }
        if (!simples.isEmpty()) {
            Collections.sort(simples, Collections.reverseOrder());
            listeComparaison.addAll(simples);
        }

        return listeComparaison;
    }

    // Getter pour les cartes
    public List<Carte> getCartes() {
        return cartes;
    }

    // Getter pour la combinaison
    public Combinaison getCombinaison() {
        return combinaison;
    }

    // Méthode pour comparer deux mains
    @Override
    public int compareTo(MainDePoker autre) {
        // Comparer les forces des combinaisons
        int comparaisonCombinaison = Integer.compare(this.combinaison.getForce(), autre.combinaison.getForce());
        if (comparaisonCombinaison != 0) {
            return comparaisonCombinaison;
        }
        // Si les combinaisons sont identiques, comparer les valeurs des cartes
        for (int i = 0; i < this.valeursDesCartes.size(); i++) {
            if (i >= autre.valeursDesCartes.size()) {
                return 1;
            }
            int comparaisonValeur = Integer.compare(this.valeursDesCartes.get(i), autre.valeursDesCartes.get(i));
            if (comparaisonValeur != 0) {
                return comparaisonValeur;
            }
        }
        // Les mains sont égales
        return 0;
    }

    // Méthode pour afficher la main
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Main : ");
        for (Carte carte : cartes) {
            sb.append(carte.toString()).append(", ");
        }
        sb.append("Combinaison : ").append(combinaison);
        return sb.toString();
    }
}
