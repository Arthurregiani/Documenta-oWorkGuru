package com.workguru.domain.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vaga")
public class Vaga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String titulo;
	@NotNull
	@Enumerated
	private Tecnologia tecnologia;
	@NotNull
	private String descricao;
	@NotNull
	@Enumerated
	private Nivel nivel;
	@NotNull
	@Enumerated
	private Modelo modelo;
	@NotNull
	@Enumerated
	private Salario salario;
	@NotNull
	@Enumerated	
	private StatusVaga status;
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data_publicacao")
	private LocalDate dataPublicacao;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	@ManyToMany(fetch = FetchType.EAGER) // fetch = buscar - eager = ancioso
	@JoinTable(name = "vaga_pessoa", joinColumns = @JoinColumn(name = "vaga_id"), 
	inverseJoinColumns = @JoinColumn(name = "pessoa_id"))
	private List<Pessoa> pessoa;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Tecnologia getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public Salario getSalario() {
		return salario;
	}
	public void setSalario(Salario salario) {
		this.salario = salario;
	}
	public StatusVaga getStatus() {
		return status;
	}
	public void setStatus(StatusVaga status) {
		this.status = status;
	}
	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
		Vaga other = (Vaga) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
