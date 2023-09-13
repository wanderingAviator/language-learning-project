package com.cognixia.jump.languagelearning.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognixia.jump.languagelearning.model.Language;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.model.User.Role;
import com.cognixia.jump.languagelearning.repo.UserRepo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

@SpringBootTest
public class MyUserDetailsServiceTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private MyUserDetailsService userDetailsService;

    @Test
    public void testLoadUserByUsername() {
        // Create a mock User object
    	Language userLanguage = new Language(1, "Spanish");
    	User mockUser = new User (1, "albertzeap@email.com", "albertpaez", "password123", userLanguage, Role.ROLE_USER);
        
        // Mock the behavior of the UserRepo to return the mockUser when findByUsername is called
        Mockito.when(userRepo.findByUsername("albertpaez")).thenReturn(Optional.of(mockUser));

        // Call the loadUserByUsername method
        UserDetails userDetails = userDetailsService.loadUserByUsername("albertpaez");

        // Verify that the UserDetails object is not null
        assertNotNull(userDetails);

        // Verify that the username in UserDetails matches the one we provided
        assertEquals("albertpaez", userDetails.getUsername());

        // Verify that the password in UserDetails matches the one we provided (hashed)
        assertEquals("password123", userDetails.getPassword()); // Replace with actual hashed password
    }

    @Test
    public void testLoadUserByUsernameUsernameNotFound() {
        // Mock the behavior of the UserRepo to return an empty Optional when findByUsername is called
        Mockito.when(userRepo.findByUsername("nonExistentUser")).thenReturn(Optional.empty());

        // Call the loadUserByUsername method with a non-existent username
        try {
            userDetailsService.loadUserByUsername("nonExistentUser");
            // If the method doesn't throw UsernameNotFoundException, the test fails
            fail("Expected UsernameNotFoundException to be thrown");
        } catch (UsernameNotFoundException e) {
            // UsernameNotFoundException should be thrown, test passes
        }
    }
}

