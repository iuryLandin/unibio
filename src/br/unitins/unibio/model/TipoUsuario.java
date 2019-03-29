package br.unitins.unibio.model;

import java.util.Arrays;
import java.util.List;

public enum TipoUsuario {
	
	ADMINSTRADOR(0, "Adminstrador", 
			Arrays.asList("cadastrousuario.xhtml","cadastrocurso.xhtml","cadastrodisciplina.xhtml","relatoriogeral.xhtml")),
	PROFESSOR(1, "Professor", Arrays.asList("relatoriogeral.xtml")),
	VISITANTE(1, "VISITANTE", Arrays.asList("")),
	ALUNO(1, "Aluno", Arrays.asList(""));
	
	private int id;
	private String label;
	private List<String> pages;
	
	private TipoUsuario(int id, String label, List<String> pages) {
		this.id = id;
		this.label = label;
		this.pages = pages;
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}

	public List<String> getPages() {
		return pages;
	}
	
}
