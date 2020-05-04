create table siteEscalade
(
    id          int unsigned auto_increment
        primary key,
    type        varchar(15) not null,
    secteur     varchar(20) not null,
    voie        int         not null,
    longueur    int         not null,
    cotation    varchar(15) null,
    orientation varchar(15) null,
    nom         varchar(50) not null
);