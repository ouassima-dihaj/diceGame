# Jeu de Dés 2 : Servlets, Gestion de la Session, Contexte et Filtres

Ce projet implémente un jeu de dés basé sur des servlets Java, avec gestion de session, utilisation du contexte et des filtres. Le jeu permet aux utilisateurs de lancer 3 dés numérotés (1, 2, 3) dans n’importe quel ordre, avec des règles spécifiques pour déterminer le score.

## Règles du Jeu

- Le joueur lance 3 dés numérotés (1, 2, 3) un par un dans n’importe quel ordre.
- Si un même dé est lancé plus d'une fois pendant la partie, le jeu s'arrête et le joueur reçoit un score de -1.
- Le score dépend des résultats des dés :
  - Si dé 1 < dé 2 < dé 3, le score est la somme des résultats.
  - Sinon, le score est nul.
- La partie s'arrête dès qu'il est possible de conclure sur le score.

## Fonctionnalités

- **Inscription d'un Compte** : Permet aux utilisateurs de créer un compte avec nom, prénom, login, mot de passe et meilleur score.
- **Stockage des Informations Utilisateur** : Les données utilisateur sont stockées dans des structures de données adaptées au contexte de l'application.
- **Connexion / Déconnexion** : Les utilisateurs peuvent se connecter et se déconnecter de leur compte.
- **Jeu de Dés** : Les utilisateurs peuvent jouer au jeu de dés via une interface web conviviale.
- **Consultation du Meilleur Score Personnel** : Permet aux utilisateurs de consulter leur meilleur score enregistré.
- **Consultation du Meilleur Score des Autres Joueurs** : Les utilisateurs peuvent voir le meilleur score des autres joueurs enregistrés sur l'application.

## Interfaces

- **Page de Lancement des Dés** : Interface web permettant de lancer les dés avec un champ de texte pour le numéro de dé à lancer.
- **Page de Fin de Partie** : Affiche le score de la partie jouée et le meilleur score enregistré sur l'application.

## Stockage des Données

L'application stocke les données des utilisateurs dans des structures de données appropriées au contexte de l'application, sans utiliser de base de données externe.

## Outils Utilisés

- **IDE** : IntelliJ
- **Package** : jakarta.servlet
- **Serveur** : Tomcat 10.1
