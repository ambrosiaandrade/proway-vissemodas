CREATE SCHEMA vissemodas;

use vissemodas;

CREATE TABLE cliente (
	id bigint not null auto_increment,
	cnpj varchar(255),
	cpf varchar(255),
	nome varchar(255),
	tipo_cliente varchar(255),
	primary key (id)
);

--
CREATE TABLE endereco (
	id bigint not null auto_increment,
	bairro varchar(255),
	cep varchar(255),
	cidade varchar(255),
	estado varchar(255),
	logradouro varchar(255),
	numero integer,
	primary key (id)
);

--
CREATE TABLE item_pedido (
	id bigint not null auto_increment,
	quantidade integer,
	valor_item decimal(19, 2),
	pedido_id bigint,
	produto_id bigint,
	primary key (id)
);

--
CREATE TABLE pedido (
	id bigint not null auto_increment,
	data date,
	percentual_desconto double precision,
	quantidade_total integer,
	situacao varchar(255),
	valor_total decimal(19, 2),
	cliente_id bigint,
	endereco_entrega_id bigint,
	primary key (id)
);

--
CREATE TABLE produto (
	id bigint not null auto_increment,
	categoria varchar(255),
	descricao varchar(255),
	imagem varchar(255),
	status bit,
	tamanho varchar(255),
	valor_unitario decimal(19, 2),
	primary key (id)
);

--
SELECT
	*
FROM
	cliente;

-- ok
SELECT
	*
FROM
	item_pedido;

-- falta o backend
SELECT
	*
FROM
	pedido;

-- falta o backend
SELECT
	*
FROM
	produto;

-- ok
SELECT
	*
FROM
	endereco;

-- ok
-- FOREIGN KEYS alter TABLE item_pedido add constraint foreign key
(produto_id) references produto(id);

alter TABLE
	item_pedido
add
	constraint foreign key (pedido_id) references pedido(id);

alter TABLE
	pedido
add
	constraint foreign key (cliente_id) references cliente(id);

alter TABLE
	pedido
add
	constraint foreign key (endereco_entrega_id) references endereco(id);

alter TABLE
	endereco
add
	constraint foreign key (cliente_id) references cliente(id);

-- abaixo gerado pelo hibernate -------------- alter TABLE item_pedido add constraint foreign key (pedido_id) references pedido (id);
-- alter TABLE item_pedido add constraint foreign key (produto_id) references produto (id);
-- alter TABLE pedido add constraint foreign key (cliente_id) references cliente (id);
-- alter TABLE pedido add constraint foreign key (endereco_entrega_id) references endereco (id);
-- INNER JOINS
SELECT
	ip.quantidade,
	ip.valor_total,
	produto.descricao,
	pedido.situacao
FROM
	item_pedido AS ip
	INNER JOIN produto ON ip.produto_id = produto.id
	INNER JOIN pedido ON ip.pedido_id = pedido.id;

SELECT
	ped.situacao,
	ped.valor_total,
	ped.quantidade_total,
	ped.percentual_desconto,
	cliente.nome,
	endereco.rua,
	endereco.bairro
FROM
	pedido AS ped
	INNER JOIN cliente ON ped.cliente_id = cliente.id
	INNER JOIN endereco ON ped.endereco_entrega_id = endereco.id;

SELECT
	ende.cep,
	ende.cidade,
	ende.bairro,
	ende.rua,
	cliente.nome
FROM
	endereco AS ende
	INNER JOIN cliente ON ende.cliente_id = cliente.id;

-- CLIENTES
INSERT INTO
	cliente (cpf, cnpj, nome, tipo_cliente, endereco)
values
	(
		'702.377.314-28',
		null,
		'Rebeca Lira',
		'FISICA',
		1
	);

INSERT INTO
	cliente (cpf, cnpj, nome, tipo_cliente, endereco)
values
	(
		'132.548.944-13',
		null,
		'Yuri Ferreira',
		'FISICA',
		2
	);

INSERT INTO
	cliente (cpf, cnpj, nome, tipo_cliente, endereco)
values
	(
		null,
		'00.802.269/0001-91',
		'Rivenstorm',
		'JURIDICA',
		3
	);

INSERT INTO
	cliente (cpf, cnpj, nome, tipo_cliente, endereco)
values
	(
		null,
		'89.607.746/0001-71',
		'Dynaworth',
		'JURIDICA',
		4
	);

-- PRODUTOS
INSERT INTO
	produto(
		descricao,
		tamanho,
		valor_unitario,
		categoria,
		imagem,
		status
	)
values
	(
		'calça jogger preta',
		'38',
		130.00,
		'calças',
		'assets/produtos/calca-1.png',
		1
	),
	(
		'calça alfaiataria xadrez',
		'36',
		140.00,
		'calças',
		'assets/produtos/calca-2.png',
		1
	),
	(
		'calça jogger cinza',
		'42',
		110.00,
		'calças',
		'assets/produtos/calca-3.png',
		1
	);

INSERT INTO
	produto(
		descricao,
		tamanho,
		valor_unitario,
		categoria,
		imagem,
		status
	)
values
	(
		'camisa listrada azul',
		'G',
		1,
		130.00,
		'camisas',
		'assets/produtos/camisa-1.png',
		1
	),
	(
		'camisa listrada colorida',
		'M',
		140.00,
		'camisas',
		'assets/produtos/camisa-2.png',
		1
	),
	(
		'camisa preta',
		'PP',
		110.00,
		'camisas',
		'assets/produtos/camisa-3.png',
		1
	);

INSERT INTO
	produto(
		descricao,
		tamanho,
		valor_unitario,
		categoria,
		imagem,
		status
	)
values
	(
		'mochila notebook preta',
		38,
		130.00,
		'mochilas',
		'assets/produtos/mochila-1.png',
		1
	),
	(
		'mochila tie-dye now united',
		40,
		140.00,
		'mochilas',
		'assets/produtos/mochila-2.png',
		1
	),
	(
		'mochila preta naruto',
		36,
		110.00,
		'mochilas',
		'assets/produtos/mochila-3.png',
		1
	),
	(
		'mochila colorida hamster',
		36,
		110.00,
		'mochilas',
		'assets/produtos/mochila-4.png',
		1
	),
	(
		'mochila roxa unicórnio',
		36,
		110.00,
		'mochilas',
		'assets/produtos/mochila-5.png',
		1
	);

INSERT INTO
	produto(
		descricao,
		tamanho,
		valor_unitario,
		categoria,
		imagem,
		status
	)
values
	(
		'sapato social preto',
		38,
		130.00,
		'sapatos',
		'assets/produtos/sapato-1.png',
		1
	),
	(
		'mocassim verde musgo',
		40,
		140.00,
		'sapatos',
		'assets/produtos/sapato-2.png',
		1
	),
	(
		'sapato social marrom',
		36,
		110.00,
		'sapatos',
		'assets/produtos/sapato-3.png',
		1
	),
	(
		'sapato boneca nude',
		36,
		110.00,
		'sapatos',
		'assets/produtos/sapato-4.png',
		1
	);

-- PEDIDOS
INSERT INTO
	pedido (
		cliente_id,
		endereco_entrega_id,
		situacao,
		valor_total,
		quantidade_total,
		percentual_desconto
	)
values
	(1, 2, 'FINALIZADO', 259.90, 3, 30.00),
	(2, 1, 'A CAMINHO', 400.00, 7, 15.00);

-- ENDEREÇOS
INSERT INTO
	endereco (cliente_id, cep, cidade, bairro, logradouro)
values
	(
		1,
		'51021-020',
		'Recife',
		'Boa Viagem',
		'Av. Conselheiro Aguiar'
	),
	(
		2,
		'51021-040',
		'Recife',
		'Boa Viagem',
		'Av. Eng. Domingos Ferreira'
	);

-- ITENS PEDIDOS
INSERT INTO
	item_pedido (produto_id, pedido_id, quantidade, valor_total)
values
	(1, 1, 5, 259.90),
	(2, 2, 3, 400.00);