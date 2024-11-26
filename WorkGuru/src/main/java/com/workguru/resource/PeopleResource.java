package com.workguru.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workguru.domain.model.Pessoa;
import com.workguru.repository.PeopleRepository;
import com.workguru.repository.UserRepository;
import com.workguru.service.PeopleService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/people")
public class PeopleResource {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PeopleService peopleService;

	@GetMapping
	@PreAuthorize("hasAuthority('FUNCAO_PROCURAR_USUARIO') and hasAuthority('SCOPE_read')")
	public List<Pessoa> list(){
		return peopleService.findAllPeople();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('FUNCAO_REGISTRAR_USUARIO') and hasAuthority('SCOPE_write')")
	public Pessoa create(@Valid @RequestBody Pessoa people, HttpServletResponse response) {
		return peopleRepository.save(people);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('FUNCAO_PROCURAR_USUARIO') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Pessoa> findById(@PathVariable Long id){
		Optional<Pessoa> people = peopleRepository.findById(id);
		if(people.isPresent()) {
			return ResponseEntity.ok(people.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('FUNCAO_DELETAR_USUARIO') and hasAuthority('SCOPE_write')")
	public void remove(@PathVariable Long id) {
		peopleRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('FUNCAO_REGISTRAR_USUARIO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @Valid @RequestBody Pessoa people) {
		Pessoa peopleSaved = peopleService.update(id, people);
		return ResponseEntity.ok(peopleSaved);
	}
}
