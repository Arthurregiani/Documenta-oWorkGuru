package com.workguru.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "historico_profissional")
public class HistoricoProfissional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "periodo_inicio")
	private LocalDate periodoInicio;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "periodo_fim")
	private LocalDate periodoFim;
	@NotNull
	private String cargo;
	private String descricao;
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		HistoricoProfissional other = (HistoricoProfissional) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
