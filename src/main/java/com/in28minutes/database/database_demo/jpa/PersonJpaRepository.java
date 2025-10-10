package com.in28minutes.database.database_demo.jpa;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.database_demo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

// Transactions are any type of updates, additions or deletions in the database. When multiple transactions are done simultaneously, we want all of them to succeed (and fail) together.
//Repository
//Transaction
@Repository
@Transactional
public class PersonJpaRepository {

	// Connect to the database. All operations take place inside the entity manager.
	@PersistenceContext
	EntityManager entityManager;

	// Standardized 'find' method inside entityManager. Search for an entity of the
	// specified class and primary key.If the entity instance is contained in the
	// persistence context,it is returned from there.
	public Person findById(int id) {
		return entityManager.find(Person.class, id); // JPA
	}

	// As far as an entityManager is concerned, there is no difference between
	// 'update' and 'insert'. Update: there is. In an ideal scenario, we should use
	// persist() for new objects, and merge() for updates. The persist() method
	// returns void, write it the same as delete.
	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}

	// The JPA mathod to delete a row is remove(), which returns void
	public void deleteById(int id) {
		var person = findById(id);
		entityManager.remove(person);
	}
	
	//JPQL to find all persons
	public List<Person> findAll() {
		var namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}

}
