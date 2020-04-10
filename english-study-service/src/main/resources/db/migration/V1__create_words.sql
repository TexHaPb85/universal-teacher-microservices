drop table words if exists;

create table words
(
    word_id     varchar(255) not null,
    translation varchar(255),
    word        varchar(255),
    primary key (word_id)
);