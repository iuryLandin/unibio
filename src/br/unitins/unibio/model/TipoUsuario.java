package br.unitins.unibio.model;

import java.util.Arrays;
import java.util.List;

public enum TipoUsuario {
	
	ADMINSTRADOR(0, "Adminstrador", 
			Arrays.asList("cadastrousuario.xhtml","cadastrocurso.xhtml","cadastrodisciplina.xhtml","relatoriogeral.xhtml")),
	PROFESSOR(1, "Professor", Arrays.asList("relatoriogeral.xtml")),
	VISITANTE(2, "Visitante", Arrays.asList("")),
	ALUNO(3, "Aluno", Arrays.asList(""));
	
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
