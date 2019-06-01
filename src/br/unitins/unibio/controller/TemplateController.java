package br.unitins.unibio.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Usuario;

@Named
@ViewScoped
public class TemplateController extends DefaultController {

	private static final long serialVersionUID = 3315885899410185656L;

	
	public String getTemplate() {
		String tipoUsuario = getUsuarioLogado().getTipoUsuario().getLabel();
		
		return "../template" + tipoUsuario + ".xhtml";
	}
	
	public String getPageTitle() {
		return "UniBio | Área do " + getUsuarioLogado().getTipoUsuario().getLabel();
	}
	
}
