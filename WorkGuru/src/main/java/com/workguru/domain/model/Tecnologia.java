package com.workguru.domain.model;

public enum Tecnologia {

	JAVA("Java"),
	PYTHON("Python"),
	JAVASCRIPT("JavaScript"),
	HTML5("HTML5"),
	CSS3("CSS3"),
	TYPESCRIPT("TypeScript");
	
	private String tecnologia;
	
	private Tecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	
	public String getTecnologia() {
		return tecnologia;
	}
}
