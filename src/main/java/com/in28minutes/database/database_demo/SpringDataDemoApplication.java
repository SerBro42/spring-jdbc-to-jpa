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
		logger.info("User id 10001 -> {}", repository.findById(1));

		logger.info("Inserting -> {}", repository.save(new Person("Alicia", "Wonderland", new Date())));

        repository.findById(3).ifPresentOrElse(person -> {
            person.setName("Jazmine");
            person.setLocation("Agrabah");
            person.setBirthDate(new Date());
            Person updated = repository.save(person);
            logger.info("Updating 10003 -> {}", updated);
        }, () -> {
            // If the entity doesn't exist, create it
            Person created = repository.save(new Person("Jazmine", "Agrabah", new Date()));
            logger.info("Created 10003 -> {}", created);
        });		
        // We cannot use logger here, because it's a void method
		repository.deleteById(2);
		logger.info("All users -> {}", repository.findAll());

//		logger.info("All users from Orxeta -> {}", dao.findByLocation("Orxeta"));
//		logger.info("All users containing 'epe' in their name -> {}", dao.findByName(" epe"));

	}

}
