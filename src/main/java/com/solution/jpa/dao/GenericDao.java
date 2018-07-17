package com.solution.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDao {

	private EntityManagerFactory factory;

	private static GenericDao instance = null;

	private GenericDao() {
		factory = Persistence.createEntityManagerFactory("JPAServices");
	}

	public static GenericDao getInstance() {
		if (instance == null) {
			instance = new GenericDao();
		}
		return instance;
	}

	public void persist(Object obj) {
		EntityManager em = getFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public EntityManagerFactory getFactory() {
		return factory;
	}
}
