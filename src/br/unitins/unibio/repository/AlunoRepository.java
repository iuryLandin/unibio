package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Aluno;

public class AlunoRepository extends Repository<Aluno> {
	
	public AlunoRepository(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunos(String nome) {
		Query query = getEntityManager().
				createQuery("Select a From Aluno a WHERE LOWER(a.nome) LIKE LOWER(:nome) Order by a.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Aluno> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Aluno>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunos() {
		List<Aluno> lista = getEntityManager().
				createQuery("Select a From Aluno a Order by a.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Aluno>();
		return lista;
	}
}
