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
				createQuery("Select p From Curso p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Curso> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Curso>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> getCursos() {
		List<Curso> lista = getEntityManager().
				createQuery("Select p From Curso p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Curso>();
		return lista;
	}
}
