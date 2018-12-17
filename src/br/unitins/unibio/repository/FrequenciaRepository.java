package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Frequencia;

public class FrequenciaRepository extends Repository<Frequencia> {
	
	public FrequenciaRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Frequencia> getFrenquecias(String nome) {
		Query query = getEntityManager().
				createQuery("Select a From Frenquecia a WHERE LOWER(a.nome) LIKE LOWER(:nome) Order by a.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Frequencia> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Frequencia>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Frequencia> getFrenquecias() {
		List<Frequencia> lista = getEntityManager().
				createQuery("Select a From Frenquecia a Order by a.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Frequencia>();
		return lista;
	}
}
