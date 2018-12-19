package br.unitins.unibio.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.factory.JPAFactory;
import br.unitins.unibio.model.Pessoa;
import br.unitins.unibio.repository.PessoaRepository;


@Named
@RequestScoped
public class LoginController extends DefaultController {
	private static final long serialVersionUID = -2482810615603773001L;

	private Pessoa usuario;
	
	public String entrar() {
		PessoaRepository repository = 
				new PessoaRepository(JPAFactory.getEntityManager());
		Pessoa usuarioValidado = repository
				.getUsuarioLogin(getUsuario().getCpf(), getUsuario().getSenha());
		
		if (usuarioValidado == null) {
			Util.addErroMessage("Usuario ou Senha invalido.");
			return null;
		}
		// setando o usuario na sessao
		setUsuarioLogado(usuarioValidado);
		
		//return "pages/cadastroFuncionario.xhtml";
		
			Util.redirect("pages/cadastroaluno.xhtml");
		return "";
		
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
