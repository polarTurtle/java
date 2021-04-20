package com.system.IMCProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.IMCProject.databaseObjects.StaffObject;

public interface StaffRepository extends JpaRepository<StaffObject, Long> {
	Optional<StaffObject> findByEmail(String email);
}
