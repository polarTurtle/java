package com.tut.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.database.databasedemo.bean.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

}
