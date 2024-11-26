package com.workguru.domain.model;

public enum StatusPessoa {

	TRABALHANDO("Trabalhando"),
	TRABALHANDO_MAS_ACEITO_OFERTAS("Trabalhando mas aceito ofertas"),
	SEM_EMPREGO("Sem emprego");
	
	private String statusPessoa;
	
	private StatusPessoa(String statusPessoa) {
		this.statusPessoa = statusPessoa;
	}
	
	public String getStatusPessoa() {
		return statusPessoa;
	}
}
