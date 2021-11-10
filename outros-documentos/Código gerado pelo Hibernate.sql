-- Código gerado pelo Hibernate
-- spring.jpa.show-sql=true

CREATE TABLE clientepf (
    id bigint NOT NULL,
    nome varchar(255),
    cpf varchar(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB 

CREATE TABLE clientepj (
    id bigint NOT NULL,
    nome varchar(255),
    cnpj varchar(255),
    PRIMARY KEY (id)
) ENGINE = InnoDB 

CREATE TABLE endereco (
    id bigint NOT NULL AUTO_INCREMENT,
    bairro varchar(255),
    cep varchar(255),
    cidade varchar(255),
    rua varchar(255),
    cliente_id bigint,
    PRIMARY KEY (id)
) ENGINE = InnoDB 

CREATE TABLE hibernate_sequences (
    sequence_name varchar(255) NOT NULL,
    next_val bigint,
    PRIMARY KEY (sequence_name)
) ENGINE = InnoDB

INSERT INTO
    hibernate_sequences(sequence_name, next_val)
VALUES
    ('default', 0) 
    
CREATE TABLE item_pedido (
        id bigint NOT NULL AUTO_INCREMENT,
        quantidade integer,
        valor_total double precision,
        pedido_id bigint,
        produto_id bigint,
        PRIMARY KEY (id)
    ) ENGINE = InnoDB 

CREATE TABLE pedido (
        id bigint NOT NULL AUTO_INCREMENT,
        data date,
        percentual_desconto double precision,
        quantidade_total integer,
        situacao varchar(255),
        valor_total double precision,
        cliente_id bigint,
        endereco_entrega_id bigint,
        PRIMARY KEY (id)
    ) ENGINE = InnoDB 
    
CREATE TABLE produto (
        id bigint NOT NULL AUTO_INCREMENT,
        descricao varchar(255),
        STATUS bit,
        tamanho varchar(255),
        valor_unitario double precision,
        PRIMARY KEY (id)
    ) ENGINE = InnoDB

ALTER TABLE
    item_pedido
ADD
    CONSTRAINT FK60ym08cfoysa17wrn1swyiuda FOREIGN KEY (pedido_id) REFERENCES pedido (id)

ALTER TABLE
    item_pedido
ADD
    CONSTRAINT FKtk55mn6d6bvl5h0no5uagi3sf FOREIGN KEY (produto_id) REFERENCES produto (id)
    
ALTER TABLE
    pedido
ADD
    CONSTRAINT FKcrxxe5rpllxbh0sfi4a6rwphb FOREIGN KEY (endereco_entrega_id) REFERENCES endereco (id)