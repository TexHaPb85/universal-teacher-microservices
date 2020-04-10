
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

drop table words if exists;

create table words
(
    translation varchar(255),
    word        varchar(255) not null,
    primary key (word)
);