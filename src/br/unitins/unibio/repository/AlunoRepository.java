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
				createQuery("Select p From Aluno p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Aluno> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Aluno>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunos() {
		List<Aluno> lista = getEntityManager().
				createQuery("Select p From Aluno p Order by p.id desc").getResultList();
			if (lista == null)
				lista = new ArrayList<Aluno>();
		return lista;
	}
}
