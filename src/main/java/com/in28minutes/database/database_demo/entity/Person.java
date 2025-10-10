package com.in28minutes.database.database_demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// We start implementing JPA. Fist of all, we declare this class as an @Entity, that has a corresponding table in the DB.
// It is possible that the name of tha table doesn't match. In such cases, we'd add @Table(name="person") annotation.
@Entity
public class Person {

	// In a similar manner to the Entity name, the column name may not match the
	// attribute name. In this case, we'd use @Column(name="name").
	// The @Id is mandatory to set the primary key.
	// With the @GeneratedValue annotation, the Id attribute is generated
	// automatically, instead of having to do it manually.
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String location;
	private Date birthDate;

	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	// Since JPA allows us to autogenerate an ID value, we need another constructor
	// that doesn't pass the ID.
	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	// Whenever we use BeanPropertyRowMapper, there must be a no argument
	// constructor avalable in the class for it to work. Usually, Java provides such
	// constructor by default, but since we defined another constructor in this
	// class, the no-argument constructor is no longer available if not defined
	// explicitly.
	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	// Without the toString method, every Person object returned from the database
	// will have a unique hash code, instead displaying the details. With this
	// method present, all data are displayed, and every one starting on a new line.
	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}

}
