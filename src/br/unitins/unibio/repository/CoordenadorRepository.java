package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Coordenador;

public class CoordenadorRepository extends Repository<Coordenador> {
	
	public CoordenadorRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Coordenador> getCoordenadores(String nome) {
		Query query = getEntityManager().
				createQuery("Select c From Coordenador c WHERE LOWER(c.nome) LIKE LOWER(:nome) Order by c.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Coordenador> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Coordenador>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Coordenador> getCoordenadores() {
		List<Coordenador> lista = getEntityManager().
				createQuery("Select c From Coordenador c Order by c.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Coordenador>();
		return lista;
	}
}
