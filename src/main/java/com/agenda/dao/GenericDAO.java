package com.agenda.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.agenda.jpa.UtilJPA;

public class GenericDAO<T> {
	private Class<T> obj;
	
	public GenericDAO(Class<T> obj) {
		this.obj = obj;
	}
	
	// Criação dos métodos crud genéricos
	public void create(T entity) {
		EntityManager em = UtilJPA.getFactory()
				.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.persist(entity);
		trx.commit();
		em.close();
	}
	
	public T read(Long id) {
		EntityManager em = UtilJPA.getFactory()
				.createEntityManager();
		T entity = em.find(obj, id);
		em.close();
		return entity;
	}
	
	public void update(T entity) {
		EntityManager em = UtilJPA.getFactory()
				.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.merge(entity);
		trx.commit();
		em.close();
		
	}
	
	public void delete(T entity) {
		EntityManager em = UtilJPA.getFactory()
				.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		em.remove(entity);
		trx.commit();
		em.close();
	}
}
