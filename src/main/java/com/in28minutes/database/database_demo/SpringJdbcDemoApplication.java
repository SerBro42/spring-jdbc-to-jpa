package com.in28minutes.database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.database_demo.entity.Person;
import com.in28minutes.database.database_demo.jdbc.PersonJdbcDao;

//CommandLineRunner allows to launch stuff as soon as the applicationContext is ready. It is 
//used in place of instantiating local variables for applicationContext.
// We comment out the @SpringBootApplication so that it doesn't get scanned by component scan.
//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("All users from Orxeta -> {}", dao.findByLocation("Orxeta"));
		logger.info("All users containing 'epe' in their name -> {}", dao.findByName(" epe"));
		logger.info("Deleting 10002 -> {}", dao.deleteById(10002));
		logger.info("Inserting 10006 -> {}", 
				dao.insert(new Person(10006, "Alicia", "Wonderland", new Date())));
		logger.info("Updating 10003 -> {}", 
				dao.update(new Person(10003, "Ignacio", "Bilbao", new Date())));

	}

}
