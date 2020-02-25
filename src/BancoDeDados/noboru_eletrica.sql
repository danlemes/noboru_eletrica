use noboru_eletrica;

create table cliente (
	idCliente 	INT 		 NOT NULL 	AUTO_INCREMENT,
    nome		VARCHAR(150) NOT NULL,
    cpf			VARCHAR(11)  NOT NULL,
    celular		VARCHAR(20)	 NULL,
    email		VARCHAR(100) NULL,
    ativo		TINYINT		 NOT NULL,
    PRIMARY KEY (idCliente)
);

create table tipo_de_atendimento (
	idTipoDeAtendimento 	 INT 		  NOT NULL 	AUTO_INCREMENT,
    nomeTipoDeAtendimento	 VARCHAR(150) NOT NULL,
    ativo					 TINYINT	  NOT NULL,
    PRIMARY KEY (idTipoDeAtendimento)
);


