package com.workguru.domain.model;

public enum StatusVaga {
	
	ABERTA("Aberta"),
	EM_ANDAMENTO("Em andamento"),
	FECHADA("Fechada");
	
	private String status;
	
	private StatusVaga(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}
