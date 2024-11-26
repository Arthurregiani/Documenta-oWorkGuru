package com.workguru.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.workguru.domain.model.Pessoa;
import com.workguru.repository.PeopleRepository;
import com.workguru.repository.UserRepository;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Pessoa update(Long id, Pessoa people) {
		Pessoa peopleSaved = findPeopleById(id);
		BeanUtils.copyProperties(people, peopleSaved, "id");
		return peopleRepository.save(peopleSaved);
	}
	
	public Pessoa findPeopleById(Long id) {
		Pessoa enterpriseSaved = peopleRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return enterpriseSaved;
	}
	
	public List<Pessoa> findAllPeople(){
		return userRepository.findByTipoUsuario("P");
	}
	

}
