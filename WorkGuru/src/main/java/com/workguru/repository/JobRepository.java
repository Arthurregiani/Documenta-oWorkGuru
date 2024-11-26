package com.workguru.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workguru.domain.model.Empresa;
import com.workguru.domain.model.Vaga;

public interface JobRepository extends JpaRepository<Vaga, Long>{

	List<Vaga> findJobsByEmpresa(Empresa empresa);


}
