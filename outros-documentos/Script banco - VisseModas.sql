create table cliente (
	id bigint 	not null auto_increment, 
	documento 	varchar(255), 	
	email 		varchar(255), 
	nome 		varchar(255), 
	senha 		varchar(255), 
	status 		bit, 
	tipo_cliente 	varchar(255), 
	primary key (id)
);

create table item_pedido (
id			bigint not null auto_increment primary key,
produto_id		bigint not null,
pedido_id		bigint not null,
quantidade		int,
valor_total		double(10,2)
);

create table Pedido (
id			bigint not null auto_increment primary key,
cliente_id		bigint not null,
endereco_entrega_id	bigint not null,
data			date,
situacao		varchar(10),
valor_total		double(10,2),
quantidade_total	int,
percentual_desconto	double(4,2)
);

create table produto (
id			bigint not null auto_increment primary key,
descricao		varchar(50),
tamanho			varchar(10),
valor_unitario		double(10,2),
status			boolean
);

create table Endereco ( 
id			bigint not null auto_increment primary key,
cliente_id		bigint not null,
cep			varchar(9),
cidade			varchar(40),
bairro			varchar(50),
logradouro		varchar(100)
);

select * from cliente ; 	-- ok
select * from item_pedido; -- falta o backend
select * from pedido ; 		-- falta o backend
select * from produto ; 	-- ok
select * from endereco ; 	-- ok

-- FOREIGN KEYS
alter table item_pedido add constraint foreign key (produto_id) references produto(id);
alter table item_pedido add constraint foreign key (pedido_id) references pedido(id);

alter table pedido add constraint foreign key (cliente_id) references cliente(id);
alter table pedido add constraint foreign key (endereco_entrega_id) references endereco(id);

alter table endereco add constraint foreign key (cliente_id) references cliente(id);

-- INNER JOINS
select ip.quantidade, ip.valor_total, produto.descricao, pedido.situacao
from item_pedido as ip 
inner join produto on ip.produto_id = produto.id
inner join pedido on ip.pedido_id = pedido.id;

select ped.situacao, ped.valor_total, ped.quantidade_total, ped.percentual_desconto, cliente.nome, endereco.rua, endereco.bairro
from pedido as ped 
inner join cliente on ped.cliente_id = cliente.id
inner join endereco on ped.endereco_entrega_id = endereco.id;

select ende.cep, ende.cidade, ende.bairro, ende.rua, cliente.nome
from endereco as ende 
inner join cliente 
on ende.cliente_id = cliente.id;

-- CLIENTES
insert into cliente (documento, nome, tipo_cliente) values ('702.377.314-28', 'Rebeca Lira', "FISICA");
insert into cliente (documento, nome, tipo_cliente) values ('132.548.944-13', 'Yuri Ferreira', "FISICA");

-- PRODUTOS
insert into produto (descricao, tamanho, valor_unitario, status) values ('Calça jeans skinny', '40', 65.90, true);
insert into produto (descricao, tamanho, valor_unitario, status) values ('Body manga longa', 'M', 29.90, true);
insert into produto (descricao, tamanho, valor_unitario, status) values ('Scarpin', '38', 100.00, true);
				
-- PEDIDOS
insert into pedido (cliente_id, endereco_entrega_id, situacao, valor_total, quantidade_total, percentual_desconto)
			values (1, 2, 'FINALIZADO', 259.90, 3, 30.00),
				   (2, 1, 'A CAMINHO', 400.00, 7, 15.00);
		
-- ENDEREÇOS
insert into endereco (cliente_id, cep, cidade, bairro, logradouro) values
(1, '51021-020', 'Recife', 'Boa Viagem', 'Av. Conselheiro Aguiar'),
(2, '51021-040', 'Recife', 'Boa Viagem', 'Av. Eng. Domingos Ferreira');

-- ITENS PEDIDOS
insert into item_pedido (produto_id, pedido_id, quantidade, valor_total)
			values (1, 1, 5, 259.90),
				   (2, 2, 3, 400.00);
			




