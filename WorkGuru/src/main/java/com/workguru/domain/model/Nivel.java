package com.workguru.domain.model;

public enum Nivel {

	JUNIOR("Júnior"),
	SENIOR("Sênior"),
	PLENO("Pleno"),
	ESTAGIO("Estágio"),
	TREINEE("Treinee");
	
	private String nivel;
	
	private Nivel(String nivel) {
		this.nivel = nivel;
	}
	
	public String getNivel() {
		return nivel;
	}
}
