package com.workguru.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "formacao")
public class Formacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(name = "nome_instituicao")
	@Size(min = 3, max = 45)
	private String nomeInstituicao;
	private String curso;
	@NotNull
	@Enumerated
	private Grau grau;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "periodo_inicio")
	private LocalDate periodoInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "periodo_fim")
	private LocalDate periodoFim;
	@NotNull
	@JoinColumn(name = "pessoa_id")
	@ManyToOne
	private Pessoa pessoa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Grau getGrau() {
		return grau;
	}
	public void setGrau(Grau grau) {
		this.grau = grau;
	}
	public LocalDate getPeriodoInicio() {
		return periodoInicio;
	}
	public void setPeriodoInicio(LocalDate periodoInicio) {
		this.periodoInicio = periodoInicio;
	}
	public LocalDate getPeriodoFim() {
		return periodoFim;
	}
	public void setPeriodoFim(LocalDate periodoFim) {
		this.periodoFim = periodoFim;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formacao other = (Formacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
