package com.in28minutes.database.database_demo.jdbc;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.database_demo.entity.Person;

//The DAO maps the data and returns an object that we can work with
@Repository
public class PersonJdbcDao {

	// JdbcTemplate is a resource used in Spring that gives the database connection
	@Autowired
	JdbcTemplate jdbcTemplate;

	// This method executes a SQL query using the Person class. We map the SQL query
	// to the person class (bean)
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
	}

	// 'query()' is used to return all. 'queryForObject()' is used to search for a
	// particular object
	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new BeanPropertyRowMapper<>(Person.class),
				id);
	}

	public List<Person> findByLocation(String location) {
		return jdbcTemplate.query("select * from person where location=?", new BeanPropertyRowMapper<>(Person.class),
				location);
	}

	// Search for all persons who's name contains the string that is passed as a
	// parameter, including good practices
	public List<Person> findByName(String name) {
		if (name == null || name.isBlank()) {
			return Collections.emptyList();
		}

		var sql = "select * from person where name like ?";
		var pattern = "%" + name.trim() + "%";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Person.class), pattern);
	}

}
