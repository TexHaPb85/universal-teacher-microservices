drop table words if exists;

create table words
(
    translation varchar(255),
    word        varchar(255) not null,
    primary key (word)
);