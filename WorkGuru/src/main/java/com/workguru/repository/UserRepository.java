package com.workguru.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.workguru.domain.model.Pessoa;
import com.workguru.domain.model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByEmail(String email);

	@Query("select p1_0.id,p1_1.email,p1_1.nome,p1_1.senha,p1_1.tipo_usuario,p1_0.cpf,p1_0.data_nascimento,p1_0.endereco,p1_0.genero,p1_0.status,p1_0.telefone,p1_0.usuario_id from pessoa p1_0 join usuario p1_1 on p1_0.usuario_id=p1_1.id join usuario u1_0 on u1_0.id=p1_0.usuario_id where u1_0.tipo_usuario=:tipo_usuario")
	List<Pessoa> findByTipoUsuario(@Param("tipo_usuario") String tipoUsuario);
	
	
}
