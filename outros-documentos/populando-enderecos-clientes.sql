use vissemodas;

-- Endereços
insert into endereco (cep, estado, cidade, bairro, logradouro, numero) values
('97032-040', 'PE', 'Recife',  'Boa Viagem', 'Rua Bernardo Cohem', 21),
('27977-580', 'RJ', 'Macaé',  'Cabiúnas', 'Rua Fonseca', 154),
('51021-040', 'RS', 'Santa Maria', 'Tancredo Neves', 'Av. Eng. Domingos Ferreira', 18);

insert into endereco (cep, estado, cidade, bairro, logradouro, numero) values
('76629-970', 'GO', 'Goiás',  'Setor Central', 'Praça Doutor Brasil Caiado', 46),
('77019-128', 'TO', 'Palmas', 'Plano Diretor Sul', 'Quadra 1105 Sul Alameda', 19);



-- Clientes
insert into cliente (cpf, cnpj, nome, tipo_cliente, endereco) values ('702.377.314-28', null, 'Jana Ursel', 'FISICA', 1);
insert into cliente (cpf, cnpj, nome, tipo_cliente, endereco) values ('132.548.944-13', null, 'Zayn ad-Din Aliyyah', 'FISICA', 2);

insert into cliente (cpf, cnpj, nome, tipo_cliente, endereco) values (null, '00.802.269/0001-91', 'Rivenstorm', 'JURIDICA', 3);
insert into cliente (cpf, cnpj, nome, tipo_cliente, endereco) values (null, '89.607.746/0001-71', 'Dynaworth', 'JURIDICA', 4);