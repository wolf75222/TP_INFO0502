# TP1 Java - Gestion d'une Médiathèque

Bienvenue dans le **TP1 Java - Gestion d'une Médiathèque** réalisé dans le cadre du cours **INFO0502 - Introduction à la programmation répartie** à l'**Université de Reims Champagne Ardennes**.


## Introduction

Ce TP a pour objectif de mettre en œuvre une application Java permettant de gérer une médiathèque. Il illustre les concepts fondamentaux de la programmation orientée objet tels que l'héritage, l'encapsulation et la gestion des collections. Le TP comprend la création de classes pour différents types de médias (Livres et Films) ainsi qu'une classe de gestion de la médiathèque elle-même.

### Description des Dossiers et Fichiers

- **Classes Java**
  - `Media.java` : Classe mère représentant un média général.
  - `Livre.java` : Classe fille représentant un livre, héritant de `Media`.
  - `Film.java` : Classe fille représentant un film, héritant de `Media`.
  - `Mediatheque.java` : Classe de gestion de la médiathèque contenant une collection de médias.

- **Programmes de Test**
  - `TestMediatheque.java` : Programme de test pour la classe `Mediatheque`.
  - `TestLivre.java` : Programme de test pour la classe `Livre`.
  - `TestFilm.java` : Programme de test pour la classe `Film`.

- **Rapport**
  - `Rapport/TP1 Java.pdf` : Rapport détaillé du TP1 incluant les explications, le code, et les diagrammes UML.

- **Diagrammes UML**
  - `uml/` : Contient les fichiers PlantUML (`.puml`) décrivant les classes et les séquences.
  - `diagrams/` : Contient les diagrammes générés au format PNG à partir des fichiers `.puml`.

## Compilation et Exécution

### Compilation des Classes

Naviguez dans le répertoire contenant les fichiers `.java` et compilez-les en utilisant `javac`.

```bash
# Compiler toutes les classes Java
javac *.java
```

### Exécution des Programmes de Test

Après compilation, exécutez les programmes de test pour vérifier le bon fonctionnement des classes.

```bash
# Exécuter TestMediatheque
java TestMediatheque

# Exécuter TestLivre
java TestLivre

# Exécuter TestFilm
java TestFilm
```

## Tests Unitaires

Les programmes de test inclus (`TestMediatheque.java`, `TestLivre.java`, `TestFilm.java`) permettent de valider les fonctionnalités des classes principales. Ils démontrent la création d'objets, la modification de leurs attributs et l'affichage des résultats.

## Diagrammes UML

Des diagrammes UML ont été générés pour visualiser la structure des classes et les interactions dans les programmes de test.

### Aperçu des Diagrammes

- **Diagrammes de Classe**
  - `Media.png`
  - `Livre.png`
  - `Film.png`
  - `Mediatheque.png`

- **Diagrammes de Séquence**
  - `TestMediatheque.png`
  - `TestLivre.png`
  - `TestFilm.png`

## Rapport

Le rapport détaillé du TP1 est disponible dans le dossier `Rapport` sous le nom de `TP1 Java.pdf`. Il contient :

- Introduction
- Description des classes
- Réponses aux questions posées
- Intégration des diagrammes UML
- Conclusion
- Annexes avec le code complet des classes et des programmes de test
