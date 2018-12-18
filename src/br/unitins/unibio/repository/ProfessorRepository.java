package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Professor;

public class ProfessorRepository extends Repository<Professor> {
	
	public ProfessorRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> getProfessores(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From Professor p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Professor> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Professor>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Professor> getProfessores() {
		List<Professor> lista = getEntityManager().
				createQuery("Select p From Professor p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Professor>();
		return lista;
	}
}
