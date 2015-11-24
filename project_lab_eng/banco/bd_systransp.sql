create database bd_transp;
use bd_transp;

create table tb_usuario (
userid varchar(20) unique not null,
senha varchar(20) not null
);

CREATE TABLE tb_cliente
(
	cnpj_cliente         VARCHAR(14) NOT NULL,
	contato              VARCHAR(20) NULL,
	nome                 VARCHAR(40) NOT NULL,
	cep                  INTEGER NULL,
	rua                  VARCHAR(40) NULL,
	numero               VARCHAR(6) NULL,
	complemento          VARCHAR(40) NULL,
	bairro               VARCHAR(40) NULL,
	cidade               VARCHAR(40) NULL,
	uf                   VARCHAR(2) NULL,
	fone1                INTEGER NULL,
	fone2                INTEGER NULL,
	status               VARCHAR(20) NULL,
	dt_cadastro          DATETIME NULL,
	observacao           TEXT NULL
	
	);

ALTER TABLE tb_cliente
ADD PRIMARY KEY (cnpj_cliente);

/*CREATE TABLE tb_despesa
(
	nf_numero            INTEGER NOT NULL,
	servico              VARCHAR(20) NULL,
	valor                DOUBLE NULL,
	descricao            VARCHAR(400) NULL,
	km_servico           INTEGER NULL,
	placa                VARCHAR(7) NOT NULL,
	cnpj_fornecedor      VARCHAR(14) NOT NULL
);

ALTER TABLE tb_despesa
ADD PRIMARY KEY (nf_numero,cnpj_fornecedor);
*/

CREATE TABLE tb_destinatario
(
	cnpj_cliente         VARCHAR(20) NULL,
	contato				varchar(50) null,
    servprod			varchar(20) null,
    observacao           VARCHAR(200) NULL
	
);

CREATE TABLE tb_entrega
(
	dt_entrega           DATE NULL,
	status               VARCHAR(20) NULL,
	observacao           VARCHAR(200) NULL,
	nf_numero            INTEGER NOT NULL,
	placa                VARCHAR(7) NOT NULL,
	cnpj_cliente         VARCHAR(14) NOT NULL,
	cpf_motorista        INTEGER NOT NULL,
	dt_saida             DATETIME NOT NULL
);

ALTER TABLE tb_entrega
ADD PRIMARY KEY (nf_numero,cnpj_cliente,placa,cpf_motorista,dt_saida);

CREATE TABLE tb_fornecedor
(
	nome                 VARCHAR(40) NOT NULL,
	cep                  INTEGER NULL,
	rua                  VARCHAR(40) NULL,
	numero               VARCHAR(6) NULL,
	complemento          VARCHAR(40) NULL,
	bairro               VARCHAR(40) NULL,
	cidade               VARCHAR(40) NULL,
	uf                   VARCHAR(2) NULL,
	fone1                INTEGER NULL,
	fone2                INTEGER NULL,
	status               VARCHAR(20) NULL,
	dt_cadastro          DATETIME NULL,
	cnpj_fornecedor      VARCHAR(14) NOT NULL,
	contato              VARCHAR(20) NULL,
	serv_prod            VARCHAR(20) NULL,
	observacao           TEXT NULL
);

ALTER TABLE tb_fornecedor
ADD PRIMARY KEY (cnpj_fornecedor);

CREATE TABLE tb_motorista
(
	nome                 VARCHAR(40) NOT NULL,
	cep                  INTEGER NULL,
	rua                  VARCHAR(40) NULL,
	numero               VARCHAR(6) NULL,
	complemento          VARCHAR(40) NULL,
	bairro               VARCHAR(40) NULL,
	cidade               VARCHAR(40) NULL,
	uf                   VARCHAR(2) NULL,
	fone1                INTEGER NULL,
	fone2                INTEGER NULL,
	status               VARCHAR(20) NULL,
	dt_cadastro          DATETIME NULL,
	rg                   INTEGER NULL,
	cpf_motorista        INTEGER NOT NULL,
	cnh_numero           INTEGER NULL,
	cnh_categoria        VARCHAR(2) NULL,
	cnh_vencimento       DATE NULL,
	cnh_mopp             BIT NULL
);

ALTER TABLE tb_motorista
ADD PRIMARY KEY (cpf_motorista);

CREATE TABLE tb_recebimento
(
	dt_entrada           DATETIME NULL,
	tp_entrada           VARCHAR(20) NULL,
	nf_numero            INTEGER NOT NULL,
	nf_valor             DOUBLE NULL,
	peso                 DOUBLE NULL,
	qtde_volumes         INTEGER NULL,
	cnpj_cliente         VARCHAR(14) NOT NULL
);

ALTER TABLE tb_recebimento
ADD PRIMARY KEY (nf_numero,cnpj_cliente);

CREATE TABLE tb_veiculo
(
	placa                VARCHAR(7) NOT NULL,
	chassi               VARCHAR(20) NULL,
	marca                VARCHAR(20) NULL,
	modelo               VARCHAR(20) NULL,
	ano_fab              YEAR NULL,
	ano_mod              YEAR NULL,
	carroceria           VARCHAR(20) NULL,
	cap_carga            INTEGER NULL,
	km_troca_oleo        INTEGER NULL,
	ano_exerc_licenc     YEAR NULL,
	dt_documento         DATE NULL
);

ALTER TABLE tb_veiculo
ADD PRIMARY KEY (placa);

CREATE TABLE tb_viagem
(
	dt_saida             DATETIME NOT NULL,
	dt_chegada           DATETIME NULL,
	km_saida             INTEGER NULL,
	km_chegada           INTEGER NULL,
	placa                VARCHAR(7) NOT NULL,
	cpf_motorista        INTEGER NOT NULL
);

ALTER TABLE tb_viagem
ADD PRIMARY KEY (placa,cpf_motorista,dt_saida);

ALTER TABLE tb_despesa
ADD FOREIGN KEY R_14 (placa) REFERENCES tb_veiculo (placa);

ALTER TABLE tb_despesa
ADD FOREIGN KEY R_15 (cnpj_fornecedor) REFERENCES tb_fornecedor (cnpj_fornecedor);

ALTER TABLE tb_entrega
ADD FOREIGN KEY R_4 (nf_numero, cnpj_cliente) REFERENCES tb_recebimento (nf_numero, cnpj_cliente);

ALTER TABLE tb_entrega
ADD FOREIGN KEY R_5 (placa, cpf_motorista, dt_saida) REFERENCES tb_viagem (placa, cpf_motorista, dt_saida);

ALTER TABLE tb_recebimento
ADD FOREIGN KEY R_16 (cnpj_cliente) REFERENCES tb_cliente (cnpj_cliente);

ALTER TABLE tb_viagem
ADD FOREIGN KEY R_9 (placa) REFERENCES tb_veiculo (placa);

ALTER TABLE tb_viagem
ADD FOREIGN KEY R_17 (cpf_motorista) REFERENCES tb_motorista (cpf_motorista);
