create table site
(
    id           int auto_increment
        primary key,
    nom          varchar(50) not null,
    departement  varchar(50) null,
    pays         varchar(50) not null,
    nbre_secteur int         null,
    type         varchar(50) null,
    cotation_min int         null,
    cotation_max int         not null,
    longueur_max int         not null
);

create table secteur
(
    id        int auto_increment
        primary key,
    secteur   varchar(50) not null,
    nbre_voie int         not null,
    id_site   int         not null,
    constraint site_secteur_fk
        foreign key (id_site) references site (id)
);

create table voie
(
    id         int auto_increment
        primary key,
    voie       varchar(50) not null,
    longueur   int         not null,
    cotation   varchar(10) not null,
    id_secteur int         not null,
    constraint secteur_voie_fk
        foreign key (id_secteur) references secteur (id)
);

create table longueur
(
    id          int auto_increment
        primary key,
    long_relais int null,
    long_total  int not null,
    id_voie     int not null,
    constraint voie_longueur_fk
        foreign key (id_voie) references voie (id)
);
