package br.unitins.unibio.controller;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.factory.JPAFactory;
import br.unitins.unibio.model.Pessoa;
import br.unitins.unibio.repository.PessoaRepository;


@Named
@RequestScoped
public class LoginController extends DefaultController{

	private static final long serialVersionUID = 1402543109102453042L;
	
	private Pessoa usuario;
	
	public String entrar() {
		PessoaRepository repository = 
				new PessoaRepository(JPAFactory.getEntityManager());
		Pessoa usuarioValidado = repository
				.getUsuario(getUsuario().getCpf(), getUsuario().getSenha());
		
		if (usuarioValidado == null) {
			Util.addErroMessage("Usuário ou Senha inválido.");
			return null;
		}
		// setando o usuario na sessao
		setUsuarioLogado(usuarioValidado);
		
		return "pages/home.xhtml";
	}
	
	public Pessoa getUsuario() {
		if (usuario == null)
			usuario = new Pessoa();
		return usuario;
	}

	public void setUsuario(Pessoa usuario) {
		this.usuario = usuario;
	}
}
