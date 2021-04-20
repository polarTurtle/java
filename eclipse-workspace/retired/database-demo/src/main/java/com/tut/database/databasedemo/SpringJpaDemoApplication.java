package com.tut.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tut.database.databasedemo.bean.Person;
import com.tut.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJpaDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001: {}", repo.findByID(10001));
		logger.info("Insert 10004: {}", repo.update(new Person("benLand", "BestBen", new Date())));
		logger.info("Update 10001: {}", new Person(10001, "sandLand", "worstSand", new Date()));
		logger.info("User id 10001: {}", repo.findByID(10001));
		repo.delete(10001);
		logger.info("User id 10001: {}", repo.findByID(10001));
		logger.info("All users: {}", repo.findAll());
//		logger.info("deleting 10002: {}", repo.deleteByID(10002));
//		logger.info("Insert 10004: {}", repo.insert(new Person(10004, "benLand", "BestBen", new Date())));
//		logger.info("User id 10004: {}", repo.findByID(10004));
//		logger.info("Update 10001: {}", new Person(10001, "sandLand", "worstSand", new Date()));
	}

}
