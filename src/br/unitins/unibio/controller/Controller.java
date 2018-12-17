package br.unitins.unibio.controller;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;

import br.unitins.unibio.application.Util;
import br.unitins.unibio.application.ValidationException;
import br.unitins.unibio.factory.JPAFactory;
import br.unitins.unibio.model.DefaultEntity;
import br.unitins.unibio.repository.Repository;
import br.unitins.unibio.validation.Validation;

public abstract class Controller<T extends DefaultEntity<? super T>> extends DefaultController {

	private static final long serialVersionUID = -4443993026542854493L;

	private Validation<T> validation = null;
	
	private EntityManager em = null;
	
	protected T entity = null;
	
	public abstract T getEntity();
	
	public Controller(Validation<T> validation) {
		this.validation = validation;
	}
	
	public Validation<T> getValidation() {
		return validation;
	}
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	protected EntityManager getEntityManager() {
		if (em == null)
			em = JPAFactory.getEntityManager();
		return em;
	}
	
	public abstract void limpar();
	
	public T incluir() {
		
		try {
			if (getValidation() !=null)
				getValidation().validate(getEntity());
		} catch (ValidationException e) {
			Util.addErroMessage(e.getMessage());
			return null;
		}
		
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// incluir 
		T result = repository.save(getEntity());
		
		getEntityManager().getTransaction().commit();
		limpar();
		Util.addInfoMessage("Inclus�o realizada com sucesso!");
		return result;
	}
	
	public T alterar() {
		try {
			if (getValidation() !=null)
				getValidation().validate(getEntity());
	
			Repository<T> repository = new Repository<T>(getEntityManager());
			getEntityManager().getTransaction().begin();
			
			// alterar 
			T result = repository.save(getEntity());
			
			getEntityManager().getTransaction().commit();
			limpar();
			Util.addInfoMessage("Registro alterado com sucesso!");
			return result;
		} catch (OptimisticLockException exception) {
			// capiturando a excecao do version
			Util.addInfoMessage("Erro de concorrencia. - Este registro foi atualizado por outro usu�rio. Selecione o registro novamente e tente edi");
			return null;
		} catch (ValidationException e) {
			Util.addErroMessage(e.getMessage());
			return null;
		}
	}
	
	public void remover() {
		Repository<T> repository = new Repository<T>(getEntityManager());
		getEntityManager().getTransaction().begin();
		
		// remover 
		repository.save(getEntity());
		repository.remove(getEntity());
		
		getEntityManager().getTransaction().commit();
		limpar();
		Util.addInfoMessage("Registro apagado!");
	}
}
