package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Evento;

public class EventoRepository extends Repository<Evento> {
	
	public EventoRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> getEventos(String nome) {
		Query query = getEntityManager().
				createQuery("Select e From Evento e WHERE LOWER(e.nome) LIKE LOWER(:nome) Order by e.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Evento> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Evento>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Evento> getEventos() {
		List<Evento> lista = getEntityManager(). 
				createQuery("Select e From Evento e Order by e.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Evento>();
		return lista;
	}
}
