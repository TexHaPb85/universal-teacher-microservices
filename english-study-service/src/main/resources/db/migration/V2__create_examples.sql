drop table examples if exists;

create table examples
(
    sentence    varchar(255) not null,
    translation varchar(255),
    word_id     varchar(255),
    primary key (sentence)
);