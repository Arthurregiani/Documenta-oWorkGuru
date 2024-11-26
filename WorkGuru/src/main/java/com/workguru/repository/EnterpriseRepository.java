package com.workguru.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workguru.domain.model.Empresa;
import com.workguru.domain.model.Vaga;

public interface EnterpriseRepository extends JpaRepository<Empresa, Long>{

	Optional<Empresa> findByCnpj(String cnpj);

	Optional<Empresa> findById(Long id);

}
