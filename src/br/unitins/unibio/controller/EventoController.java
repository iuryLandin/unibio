package br.unitins.unibio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.unibio.model.Evento;
import br.unitins.unibio.repository.EventoRepository;

@Named
@ViewScoped
public class EventoController extends Controller<Evento> {
 
	private static final long serialVersionUID = 918956409094412421L;


	public EventoController() {
		super(null);
	}
	
	private String pesquisa;
	private List<Evento> listaEvento = null;
	

	@Override
	public Evento getEntity() {
		if(entity == null)
			entity = new Evento();
		return entity;
	}

	@Override
	public void limpar() {
		setEntity(null);
		listaEvento = null;
	}
	

	public List<Evento> getListaEvento() {
		if (listaEvento == null)
			listaEvento = new ArrayList<Evento>();
		return listaEvento;
	}
	
	public void pesquisar() {
		EventoRepository repository = new EventoRepository(getEntityManager());
		listaEvento = repository.getEventos(pesquisa);
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	
}
