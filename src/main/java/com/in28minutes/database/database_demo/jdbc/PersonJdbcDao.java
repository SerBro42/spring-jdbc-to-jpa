package com.in28minutes.database.database_demo.jdbc;

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
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper(Person.class));
	}

}
