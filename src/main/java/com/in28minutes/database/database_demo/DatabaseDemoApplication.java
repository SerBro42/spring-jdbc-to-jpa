package com.in28minutes.database.database_demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.database_demo.jdbc.PersonJdbcDao;

//CommandLineRunner allows to launch stuff as soon as the applicationContext is ready. It is 
//used in place of instantiating local variables for applicationContext
@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("All users from Orxeta -> {}", dao.findByLocation("Orxeta"));
		logger.info("All users containing 'epe' in their name -> {}", dao.findByName(" epe"));

	}

}
