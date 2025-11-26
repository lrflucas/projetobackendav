create table pessoas(
id bigint not null auto_increment,
nome varchar(100) not null,
logradouro varchar(50) not null,
numero varchar(20) not null,
complemento varchar(100),
bairro varchar(50) not null,
cep varchar(9) not null,
cidade varchar(100) not null,
estado varchar(2) not null,
ativo boolean,

primary key(id)
);