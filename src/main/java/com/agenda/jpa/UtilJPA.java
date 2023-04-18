package com.agenda.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
	private static EntityManagerFactory emf;
	private static final String NAME_PU = "PU";
	
	public static EntityManagerFactory getFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory(NAME_PU);
		}
		return emf;
	}
	
	public static void close() {
		if(emf != null) {
			emf.close();
		}
	}
	
	
}
