package br.unitins.unibio.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.unitins.unibio.model.Registro;

public class RegistroRepository extends Repository<Registro> {

	public RegistroRepository(EntityManager em) {
		super(em);
	}

 
	@SuppressWarnings("unchecked")
	public List<Registro> getRegistros() {
		List<Registro> lista = getEntityManager().createQuery("Select u From Registro u Order by u.id desc")
				.getResultList();
		if (lista == null)
			lista = new ArrayList<Registro>();
		return lista;
	}

}
