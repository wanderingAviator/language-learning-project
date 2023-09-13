package com.cognixia.jump.languagelearning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;

	// method will by called by Spring Security when a request comes in
	// credentials (username + password) passed through the request will be loaded
	// in
	// username will be passed to this method (as an argument), then will call the
	// UserRepository in order to find a user with that username
	// As long as this user is found, User info will be passed to a UserDetails
	// object and returned

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userFound = repo.findByUsername(username);

		// if username doesn't exist in the table, throw exception...
		if (userFound.isEmpty()) {
			throw new UsernameNotFoundException("Username of " + username + " not found");
		}

		System.out.println("Received username: " + username);
		System.out.println("User's hashed password: " + userFound.get().getPassword()); // Ensure this is hashed

		// ...but if it does, then we want to return the user we found
		return new MyUserDetails(userFound.get());
	}

}

