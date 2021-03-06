create table hibernate_sequence
(
    next_val bigint null
)
    engine = INNODB;

create table utilisateur
(
    id               int auto_increment
        primary key,
    nom              varchar(50)          not null,
    prenom           varchar(50)          not null,
    pseudo           varchar(50)          not null,
    mail             varchar(50)          not null,
    password         char(100)            not null,
    isMembreOfficiel tinyint(1) default 0 null
);

create table site
(
    id             int auto_increment
        primary key,
    nom            varchar(50)          not null,
    departement    varchar(50)          not null,
    pays           varchar(32)          not null,
    cotation_min   varchar(10)          not null,
    cotation_max   varchar(10)          not null,
    description    varchar(1000)        null,
    type           varchar(20)          not null,
    id_utilisateur int                  null,
    tague          tinyint(1) default 0 not null,
    constraint site_utilisateur_fk
        foreign key (id_utilisateur) references utilisateur (id)
);

create table commentaire
(
    id               int auto_increment
        primary key,
    titre            varchar(50)                        not null,
    commentaire      varchar(10000)                     not null,
    id_utilisateur   int                                not null,
    id_site          int                                not null,
    date_commentaire datetime default CURRENT_TIMESTAMP not null,
    constraint commentaire_topos_fk
        foreign key (id_site) references utilisateur (id),
    constraint FKkgndecm5i0gjb9q0vr7c7qpir
        foreign key (id_site) references site (id),
    constraint commentaire_utilisateur_fk
        foreign key (id_utilisateur) references utilisateur (id)
);

create table secteur
(
    id             int auto_increment
        primary key,
    nom            varchar(50)   not null,
    description    varchar(1000) not null,
    id_site        int           not null,
    id_utilisateur int           null,
    constraint secteur_utilisateur_fk
        foreign key (id_utilisateur) references utilisateur (id),
    constraint site_secteur_fk
        foreign key (id_site) references site (id)
);

create table topos
(
    id             int auto_increment
        primary key,
    nom            varchar(50)          not null,
    description    varchar(1000)        not null,
    lieu           varchar(50)          not null,
    is_reserve     tinyint(1) default 0 null,
    date           varchar(50)          not null,
    id_utilisateur int                  not null,
    constraint membre_topos_fk
        foreign key (id_utilisateur) references utilisateur (id)
);

create table reservation
(
    id               int auto_increment
        primary key,
    status           varchar(50)                        not null,
    date_reservation datetime default CURRENT_TIMESTAMP not null,
    id_utilisateur   int                                not null,
    id_topos         int                                not null,
    constraint FK3kt9mawec4sqdm8j6830e8yp9
        foreign key (id_utilisateur) references utilisateur (id),
    constraint topos_reservation_fk
        foreign key (id_topos) references topos (id),
    constraint utilisateur_reservation_fk
        foreign key (id_utilisateur) references utilisateur (id)
);

create table voie
(
    id             int auto_increment
        primary key,
    nom            varchar(40) not null,
    taille         int         not null,
    id_secteur     int         not null,
    id_utilisateur int         null,
    constraint secteur_voie_fk
        foreign key (id_secteur) references secteur (id),
    constraint voie_utilisateur_fk
        foreign key (id_utilisateur) references utilisateur (id)
);

create table longueur
(
    id             int auto_increment
        primary key,
    id_voie        int        not null,
    nbre_points    int        not null,
    taille         int        not null,
    cotation       varchar(5) not null,
    id_utilisateur int        null,
    constraint longueur_utilisateur_fk
        foreign key (id_utilisateur) references utilisateur (id),
    constraint voie_longueur_fk
        foreign key (id_voie) references voie (id)
);

