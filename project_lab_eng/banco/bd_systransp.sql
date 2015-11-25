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
	datasaida	          DATE NULL,
	dataretorno		  	date null,
	observacao           VARCHAR(200) NULL,
	nfrecebimento		varchar(20) null, 
	cnpj_receb			varchar(14) null
);





/*Parei aqui*/
CREATE TABLE tb_motorista
(

	cnh					varchar(20) not null,
	nome                 VARCHAR(40) NOT NULL,
	vencimento             date NULL,
	categoria			varchar(40) null,
	moop				boolean,
	fone 				varchar(11) null,
	status				varchar(20) null,
	dtcadastro			varchar(10) null
);

CREATE TABLE tb_recebimento
(
	dt_entrada           DATE NULL,
	tipoentrada           VARCHAR(20) NULL,
	notafiscal            INTEGER NOT NULL,
	valornf            DOUBLE NULL,
	peso                 DOUBLE NULL,
	volumes         INTEGER NULL,
	status			varchar(20) null,
	cnpj_destinatario         VARCHAR(14) not null,
	cnpj_remetente		varchar(14) not null
);

CREATE TABLE tb_veiculo
(
	placa                VARCHAR(7) NOT NULL unique,
	chassi               VARCHAR(20) NULL,
	marca                VARCHAR(20) NULL,
	modelo               VARCHAR(20) NULL,
	anofabricacao              INTEGER NULL,
	anomodelo              INTEGER NULL,
	carroceria           VARCHAR(20) NULL,
	capacidadecarga            INTEGER NULL,
	status		    VARCHAR(20) NULL
);

CREATE TABLE tb_viagem
(
	dt_saida             DATE NOT NULL,
	dt_chegada           DATE NULL,
	km_saida             INTEGER NULL,
	km_chegada           INTEGER NULL,
    cidadedestino		varchar(30) null,
	placa                VARCHAR(7) NOT NULL,
	cnh_motorista        varchar(14) not null
);	
