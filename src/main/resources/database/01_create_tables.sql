
CREATE TABLE site (
                id INT AUTO_INCREMENT NOT NULL,
                nom VARCHAR(50) NOT NULL,
                departement VARCHAR(50),
                pays VARCHAR(50) NOT NULL,
                nbre_secteur INT,
                type VARCHAR(50),
                cotation_min INT,
                cotation_max INT NOT NULL,
                longueur_max INT NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE secteur (
                id INT AUTO_INCREMENT NOT NULL,
                secteur VARCHAR(50) NOT NULL,
                nbre_voie INT NOT NULL,
                id_site INT NOT NULL,
                PRIMARY KEY (id)
);


CREATE TABLE voie (
                id INT AUTO_INCREMENT NOT NULL,
                voie VARCHAR(50) NOT NULL,
                longueur INT NOT NULL,
                cotation VARCHAR(10) NOT NULL,
                id_secteur INT NOT NULL,
                PRIMARY KEY (id)
);


ALTER TABLE secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (id_site)
REFERENCES site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (id_secteur)
REFERENCES secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;
