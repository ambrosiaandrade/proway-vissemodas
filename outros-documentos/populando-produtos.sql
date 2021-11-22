drop schema vissemodas;
create schema vissemodas;
use vissemodas;

insert into produto(descricao, tamanho, valor_unitario, categoria, imagem, status) values 
('calça jogger preta', '38', 130.00, 'calças', 'assets/produtos/calca-1.png', 1),
('calça alfaiataria xadrez', '36', 140.00, 'calças', 'assets/produtos/calca-2.png', 1),
('calça jogger cinza', '42', 110.00, 'calças', 'assets/produtos/calca-3.png', 1);

insert into produto(descricao, tamanho, valor_unitario, categoria, imagem, status) values 
('camisa listrada azul', 'G', 130.00, 'camisas', 'assets/produtos/camisa-1.png', 1),
('camisa listrada colorida', 'M', 140.00, 'camisas', 'assets/produtos/camisa-2.png', 1),
('camisa preta', 'PP', 110.00, 'camisas', 'assets/produtos/camisa-3.png', 1),
('camisa cetim estampada', 'P', 180.00, 'camisas', 'assets/produtos/camisa-4.png', 1);

insert into produto(descricao, tamanho, valor_unitario, categoria, imagem, status) values 
('mochila notebook preta', 38, 130.00, 'mochilas', 'assets/produtos/mochila-1.png', 1),
('mochila tie-dye now united', 40, 140.00, 'mochilas', 'assets/produtos/mochila-2.png', 1),
('mochila preta naruto', 36, 110.00, 'mochilas', 'assets/produtos/mochila-3.png', 1),
('mochila colorida hamster', 36, 110.00, 'mochilas', 'assets/produtos/mochila-4.png', 1),
('mochila roxa unicórnio', 36, 110.00, 'mochilas', 'assets/produtos/mochila-5.png', 1);

insert into produto(descricao, tamanho, valor_unitario, categoria, imagem, status) values 
('sapato social preto', 38, 130.00, 'sapatos', 'assets/produtos/sapato-1.png', 1),
('mocassim verde musgo', 40, 140.00, 'sapatos', 'assets/produtos/sapato-2.png', 1),
('sapato social marrom', 36, 110.00, 'sapatos', 'assets/produtos/sapato-3.png', 1),
('sapato boneca nude', 36, 110.00, 'sapatos', 'assets/produtos/sapato-4.png', 1);

-- Ativando os produtos
update produto set status=1 where id in(1,2,3,4,5,6,7,8,9,10,11,12);