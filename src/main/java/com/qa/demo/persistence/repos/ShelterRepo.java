package com.qa.demo.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.demo.persistence.domain.Shelter;

@Repository
public interface ShelterRepo extends JpaRepository<Shelter, Long> {
	// CRUD Functionality
}
