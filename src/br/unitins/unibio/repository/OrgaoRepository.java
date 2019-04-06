package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Orgao;

public class OrgaoRepository extends Repository<Orgao> {

	public OrgaoRepository(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Orgao> getOrgaos(String nome) {
		Query query = getEntityManager()
				.createQuery("Select u From Orgao u WHERE LOWER(u.nome) LIKE LOWER(:nome) Order by u.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Orgao> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Orgao>();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Orgao> getOrgaos() {
		List<Orgao> lista = getEntityManager().createQuery("Select u From Orgao u Order by u.id desc")
				.getResultList();
		if (lista == null)
			lista = new ArrayList<Orgao>();
		return lista;
	}

}
