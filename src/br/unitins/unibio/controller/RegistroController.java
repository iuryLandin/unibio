package br.unitins.unibio.controller;

import java.util.ArrayList;

import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Registro;
import br.unitins.unibio.repository.RegistroRepository;
import br.unitins.unibio.application.Util;

@Named
@ViewScoped
public class RegistroController extends Controller<Registro> {

	private static final long serialVersionUID = -2275796299294713882L;

	public RegistroController() {
		super(null);
	}

	private String pesquisa;
	private List<Registro> listaRegistro = null;
 

	@Override
	public Registro incluir() {
		
		String data = Util.getData();
		String dia = Util.getDia();
		String hora = Util.getHora();
		
		getEntity().setData(data);
		getEntity().setDia(dia);
		getEntity().setHora(hora);
		getEntity().setTipo(2);
		getEntity().setUsuario(getUsuarioLogado());
		
		
		return super.incluir();
	}

	@Override
	public Registro alterar() {
		return super.alterar();
	}

	@Override
	public Registro getEntity() {
		if (entity == null)
			entity = new Registro();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaRegistro = null;
	}

	public List<Registro> getListaRegistro() {
		if (listaRegistro == null)
			listaRegistro = new ArrayList<Registro>();
		return listaRegistro;
	}

	public void pesquisar() {
		RegistroRepository repository = new RegistroRepository(getEntityManager());
		listaRegistro = repository.getRegistros();
	}

 

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

}
