create table lancamentos(
id bigint not null auto_increment,
descricao varchar(100) not null,
data_vencimento date not null,
data_pagamento date,
valor decimal(10, 2) not null,
observacao varchar(100),
tipo varchar(20) not null,

primary key(id)
);