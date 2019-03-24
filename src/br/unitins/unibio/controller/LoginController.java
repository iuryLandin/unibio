package br.unitins.unibio.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.factory.JPAFactory;
import br.unitins.unibio.model.Usuario;
import br.unitins.unibio.repository.UsuarioRepository;


@Named
@RequestScoped
public class LoginController extends DefaultController {
	private static final long serialVersionUID = -2482810615603773001L;

	private Usuario usuario;
	
	public String entrar() {
		UsuarioRepository repository = 
				new UsuarioRepository(JPAFactory.getEntityManager());
		Usuario usuarioValidado = repository
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

	public Usuario getUsuario() {
		if (usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
