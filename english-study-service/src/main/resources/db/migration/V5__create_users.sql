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
values (1001, 'user', 'def1069c94af8cfa1c952ee0f16fd3f179986d7b6d298627d97d49db79ae4d6ca0c9c67aa9f54105', '+38(095)-123-45-67');

insert into users
values (1002, 'mike', 'def1069c94af8cfa1c952ee0f16fd3f179986d7b6d298627d97d49db79ae4d6ca0c9c67aa9f54105', '+38(098)-123-45-67');