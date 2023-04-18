package com.agenda.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.agenda.jpa.UtilJPA;
import com.agenda.models.Tarefa;

public class TarefaDAO extends GenericDAO<Tarefa> {
	
	public TarefaDAO() {
		super(Tarefa.class);
	}
	
	public List<Tarefa> findByCompleto(boolean completo){
		EntityManager em = UtilJPA.getFactory()
				.createEntityManager();
		String jpql = "SELECT t from Tarefa "
				+"WHERE t.completo = :completo";
		Query q = em.createQuery(jpql);
		q.setParameter("completo", completo);
		
		List<Tarefa> tarefas = q.getResultList();
		return tarefas;
	}
}
