alter table lancamentos add column id_pessoa bigint;

alter table lancamentos add constraint fk_lancamentos_pessoas foreign key (id_pessoa) references pessoas(id);