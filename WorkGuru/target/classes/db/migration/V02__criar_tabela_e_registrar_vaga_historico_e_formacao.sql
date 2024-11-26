CREATE TABLE vaga (
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`titulo` VARCHAR(45) NOT NULL,
	`area_atuacao` VARCHAR(45) NOT NULL,
	`tecnologia` VARCHAR(45) NOT NULL,
	`descricao` VARCHAR(45) NOT NULL,
	`nivel` VARCHAR(45) NOT NULL,
	`modelo` VARCHAR(45) NOT NULL,
	`salario` VARCHAR(45) NOT NULL,
	`status` VARCHAR(45) NOT NULL,
	`data_publicacao` DATE NOT NULL,
	`empresa_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (empresa_id) REFERENCES empresa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO vaga (id, titulo, area_atuacao, tecnologia, descricao, nivel, modelo, salario, status, data_publicacao, empresa_id ) 
	values (1, 'Dev Backend', 'Backend' , 'java', 'Atuar como dev', 'Júnior', 'Híbrido', '1200', 'Aberta', '2024/11/06', 1);
	
CREATE TABLE formacao (
	`id`BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`nome_instituicao` VARCHAR(45) NOT NULL,
	`curso` VARCHAR(45) NULL,
	`grau` VARCHAR (20) NOT NULL,
	`periodo_inicio` DATE NOT NULL,
	`periodo_fim` DATE NULL,
	`pessoa_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE historico_profissional (
	`id`BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`nome_empresa` VARCHAR(45) NOT NULL,
	`periodo_inicio` DATE NOT NULL,
	`periodo_fim` DATE NULL,
	`cargo` VARCHAR(45) NOT NULL,
	`descricao` TEXT,
	`pessoa_id` BIGINT(20) NOT NULL,
	FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE vaga_pessoa (
	vaga_id BIGINT(20),
	pessoa_id BIGINT(20),
	PRIMARY KEY (vaga_id, pessoa_id),
	FOREIGN KEY (vaga_id) REFERENCES vaga(id),
	FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO vaga_pessoa (vaga_id, pessoa_id) values (1, 1);
