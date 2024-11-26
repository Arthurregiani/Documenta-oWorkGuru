CREATE TABLE permissao (
	id BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao_usuario (
	usuario_id BIGINT(20) NOT NULL,
	permissao_id BIGINT(20) NOT NULL,
	PRIMARY KEY (usuario_id, permissao_id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id),
	FOREIGN KEY (permissao_id) REFERENCES permissao(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- senha admin
INSERT INTO usuario (id, nome,email, senha) values (3, 'Admin', 'admin@workguru.com', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

-- usuario
INSERT INTO permissao (id, descricao) values (1, 'FUNCAO_REGISTRAR_USUARIO');
INSERT INTO permissao (id, descricao) values (2, 'FUNCAO_DELETAR_USUARIO');
INSERT INTO permissao (id, descricao) values (3, 'FUNCAO_PROCURAR_USUARIO');

-- vaga
INSERT INTO permissao (id, descricao) values (4, 'FUNCAO_REGISTRAR_VAGA');
INSERT INTO permissao (id, descricao) values (5, 'FUNCAO_DELETAR_VAGA');
INSERT INTO permissao (id, descricao) values (6, 'FUNCAO_PROCURAR_VAGA');
INSERT INTO permissao (id, descricao) values (7, 'FUNCAO_APLICAR_VAGA');

-- admin
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (3, 1);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (3, 2);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (3, 3);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (3, 4);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (3, 5);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (3, 6);

-- marlabs
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (1, 1);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (1, 3);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (1, 4);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (1, 5);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (1, 6);

-- gislaine
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (2, 1);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (2, 3);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (2, 4);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (2, 6);
INSERT INTO permissao_usuario (usuario_id, permissao_id) values (2, 7);
