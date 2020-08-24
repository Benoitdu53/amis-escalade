# amis-escalade 

##### Application web développé dans le cadre du projet 6 OpenClassromms du parcours "Développeur d'application-Java"
##### Nom du projet "Les amis de l'escalade"

##### Objet : Création d'un site communautaire autour de l'escalade

##### Fonctionnalités :

* F1 : Un utilisateur doit pouvoir consulter les informations des sites
  d’escalades (secteurs, voies, longueurs, etc.).
  
* F2 : Un utilisateur doit pouvoir faire une recherche à l’aide de plusieurs
 critères pour trouver un site de grimpe et consulter le résultat de cette
 recherche. Les critères peuvent être le lieu, la cotation, le nombre de
 secteurs, etc
 
* F3 : Un utilisateur doit pouvoir s’inscrire gratuitement sur le site.

* F4 : Un utilisateur connecté doit pouvoir partager des informations sur un
  site d’escalade (secteurs, voies, longueurs, etc.).
  
* F5 : Un utilisateur connecté doit pouvoir laisser des commentaires sur les
  pages des sites d’escalade.
  
* F6 : Un membre de l'association doit pouvoir taguer un site d’escalade
  enregistré sur la plateforme comme « Officiel Les amis de l’escalade ».
  
* F7 : Un membre de l'association doit pouvoir modifier et supprimer un
  commentaire.
  
* F8 : Un utilisateur connecté doit pouvoir enregistrer dans son espace
personnel les topos qu’ils possèdent et préciser si ces derniers sont
disponibles pour être prêtés ou non.
Un topo est défini par un nom, une description, un lieu et une date de
parution.

* F9 : Un utilisateur connecté doit pouvoir consulter la liste des topos
disponibles par d’autres utilisateurs et faire une demande de réservation.
La réservation n’inclut pas les notions de date de début et date de fin.

* F10 : Un utilisateur connecté doit pouvoir accepter une demande de
réservation. Si une réservation est acceptée, automatiquement le topo
devient indisponible. L’utilisateur connecté pourra ensuite de nouveau
changer le statut du topo en « disponible ».
La plateforme se contente de mettre en contact les deux parties pour le
prêt d’un topo (par échange de coordonnées).

###### Contraintes :

* Déploiement sur serveur Apache Tomcat

* SGBD et framework ORM mis en oeuvre

* Gestion des dépendance et package avec Maven

* Application développée en JAVA EE

* Application web responsive

###### Déploiement de l'application :

---- Base de données 

	- L'application à été configurée pour une base de données MySQL.
	
	- Installer  MySQL Workbench. Téléchargement et documentation sur https://www.mysql.com/fr/products/workbench/.
	
	- Créer un profil utilisateur avec les droits de création et de gestion de base de données. (username='admin' & password='admin')
	
	- Utiliser les scripts SQL dans MySQLWorkbench dans l'ordre ( 01_create_database, 02_create_tables, 03_insert_data ) pour pouvoir utiliser les données. (Scripts télécharger via le github voir plus loin )
	
---- Installation de Maven 

	- Pour installer Maven, télécharger le depuis le site officiel : https://maven.apache.org/
	
---- Déroulement du déploiement 

	Après avoir installer maven, télécharger le code de l'application en cliquant sur "Code" et "download ZIP" sur le lien Github. Décompressez le .ZIP. Ouvrez le terminal et placer vous dans le dossier parent, tapez dans "mvn package". Un dossier "target" sera créé et dans ce dossier vous trouverez un fichier amis.escalde.war.
	
---- Déploiement sur le serveur Tomcat 
	
	- Télécharger Tomcat et installer le comme indiqué sur le site officiel : http://tomcat.apache.org/
		
	- Une fois installé, démarré Tomcat et allez sur l'adresse http:/localhost:8080
	
	- Cliquez sur "Manager App" et dans le cadre "Déployer" , 'Fichier WAR à déployer", cliquez sur "Parcourir", récupérer le fichier WAR du dossier "target" du code.
	
---- Accéder à l'application 

	- démarrer votre base de données Workbench et votre serveur Tomcat 
	
	- Allez sur l'adresse http://localhost:8080/amis.escalade/sites et proftiez de l'application
