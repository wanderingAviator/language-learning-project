package com.cognixia.jump.languagelearning.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.languagelearning.exception.ResourceNotFoundException;
import com.cognixia.jump.languagelearning.exception.UserExistsException;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public User getUserById(int id) throws ResourceNotFoundException {
		
		Optional<User> found = userRepo.findById(id);
		if(found.isEmpty()) throw new ResourceNotFoundException("User", id);
		return found.get();
		
	}

	public User createUser(User user) throws UserExistsException {
		
		Optional<User> exists = userRepo.findByUsername(user.getUsername());
		if(exists.isPresent()) throw new UserExistsException(user.getUsername());
		
		User created = userRepo.save(user);
		
		return created;
	}
	
	public User updateUser(User user) throws ResourceNotFoundException {
		
		boolean exists = userRepo.existsById(user.getId());
		if(!exists) throw new ResourceNotFoundException("User", user.getId());
		
		User created = userRepo.save(user);
		
		return created;
	}

	public User deleteUser(int id) throws ResourceNotFoundException {
		
		Optional<User> found = userRepo.findById(id);
		if(found.isEmpty()) throw new ResourceNotFoundException("User", id);
		
		userRepo.deleteById(id);
		User deleted = found.get();
		
		return deleted;
	}

}
