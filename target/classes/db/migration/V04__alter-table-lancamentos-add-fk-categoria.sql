alter table lancamentos add column id_categoria bigint;

alter table lancamentos add constraint fk_lancamentos_categorias foreign key (id_categoria) references categorias(id);