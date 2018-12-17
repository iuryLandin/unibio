package br.unitins.unibio.model;

import java.util.Arrays;
import java.util.List;

public enum Tipo {

	ADMINSTRADOR(0, "Adminstrador", Arrays.asList("entrada.xhtml", "entradaPF.xhtml")),
	ALUNO(1, "Aluno", Arrays.asList("entrada.xhtml", "servico.xhtml", "relatorio.xhtml")),
	PROFESSOR(2, "Professor", Arrays.asList("entrada.xhtml", "entradaPF.xhtml"));

	private int id;
	private String label;
	private List<String> pages;

	private Tipo(int id, String label, List<String> pages) {
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