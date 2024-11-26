package com.workguru.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workguru.domain.model.Empresa;
import com.workguru.domain.model.Vaga;
import com.workguru.repository.EnterpriseRepository;


@Service
public class EnterpriseService {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	public Empresa update(Long id, Empresa enterprise) {
		Empresa enterpriseSaved = findEnterpriseById(id);
		BeanUtils.copyProperties(enterprise, enterpriseSaved, "id");
		return enterpriseRepository.save(enterpriseSaved);
	}
	
	public Empresa findEnterpriseById(Long id) {
		Empresa enterpriseSaved = enterpriseRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return enterpriseSaved;
	}
	
	

}
