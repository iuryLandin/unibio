package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import br.unitins.unibio.model.Atividade;

public class AtividadeController extends Controller<Atividade> {

	private static final long serialVersionUID = 9223098141383517807L;
	
	private List<Atividade> listaAtividade = null;

	public AtividadeController() {
		super(null);
	}

	@Override
	public Atividade incluir() {

		return super.incluir();
	}

	@Override
	public Atividade alterar() {

		return super.alterar();
	}

	@Override
	public Atividade getEntity() {
		if (entity == null)
			entity = new Atividade();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
	}
	
	public void pesquisar() {
		
	}

	public List<Atividade> getListaAtividade() {
		if(listaAtividade == null)
			listaAtividade = new ArrayList<Atividade>();
		return listaAtividade;
	}

	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}
	
	

}
