package com.solution.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Test;

import com.solution.jpa.dao.GenericDao;
import com.solution.jpa.entity.AddressEntity;
import com.solution.jpa.entity.PersonEntity;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class GenericDaoTest {

	@Test
	@Ignore
	public void createEntityManagerFactory() {
		GenericDao genericDao = GenericDao.getInstance();
		EntityManagerFactory factory = genericDao.getFactory();
		EntityManager entityManager = factory.createEntityManager();

		PersonEntity person = new PersonEntity();
		person.setId(1L);
		person.setName("Naveen");
		genericDao.persist(person);

		AddressEntity address1 = new AddressEntity();
		address1.setId(1L);
		address1.setAddress1("Delhi");
		address1.setPerson(person);

		AddressEntity address2 = new AddressEntity();
		address2.setId(2L);
		address2.setAddress1("Noida");
		address2.setPerson(person);

		genericDao.persist(address1);
		genericDao.persist(address2);
		System.out.println("Entity Manager >>> " + entityManager);
	}

	@Test
	public void findPerson() {
		GenericDao genericDao = GenericDao.getInstance();
		PersonEntity person = (PersonEntity) genericDao.findById(PersonEntity.class, 1L);
		System.out.println("Person >>> " + person);
	}

}
