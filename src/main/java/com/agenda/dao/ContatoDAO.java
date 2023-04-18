package com.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.agenda.jpa.UtilJPA;
import com.agenda.models.Contato;

 

public class ContatoDAO extends GenericDAO<Contato>{
	public ContatoDAO() {
		super(Contato.class);
	}
	
	public List<Contato> findByCidade(String cidade){
		EntityManager em = UtilJPA.getFactory()
				.createEntityManager();
		String jpql = "SELECT c FROM Contato "
				+"WHERE c.cidade = :cidade";
		Query q = em.createQuery(jpql);
		q.setParameter("cidade", cidade);
		List<Contato> lista = q.getResultList();
		return lista;
	}
}
