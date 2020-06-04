package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO personJdbcDAO;

	@Autowired
	PersonJPARepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.info("All users -> {}", personJdbcDAO.findAll());
		//logger.info("Assigned by Repository -> {}", repository.insert(new Person("Hibernate", "JPA", new Date())));
		logger.info("User ID 10001 -> {}", personJdbcDAO.findByID(10001));
		logger.info("User name 'John' -> {}", personJdbcDAO.findByName("John"));
		logger.info("Deleting User ID 10002, Number of rows deleted -> {}", personJdbcDAO.deleteByID(10002));
	}
}
