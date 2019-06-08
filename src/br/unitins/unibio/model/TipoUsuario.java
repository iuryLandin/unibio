package br.unitins.unibio.model;

import java.util.Arrays;
import java.util.List;

public enum TipoUsuario {

	ADMINSTRADOR(0, "Adminstrador",
			Arrays.asList("home.xhtml", "cadastrousuario.xhtml", "cadastrocurso.xhtml", "cadastrodisciplina.xhtml",
					"cadastroevento.xhtml", "cadastroorgao.xhtml", "usuarios.xhtml", "relatorioregistro2.xhtml", "listagemcurso.xhtml", "relatorioregistro.xhtml")),

	PROFESSOR(1, "Professor", Arrays.asList("home.xhtml", "termoaceite.xhtml")),

	VISITANTE(2, "Visitante", Arrays.asList("home.xhtml") ),

	ALUNO(3, "Aluno", Arrays.asList("home.xhtml", "rtermodispo.xhtml", "termoaceite.xhtml",
			"termoresponsabilidade.xhtml", "registromanual.xhtml"));

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
