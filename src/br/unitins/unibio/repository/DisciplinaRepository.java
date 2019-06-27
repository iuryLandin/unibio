package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.model.Curso;
import br.unitins.unibio.model.Disciplina;
import br.unitins.unibio.model.Usuario;

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
	public List<Disciplina> getDisciplinaByUsuario(Usuario usuario) {
		Query query = getEntityManager().
				createNativeQuery("SELECT D.* " + 
						" FROM usuario AS U, disciplina AS D " + 
						" JOIN usuariodisciplina AS UD " + 
						" ON UD.idusuario = ? AND UD.iddisciplina = D.id WHERE U.id = UD.idusuario; ", Disciplina.class);
		query.setParameter(1, usuario.getId() );
		List<Disciplina> lista =  query.getResultList();
	 
		
		 System.out.println("\n\n \t\t\t Materia: " + lista.get(0).getNome() );
		
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
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> getDisciplinasPorCurso(Curso curso) {
		Query query = getEntityManager().
				createQuery("Select p From Disciplina p WHERE p.curso = :curso Order by p.nome");
		query.setParameter("curso", curso);
		List<Disciplina> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Disciplina>();
		return lista;
	}
}
