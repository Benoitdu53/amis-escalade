create table site
(
    id           int auto_increment
        primary key,
    nom          varchar(50)   not null,
    departement  varchar(50)   not null,
    pays         varchar(32)   not null,
    cotation_min varchar(10)   not null,
    cotation_max varchar(10)   not null,
    description  varchar(1000) null,
    type         varchar(20)   not null
);

create table secteur
(
    id          int auto_increment
        primary key,
    nom         varchar(50)   not null,
    description varchar(1000) not null,
    id_site     int           not null,
    constraint site_secteur_fk
        foreign key (id_site) references site (id)
);

create table utilisateur
(
    id               int auto_increment
        primary key,
    nom              varchar(50) not null,
    prenom           varchar(50) not null,
    pseudo           varchar(50) not null,
    mail             varchar(50) not null,
    password         char(40)    not null,
    isMembreOfficiel tinyint(1)  null
);

create table voie
(
    id         int auto_increment
        primary key,
    nom        varchar(40) not null,
    taille     int         not null,
    id_secteur int         not null,
    constraint secteur_voie_fk
        foreign key (id_secteur) references secteur (id)
);

create table longueur
(
    id          int auto_increment
        primary key,
    id_voie     int        not null,
    nbre_points int        not null,
    taille      int        not null,
    cotation    varchar(5) not null,
    constraint voie_longueur_fk
        foreign key (id_voie) references voie (id)
);

