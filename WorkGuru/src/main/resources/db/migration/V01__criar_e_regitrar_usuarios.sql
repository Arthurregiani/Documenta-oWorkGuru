CREATE TABLE `usuario` (
  `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(150) NOT NULL,
  `tipo_usuario` varchar(1) NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (id, nome, email, senha, tipo_usuario) 
	values (1, 'Marlabs', 'marlabs@gmail.com', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', 'E');
INSERT INTO usuario (id, nome, email, senha, tipo_usuario) 
	values (2, 'Gislaine Rosales', 'gislainerosales@ifsp.edu.br', '$2a$10$Ot4XGuyPP7r82nN3WXA0bOL1Qk9gShKDlVuPoyp89HoFnHcwO4Tji', 'P');
	
CREATE TABLE `empresa` (
    `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
	`cnpj` varchar(18) NOT NULL,
	`telefone` varchar(20) NOT NULL,
	`descricao` text NULL,
	`link_site` varchar(50) NULL,
	`endereco` varchar(45) NULL,
	`usuario_id`bigint(20) NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO empresa (id, cnpj, telefone, usuario_id)
	values (1, '99.999.999/9999-99', '10000-0000', 1);

CREATE TABLE `pessoa` (
    `id` bigint(20) PRIMARY KEY AUTO_INCREMENT,
	`cpf` varchar(14) NOT NULL,
	`status` varchar(45) NOT NULL,
    `telefone` varchar(20),
	`data_nascimento` date NOT NULL,
	`genero` varchar(10) NOT NULL,
	`endereco` varchar(45) NULL,
	`usuario_id` bigint(20) NOT NULL,
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (id, cpf, status, telefone, data_nascimento, genero, usuario_id)
	values (1, '000.000.000-00', 'TRABALHANDO', '20000-0000', '1984/08/08' ,'FEMININO', 2);
