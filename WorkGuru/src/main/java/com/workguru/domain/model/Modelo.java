package com.workguru.domain.model;

public enum Modelo {

	HIBRIDO("Híbrido"),
	PRESENCIAL("Presencial"),
	HOME_OFFICE("Home Office");
	
	private String modelo;
	
	private Modelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}
}
