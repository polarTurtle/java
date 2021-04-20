package com.system.IMCProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.IMCProject.databaseObjects.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String userName);
}
