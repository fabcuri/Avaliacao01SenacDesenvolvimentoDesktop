drop database dbproduto;
create database dbproduto;
use dbproduto;
create table produto(
id int not null auto_increment,
nome varchar(200) not null,
preco float not null,
codigo char(4) not null,
primary key(id))
;


