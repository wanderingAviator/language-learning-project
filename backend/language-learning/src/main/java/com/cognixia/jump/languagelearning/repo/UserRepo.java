package com.cognixia.jump.languagelearning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.languagelearning.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	
	public Optional<User> findByUsername(String username);
}
