<h1>Rapport sur mon mini projet
Application pour gerer l immobilier</h1>

<h2>1- Introduction </h2>

Dans le cadre de ce petit projet , j'ai développé une application qui s'occupe de la gestion des biens, des propriétaires et des locations.
J'ai utilisé Java avec NetBeans et une base de données MySQL. L'objectif principal était de pouvoir consigner toutes ces informations, d'évaluer les revenus locatifs et de présenter des diagrammes pour les statistiques.
Cela nous a permis de nous exercer à la programmation orientée objet et à l'accès aux bases de données via JDBC.

<h2>2- Architecture générale du projet</h2>

J'ai envisagé une architecture multi-niveaux proche a l'architecture MVC pour en assurer la facilité de maintenance.
Les paquets sont distincts, avec un pack modèle pour les classes des biens, des propriétaires et de locations, un pack DAO pour l'accès aux données,
et un pack CRUD pour les opérations de création, lecture, mise à jour et suppression ce sont des interfaces graphiques . Ensuite, il y a le pack de connexion pour MySQL,
le pack de menu pour les interfaces utilisateurs ( pour ce connecter ou s'inscrire et dashbord ) et le pack util pour les graphiques.
Cette division suit le principe d'une unique responsabilité afin d'éviter toute confusion.

<h2>3- Description des packages et des classes</h2>

Le package modèle comprend une classe Java qui définit un bien avec les attributs :id_bien, ville, surface et prix mensuel.
Propriétaire avec : id_proprio le nom du contact et l'adresse. 
Et location pour id location , la ville ,les dates de location et la propriété associée.
Pour les biens DAO, nous avons BienDao. DaoPropriétaire destiné aux propriétaires. LocationDao pour la gestion des locations, ainsi que UserDao et StatistiqueDao.
Cela permet d'extraire les informations sans avoir à rédiger du SQL à chaque fois.

<h2>4- Fonctionnalités CRUD et interfaces graphiques</h2>

Les opérations CRUD sont incluses dans le package crud, comportant des Jframe telles que Gestion des Biens pour l'ajout, la modification et la suppression de biens ainsi que la rechercher et quelque filtres.
<img width="1585" height="829" alt="image" src="https://github.com/user-attachments/assets/b937f768-2a68-49dd-8637-e932e3871882" />

C'est le même cas pour les propriétaires et les locations. 

<img width="1457" height="656" alt="image" src="https://github.com/user-attachments/assets/20f8a7c7-3d7a-4e61-bb74-a7dbbdd15fe2" />
<img width="1297" height="686" alt="image" src="https://github.com/user-attachments/assets/ca78e2e6-2a8c-48f2-9d06-e5307f3dd84e" />

Pour vous connecter, utilisez MenuLogin pour accéder aux menus.
<img width="938" height="738" alt="image" src="https://github.com/user-attachments/assets/063c5b0f-afbb-4608-8392-40c92242da09" />
<img width="2560" height="1353" alt="image" src="https://github.com/user-attachments/assets/f792152b-25cb-4cad-926c-67550e2a2eca" />


Inscription via MenuRegister et navigation via MenuPrincipal.
<img width="1045" height="812" alt="image" src="https://github.com/user-attachments/assets/0855806f-fe94-478d-b8b8-e46dc2eee483" />


<h2>5- Conception de la base de données</h2>

J'ai nommer cette base de données sous le nom de db immobilier avec les tables suivantes:
La table propriétaire, elle contient les colonnes ID, nom, contact et adresse.
La table Bien avec identifiant, propriétaire, type, ville, superficie et coût mensuel.
Location avec id_location identifiant bien, date de début, date de fin et loyer.
Des utilisateurs ayant un identifiant, nom, prénom, email et mot de passe. Les clés étrangères établissent des liens pour maintenir la cohérence.

<h3>5-1 Diagramme de Classe :</h3>

<img width="418" height="633" alt="Nouveau document texte" src="https://github.com/user-attachments/assets/0b2965c2-936e-4f06-9b96-fbaad9528820" />

<h2>6- Technologies utilisées et résultats obtenus</h2>

J'ai utilisé Java JDK 8, NetBeans, et MySQL avec plusieurs autres jar pour importer des bibliothèques comme MySQL Connector, JCalendar et JFreeChart.
Les opérations fonctionnent, vous avez la possibilité d'ajouter, de modifier ou de supprimer des biens, la meme chose pour les propriétaires et les locations.
Réaliser automatiquement le calcul des revenus, en fonction de la ville ou du type, et même les propriétaires élaborer des graphiques concernant les loyers par ville ou les propriétaires selon le type de bien.

<h2>7- Analyse et diagrammes</h2>

Les diagrammes facilitent la compréhension, comme les revenus des locations par ville ou par propriétaires ou selon leur type(type du bien).
Cela simplifie les décisions, mais nous pourrions en rajouter d'avantage.

<h2>8- Conclusion</h2>

Pour résumer, ce projet nous a donné l'occasion de développer une application complète en Java avec une architecture solide. Nous avons étudié les interfaces et l'objet sur MySQL.

<h2>9- Script pour la cration de la base de donnée : </h2>

CREATE DATABASE db_immobilier;
USE db_immobilier;

<h3>-- Table proprietaire</h3>

CREATE TABLE proprietaire (
    id_proprietaire INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    contact VARCHAR(100),
    adresse VARCHAR(150)
);

<h3>-- Table bien</h3>

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

<h3>-- Table location</h3>

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

<h3>-- Table users</h3>

CREATE TABLE users (
    ID_USER INT AUTO_INCREMENT PRIMARY KEY,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Email VARCHAR(100),
    PassWord VARCHAR(100)
);

<h2>10- Annexes :  </h2>

Lien drive vers le setup de l'application + des videos explicatives : 
