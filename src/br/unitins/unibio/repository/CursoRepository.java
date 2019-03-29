package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Curso;

public class CursoRepository extends Repository<Curso> {
	
	public CursoRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> getCursos(String nome) {
		Query query = getEntityManager().
				createQuery("Select c From Curso c WHERE LOWER(c.nome) LIKE LOWER(:nome) Order by c.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Curso> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Curso>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> getCursos() {
		List<Curso> lista = getEntityManager(). 
				createQuery("Select c From Curso c Order by c.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Curso>();
		return lista;
	}
}
