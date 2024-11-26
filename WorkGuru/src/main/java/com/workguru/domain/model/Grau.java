package com.workguru.domain.model;

public enum Grau {

		BACHARELADO("Bacharelado"),
		LICENCIATURA("Licenciatura"),
		TECNOLOGO("Tecnólogo"),
		MESTRADO("Mestrado"),
		DOUTORADO("Doutorado"),
		POS_DOUTORADO("Pós-doutorado"),
		TECNICO("Técnico"),
		ENSINO_MEDIO("Ensino médio");
	
	private String grau;
	
	private Grau(String grau) {
		this.grau = grau;
	}
	
	public String getGrau() {
		return grau;
	}
}
