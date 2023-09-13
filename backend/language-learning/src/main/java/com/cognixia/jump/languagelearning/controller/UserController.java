package com.cognixia.jump.languagelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.languagelearning.exception.ResourceNotFoundException;
import com.cognixia.jump.languagelearning.exception.UserExistsException;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) throws ResourceNotFoundException {
		
		User found = userService.getUserById(id);
		return ResponseEntity.status(200).body(found);
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@RequestBody User user) throws UserExistsException{
		
		User created = userService.createUser(user);
		return ResponseEntity.status(201).body(created);
	}
}
