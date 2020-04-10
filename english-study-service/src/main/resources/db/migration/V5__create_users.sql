drop table users if exists;

create table users
(
    id           bigint not null,
    username     varchar(255),
    password     varchar(255),
    phone_number varchar(255),
    primary key (id)
);

insert into users
values (1001, '1234', '+38(095)-123-45-67', 'user');

insert into users
values (1002, '1234', '+38(098)-123-45-67', 'mike');