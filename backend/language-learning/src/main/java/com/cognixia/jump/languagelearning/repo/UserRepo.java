package com.cognixia.jump.languagelearning.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.languagelearning.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	public Optional<User> findByUsername(String username);
}
