package com.cognixia.jump.languagelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.languagelearning.exception.ResourceNotFoundException;
import com.cognixia.jump.languagelearning.exception.UserExistsException;
import com.cognixia.jump.languagelearning.model.AuthenticationRequest;
import com.cognixia.jump.languagelearning.model.AuthenticationResponse;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.service.UserService;
import com.cognixia.jump.languagelearning.util.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createJwtToken(@RequestBody AuthenticationRequest request ) throws Exception{
		try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        final String jwt = jwtUtil.generateTokens(userDetails);

        return ResponseEntity.status(201).body(new AuthenticationResponse(jwt));
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable int id) throws ResourceNotFoundException {
		
		User found = userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(found);
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user) throws UserExistsException{
		System.out.println(user);
		User created = userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user) throws ResourceNotFoundException{
		
		User updated = userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(updated);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable int id) throws ResourceNotFoundException{
		
		User deleted = userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(deleted);
	}
	
	
}
