package com.in28minutes.database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.database_demo.entity.Person;
import com.in28minutes.database.database_demo.springdata.PersonSpringDataRepository;

// New Main class specifically for JPA functionality
@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	// In Spring Data, the method findById exists. But insert and update don't.
	// Instead, we use save()
	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));

		logger.info("Inserting -> {}", repository.save(new Person("Alicia", "Wonderland", new Date())));

		logger.info("Updating 10003 -> {}", repository.save(new Person(10003, "Jazmine", "Agrabah", new Date())));
		// We cannot use logger here, because it's a void method
		repository.deleteById(10002);
		logger.info("All users -> {}", repository.findAll());

//		logger.info("All users from Orxeta -> {}", dao.findByLocation("Orxeta"));
//		logger.info("All users containing 'epe' in their name -> {}", dao.findByName(" epe"));

	}

}
