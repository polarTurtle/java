package com.tut.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tut.database.databasedemo.bean.Person;
import com.tut.database.databasedemo.jdbc.PersonJdbcDAO;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users: {}", dao.findAll());
		logger.info("User id 10001: {}", dao.findByID(10001));
		logger.info("deleting 10002: {}", dao.deleteByID(10002));
		logger.info("Insert 10004: {}", dao.insert(new Person(10004, "benLand", "BestBen", new Date())));
		logger.info("User id 10004: {}", dao.findByID(10004));
		logger.info("Update 10001: {}", new Person(10001, "sandLand", "worstSand", new Date()));
	}

}
