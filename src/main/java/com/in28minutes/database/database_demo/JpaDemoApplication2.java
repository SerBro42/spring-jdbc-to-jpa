package com.in28minutes.database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.in28minutes.database.database_demo.entity.Person;
import com.in28minutes.database.database_demo.jpa.PersonJpaRepository;

// New Main class specifically for JPA functionality
@SpringBootApplication
public class JpaDemoApplication2 implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication2.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
//		logger.info("All users -> {}", dao.findAll());
//		logger.info("All users from Orxeta -> {}", dao.findByLocation("Orxeta"));
//		logger.info("All users containing 'epe' in their name -> {}", dao.findByName(" epe"));
//		logger.info("Deleting 10002 -> {}", dao.deleteById(10002));
//		logger.info("Inserting 10006 -> {}", 
//				dao.insert(new Person(10006, "Alicia", "Wonderland", new Date())));
//		logger.info("Updating 10003 -> {}", 
//				dao.update(new Person(10003, "Ignacio", "Bilbao", new Date())));

	}

}
