package com.cognixia.jump.languagelearning.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.cognixia.jump.languagelearning.model.Language;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.model.User.Role;
import com.cognixia.jump.languagelearning.service.UserService;
import com.cognixia.jump.languagelearning.util.JwtUtil;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {
	
	private static final String STARTING_URI = "http://localhost:8080/api";

	@Autowired
	private MockMvc mvc;
	
	@MockBean 
	private UserService userService;
	
	@MockBean 
	private PasswordEncoder encoder;
	
	@MockBean
	private JwtUtil jwtUtil;
	
	@InjectMocks
	private UserController userController;
	
	@Test 
	void testGetUserById() throws Exception {
		
		final String uri =  STARTING_URI + "/user/1";
		Language userLanguage = new Language(1, "Spanish");
		User user = new User (1, "albertzeap@email.com", "albertpaez", "password123", userLanguage, Role.ROLE_USER);
		
		when(userService.getUserById(1)).thenReturn(user);
		
		 mvc.perform(get(uri)) // perform get request
			.andDo(print()) // print request sent/response given
			.andExpect(status().isOk()) // expect a 200 status code
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
	        .andExpect(jsonPath("$.id").value(user.getId()))
			.andExpect(jsonPath("$.username").value(user.getUsername()))
			.andExpect(jsonPath("$.password").value(user.getPassword()))
			.andExpect(jsonPath("$.email").value(user.getEmail()));
		 
		 verify(userService, times(1)).getUserById(1);
		 verifyNoInteractions(userService);
	}
	
	@Test
    void testCreateUser() throws Exception{

        // ARRANGE 
        String uri = STARTING_URI + "/user";
        Language userLanguage = new Language(1, "Spanish");
        User user = new User (1, "albertzeap@email.com", "albertpaez", "password123", userLanguage, Role.ROLE_USER);
        
        
        when(userService.createUser(Mockito.any(User.class))).thenReturn(user);

        mvc.perform(post(uri).content(user.toJson()) // data sent in body NEEDS to be in JSON format
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }
	
}
