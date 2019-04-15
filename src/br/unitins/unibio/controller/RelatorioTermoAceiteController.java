package br.unitins.unibio.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Usuario;

@Named
@ViewScoped
public class RelatorioTermoAceiteController extends Controller<Usuario> {
	
	public RelatorioTermoAceiteController() {
		super(null);
		pesquisar();
	}

	private static final long serialVersionUID = -256630175017636901L;


	public void pesquisar() {
		// listaCidade = null;
	}

	public void imprimir() {
		Util.redirect("/UniBio/TermoAceite?USUARIO_CPF=" + getCpf());
	}

	public String getCpf() {
		return getUsuarioLogado().getCpf();
	}

	@Override
	public Usuario getEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}

}
