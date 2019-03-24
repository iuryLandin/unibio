package br.unitins.unibio.controller;

import java.io.Serializable;

import br.unitins.unibio.application.Session;
import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Usuario;

public class DefaultController implements Serializable {

	private static final long serialVersionUID = -5325627003084805643L;
	private static final String userKey = "usuarioLogado";
	
	public Usuario getUsuarioLogado() {
		return (Usuario) Session.getInstance().getAttribute(userKey);
	}

	public void setUsuarioLogado(Usuario usuario) {
		Session.getInstance().setAttribute(userKey, usuario);
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("login.xhtml");
	}
	
}
