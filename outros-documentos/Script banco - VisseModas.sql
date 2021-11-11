create table Cliente (
id				bigint not null auto_increment primary key,
cpf				varchar(10),
cnpj			varchar(20),
nome 			varchar(100),
tipo_cliente	int
);

create table item_pedido (
id				bigint not null auto_increment primary key,
produto_id		bigint not null,
pedido_id		bigint not null,
quantidade		int,
valor_total		double(10,2)
);

alter table item_pedido add constraint foreign key (produto_id) references produto(id);
alter table item_pedido add constraint foreign key (pedido_id) references pedido(id);

create table Pedido (
id					bigint not null auto_increment primary key,
cliente_id			bigint not null,
endereco_entrega_id	bigint not null,
data				date,
situacao			varchar(10),
valor_total			double(10,2),
quantidade_total	int,
percentual_desconto	double(3,2)
);

alter table pedido add constraint foreign key (cliente_id) references cliente(id);
alter table pedido add constraint foreign key (endereco_entrega_id) references endereco(id);

create table produto (
id				bigint not null auto_increment primary key,
descricao		varchar(50),
tamanho			varchar(10),
valor_unitario	double(10,2),
status			boolean
);

create table Endereco ( 
id				bigint not null auto_increment primary key,
cliente_id		bigint not null,
cep				varchar(9),
cidade			varchar(40),
bairro			varchar(50),
rua				varchar(20)
);

alter table endereco add constraint foreign key (cliente_id) references cliente(id);

