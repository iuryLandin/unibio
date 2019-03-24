package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	public UsuarioRepository(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios(String nome) {
		Query query = getEntityManager()
				.createQuery("Select u From Usuario u WHERE LOWER(u.nome) LIKE LOWER(:nome) Order by u.nome");
		query.setParameter("nome", "%" + nome + "%");
		List<Usuario> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Usuario>();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		List<Usuario> lista = getEntityManager().createQuery("Select u From Usuario u Order by u.id desc")
				.getResultList();
		if (lista == null)
			lista = new ArrayList<Usuario>();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarioByType(String tipoUsuario) {
		Query query = getEntityManager().createQuery(
				"Select u From Usuario u WHERE LOWER(u.tipoUsuario) LIKE LOWER(:tipoUsuario) Order by u.nome desc");
		query.setParameter("tipoUsuario", "%" + tipoUsuario + "%");
		List<Usuario> lista = query.getResultList();

		if (lista == null)
			lista = new ArrayList<Usuario>();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public Usuario getUsuarioLogin(String cpf, String senha) {

		Query query = getEntityManager().createQuery("Select " + "  u " + "From " + "  Pessoa u " + "WHERE "
				+ "  u.cpf = :cpf AND " + "  u.senha = :senha ");

		query.setParameter("cpf", cpf);
		query.setParameter("senha", Util.encrypt(senha));

		List<Usuario> lista = query.getResultList();

		if (lista == null || lista.isEmpty())
			return null;

		return lista.get(0);
	}
}
