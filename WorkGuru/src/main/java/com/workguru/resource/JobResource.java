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

import com.workguru.domain.model.Vaga;
import com.workguru.repository.JobRepository;
import com.workguru.service.JobService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobResource {

	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private JobService jobService;	
	
	@GetMapping
	@PreAuthorize("hasAuthority('FUNCAO_PROCURAR_VAGA') and hasAuthority('SCOPE_read')")
	public List<Vaga> list(){
		return jobRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('FUNCAO_PROCURAR_VAGA') and hasAuthority('SCOPE_read')")
	public ResponseEntity<Vaga> findById(@PathVariable Long id) {
		Optional<Vaga> job = jobRepository.findById(id);
		if(job.isPresent()) {
			return ResponseEntity.ok(job.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('FUNCAO_REGISTRAR_VAGA') and hasAuthority('SCOPE_write')")
	public Vaga create(@Valid @RequestBody Vaga job) {
		return jobService.save(job);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('FUNCAO_DELETAR_VAGA') and hasAuthority('SCOPE_write')")
	public void delete(@PathVariable Long id) {
		jobRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('FUNCAO_REGISTRAR_VAGA') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Vaga> update(@PathVariable Long id, @Valid @RequestBody Vaga job) {
		Vaga activitySaved = jobService.update(id, job);
		return ResponseEntity.ok(activitySaved);
	}
}