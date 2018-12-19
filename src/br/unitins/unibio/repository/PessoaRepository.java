package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Pessoa;

public class PessoaRepository extends Repository<Pessoa> {

	public PessoaRepository(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoa(String nome) {
		Query query = getEntityManager()
				.createQuery("Select p From Pessoa p WHERE LOWER(p.nome) LIKE LOWER(:nome) Order by p.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Pessoa> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Pessoa>();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas() {
		Query query = getEntityManager()
				.createQuery("Select p From Pessoa p WHERE p.ativo = :ativo Order by p.nome");
		query.setParameter("ativo", true);
		List<Pessoa> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Pessoa>();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public Pessoa getUsuarioLogin(String cpf, String senha) {
		
		Query query = getEntityManager().
				createQuery("Select "
						  + "  f "
						  + "From "
						  + "  Pessoa f "
						  + "WHERE "
						  + "  f.cpf = :cpf AND "
						  + "  f.senha = :senha ");
		
		query.setParameter("cpf", cpf);
		query.setParameter("senha", Util.encrypt(senha));
		
		List<Pessoa> lista = query.getResultList();
		
		if (lista == null || lista.isEmpty())
			return null;
		
		return lista.get(0);
	}

}
