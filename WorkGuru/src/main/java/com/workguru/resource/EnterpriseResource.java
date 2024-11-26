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

import com.workguru.domain.model.Empresa;
import com.workguru.repository.EnterpriseRepository;
import com.workguru.service.EnterpriseService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseResource {
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private EnterpriseService enterpriseService;

	@GetMapping
	@PreAuthorize("hasAuthority('FUNCAO_PROCURAR_USUARIO') and hasAuthority('SCOPE_read')")
	public List<Empresa> list(){
		return enterpriseRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('FUNCAO_REGISTRAR_USUARIO') and hasAuthority('SCOPE_write')")
	public Empresa create(@Valid @RequestBody Empresa enterprise, HttpServletResponse response) {
		return enterpriseRepository.save(enterprise);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('FUNCAO_PROCURAR_USUARIO') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Empresa> findById(@PathVariable Long id){
		Optional<Empresa> enterprise = enterpriseRepository.findById(id);
		if(enterprise.isPresent()) {
			return ResponseEntity.ok(enterprise.get());
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('FUNCAO_DELETAR_USUARIO') and hasAuthority('SCOPE_write')")
	public void remove(@PathVariable Long id) {
		enterpriseRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('FUNCAO_REGISTRAR_USUARIO') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Empresa> update(@PathVariable Long id, @Valid @RequestBody Empresa enterprise) {
		Empresa userSaved = enterpriseService.update(id, enterprise);
		return ResponseEntity.ok(userSaved);
	}
}