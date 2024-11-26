package com.workguru.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workguru.domain.model.Empresa;
import com.workguru.domain.model.Vaga;
import com.workguru.repository.EnterpriseRepository;
import com.workguru.repository.JobRepository;
import com.workguru.service.exception.NonExistentUserException;


@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	
	public Vaga save(Vaga vaga) {
		Optional<Empresa> enterprise = enterpriseRepository.findById(vaga.getEmpresa().getId());
		if(!enterprise.isPresent()) {
			throw new NonExistentUserException();
		}
		return jobRepository.save(vaga);
	}
	
	public Vaga update(Long id, Vaga vaga) {
		Vaga jobSaved = findJobById(id);
		BeanUtils.copyProperties(vaga, jobSaved, "id");
		return jobRepository.save(jobSaved);
	}
	
	public Vaga findJobById(Long id) {
		Vaga jobSaved = jobRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return jobSaved;
	}
	
	public List<Vaga> findJobsByEnterprise(Empresa empresa) {		
		return  jobRepository.findJobsByEmpresa(empresa);
	}
	
	
	
}
