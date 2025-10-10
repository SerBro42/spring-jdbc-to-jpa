package com.in28minutes.database.database_demo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.database.database_demo.entity.Person;

// We create this interface with the sole purpose of using it for Sring Data JPA. It doesn't require additional methods, it has its own.
public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
