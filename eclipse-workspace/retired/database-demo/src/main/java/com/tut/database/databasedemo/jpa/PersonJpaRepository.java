package com.tut.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.tut.database.databasedemo.bean.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findByID(int ID) {
		return entityManager.find(Person.class, ID);
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	public void delete(int ID) {
		Person person = findByID(ID);
		entityManager.remove(person);
	}

	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

}
