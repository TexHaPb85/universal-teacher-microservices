create table words
(
    translation varchar(255),
    word        varchar(255) not null,
    primary key (word)
);

create table examples
(
    sentence    varchar(255) not null,
    translation varchar(255),
    irr_verb_id varchar(255),
    word_id     varchar(255),
    primary key (sentence)
);

create table irregular_verb
(
    infinitive      varchar(255) not null,
    past_participle varchar(255),
    past_simple     varchar(255),
    translation     varchar(255),
    primary key (infinitive)
);

create table users
(
    id           bigint not null,
    password     varchar(255),
    phone_number varchar(255),
    username     varchar(255),
    primary key (id)
);

alter table examples add constraint FKpt3to3f7kuu3xg8un85i5hvar foreign key (word_id) references words;

alter table examples add constraint FK1q5f6i7hltga5tnlqejiyhslq foreign key (irr_verb_id) references irregular_verb;

insert into words
values ('зберігання, наполегливість', 'persistence');
insert into words
values ('здійснювати', 'carry out');
insert into words
values ('з`ясувати', 'figure out');

insert into examples(sentence, translation, word_id) VALUES ('persistence with spring', 'зберігання з спрінг', 'persistence');
insert into examples(sentence, translation, word_id) VALUES ('spring figures out the control', 'spring здійснює контроль', 'carry out');
insert into examples(sentence, translation, word_id) VALUES ('spring security figures out the authentication', 'spring security здійснює аутентифікацію', 'carry out');

insert into users
values (1001, 'user', 'def1069c94af8cfa1c952ee0f16fd3f179986d7b6d298627d97d49db79ae4d6ca0c9c67aa9f54105', '+38(095)-123-45-67');
insert into users
values (1002, 'mike', 'def1069c94af8cfa1c952ee0f16fd3f179986d7b6d298627d97d49db79ae4d6ca0c9c67aa9f54105', '+38(098)-123-45-67');


insert into irregular_verb values ('find', 'found', 'found', 'знаходити');
insert into examples(sentence, translation, irr_verb_id) VALUES ('I`ve found her', 'Я її знайшов', 'find');