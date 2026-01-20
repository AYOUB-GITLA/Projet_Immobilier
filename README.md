Rapport sur mon mini projet
Application pour gerer l immobilier

<h2>1- Introduction <h2/>

Dans le cadre de ce petit projet , j'ai développé une application qui s'occupe de la gestion des biens, des propriétaires et des locations.
J'ai utilisé Java avec NetBeans et une base de données MySQL. L'objectif principal était de pouvoir consigner toutes ces informations, d'évaluer les revenus locatifs et de présenter des diagrammes pour les statistiques.
Cela nous a permis de nous exercer à la programmation orientée objet et à l'accès aux bases de données via JDBC.

2- Architecture générale du projet

J'ai envisagé une architecture multi-niveaux proche a l'architecture MVC pour en assurer la facilité de maintenance.
Les paquets sont distincts, avec un pack modèle pour les classes des biens, des propriétaires et de locations, un pack DAO pour l'accès aux données,
et un pack CRUD pour les opérations de création, lecture, mise à jour et suppression ce sont des interfaces graphiques . Ensuite, il y a le pack de connexion pour MySQL,
le pack de menu pour les interfaces utilisateurs ( pour ce connecter ou s'inscrire et dashbord ) et le pack util pour les graphiques.
Cette division suit le principe d'une unique responsabilité afin d'éviter toute confusion.

3- Description des packages et des classes

Le package modèle comprend une classe Java qui définit un bien avec les attributs :id_bien, ville, surface et prix mensuel.
Propriétaire avec : id_proprio le nom du contact et l'adresse. Et location pour id location , la ville ,les dates de location et la propriété associée.
Pour les biens DAO, nous avons BienDao. DaoPropriétaire destiné aux propriétaires. LocationDao pour la gestion des locations, ainsi que UserDao et StatistiqueDao.
Cela permet d'extraire les informations sans avoir à rédiger du SQL à chaque fois.

4- Fonctionnalités CRUD et interfaces graphiques

Les opérations CRUD sont incluses dans le package crud, comportant des Jframe telles que Gestion des Biens pour l'ajout, la modification et la suppression de biens ainsi que la rechercher et quelque filtres.
C'est le même cas pour les propriétaires et les locations. Pour vous connecter, utilisez MenuLogin pour accéder aux menus.
Inscription via MenuRegister et navigation via MenuPrincipal.

5- Conception de la base de données

J'ai nommer cette base de données sous le nom de db immobilier avec les tables suivantes:
La table propriétaire, elle contient les colonnes ID, nom, contact et adresse.
La table Bien avec identifiant, propriétaire, type, ville, superficie et coût mensuel.
Location avec id_location identifiant bien, date de début, date de fin et loyer.
Des utilisateurs ayant un identifiant, nom, prénom, email et mot de passe. Les clés étrangères établissent des liens pour maintenir la cohérence.

6- Technologies utilisées et résultats obtenus

J'ai utilisé Java JDK 8, NetBeans, et MySQL avec plusieurs autres jar pour importer des bibliothèques comme MySQL Connector, JCalendar et JFreeChart.
Les opérations fonctionnent, vous avez la possibilité d'ajouter, de modifier ou de supprimer des biens, la meme chose pour les propriétaires et les locations.
Réaliser automatiquement le calcul des revenus, en fonction de la ville ou du type, et même les propriétaires élaborer des graphiques concernant les loyers par ville ou les propriétaires selon le type de bien.

7- Analyse et diagrammes

Les diagrammes facilitent la compréhension, comme les revenus des locations par ville ou par propriétaires ou selon leur type(type du bien).
Cela simplifie les décisions, mais nous pourrions en rajouter d'avantage.

8- Conclusion

Pour résumer, ce projet nous a donné l'occasion de développer une application complète en Java avec une architecture solide. Nous avons étudié les interfaces et l'objet sur MySQL.

9- Script pour la cration de la base de donnée : 

CREATE DATABASE db_immobilier;
USE db_immobilier;

-- Table proprietaire
CREATE TABLE proprietaire (
    id_proprietaire INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    contact VARCHAR(100),
    adresse VARCHAR(150)
);

-- Table bien
CREATE TABLE bien (
    id_bien INT AUTO_INCREMENT PRIMARY KEY,
    id_proprietaire INT,
    type VARCHAR(50),
    ville VARCHAR(50),
    surface DOUBLE,
    prix_mensuel DOUBLE,
    CONSTRAINT fk_bien_proprietaire
        FOREIGN KEY (id_proprietaire)
        REFERENCES proprietaire(id_proprietaire)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Table location
CREATE TABLE location (
    id_location INT AUTO_INCREMENT PRIMARY KEY,
    id_bien INT,
    date_debut DATE,
    date_fin DATE,
    loyer DECIMAL(10,2),
    CONSTRAINT fk_location_bien
        FOREIGN KEY (id_bien)
        REFERENCES bien(id_bien)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Table users
CREATE TABLE users (
    ID_USER INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Email VARCHAR(100),
    PassWord VARCHAR(100)
);

10- Annexes :  

Lien drive vers le setup de l'application + des videos explicatives : 
