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

create table site
(
    id             int auto_increment
        primary key,
    nom            varchar(50)   not null,
    departement    varchar(50)   not null,
    pays           varchar(32)   not null,
    cotation_min   varchar(10)   not null,
    cotation_max   varchar(10)   not null,
    description    varchar(1000) null,
    type           varchar(20)   not null,
    id_utilisateur int           null,
    constraint site_utilisateur_fk
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
    nom            varchar(50)   not null,
    description    varchar(1000) not null,
    lieu           varchar(50)   not null,
    is_reserve     tinyint(1)    null,
    date           date          not null,
    id_utilisateur int           not null,
    constraint membre_topos_fk
        foreign key (id_utilisateur) references utilisateur (id)
);

create table reservation
(
    id               int          not null
        primary key,
    status           varchar(50)  not null,
    date_reservation datetime     not null,
    id_utilisateur   int          not null,
    id_topos         int          not null,
    dateReservation  varchar(255) null,
    constraint FK3kt9mawec4sqdm8j6830e8yp9
        foreign key (id_utilisateur) references utilisateur (id),
    constraint topos_reservation_fk
        foreign key (id_topos) references topos (id),
    constraint utilisateur_reservation_fk
        foreign key (id) references utilisateur (id)
);

create table utilisateur_longueur
(
    Utilisateur_id  bigint not null,
    longueurList_id bigint not null,
    constraint UK_b6rqoruwoaunrj5uy4tl9f7vb
        unique (longueurList_id)
)
    engine = MyISAM;

create index FKoip4y1m3sipv5a5iic5gg2cq5
    on utilisateur_longueur (Utilisateur_id);

create table utilisateur_secteur
(
    Utilisateur_id bigint not null,
    secteurList_id bigint not null,
    constraint UK_2s62sov01s823ipjt8hjre30t
        unique (secteurList_id)
)
    engine = MyISAM;

create index FKmltx9y1qx73bwfngevxd4tnhd
    on utilisateur_secteur (Utilisateur_id);

create table utilisateur_site
(
    Utilisateur_id bigint not null,
    siteList_id    bigint not null,
    constraint UK_4b0v8of28fyl1t1wt0bkveadl
        unique (siteList_id)
)
    engine = MyISAM;

create index FKl0ajxy98ioa1u9hrg61f38tc9
    on utilisateur_site (Utilisateur_id);

create table utilisateur_voie
(
    Utilisateur_id bigint not null,
    voieList_id    bigint not null,
    constraint UK_nc0h3xbdi8cws6ygte8b9butc
        unique (voieList_id)
)
    engine = MyISAM;

create index FKowxnufac0l4bk2fcmc526mfn4
    on utilisateur_voie (Utilisateur_id);

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

