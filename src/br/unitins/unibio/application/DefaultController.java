package br.unitins.unibio.application;

import java.io.Serializable;

import br.unitins.unibio.application.Session;
import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Pessoa;
import br.unitins.unibio.validation.Validation;

public class DefaultController implements Serializable {

	private static final long serialVersionUID = 1007297527954376818L;
	
	private static final String userKey = "usuarioLogado";
	
	public Pessoa getUsuarioLogado() {
		return (Pessoa) Session.getInstance().getAttribute(userKey);
	}

	public void setUsuarioLogado(Pessoa usuario) {
		Session.getInstance().setAttribute(userKey, usuario);
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("login.xhtml");
	}
	
}
