package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Disciplina;

public class DisciplinaRepository extends Repository<Disciplina> {
	
	public DisciplinaRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> getDisciplinas(String nome) {
		Query query = getEntityManager().
				createQuery("Select p From Disciplina p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Disciplina> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Disciplina>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> getDisciplinas() {
		List<Disciplina> lista = getEntityManager().
				createQuery("Select p From Disciplina p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Disciplina>();
		return lista;
	}
}
