package com.workguru.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workguru.domain.model.Pessoa;



public interface PeopleRepository extends JpaRepository<Pessoa, Long>{
	
	Optional<Pessoa> findByCpf(String cpf);

	
	
	
}
