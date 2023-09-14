package com.cognixia.jump.languagelearning.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.model.User.Role;
import com.cognixia.jump.languagelearning.service.MyUserDetailsService;
import com.cognixia.jump.languagelearning.service.UserService;
import com.cognixia.jump.languagelearning.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {
	

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean 
	private PasswordEncoder encoder;
	
	@MockBean
	private MyUserDetailsService userDetailsService;
	
	@MockBean
	private JwtUtil jwtUtil;
	
	@InjectMocks
	private UserController userController;
	
	private static final String STARTING_URI = "http://localhost:8080/api";
	
	
	@Test
	public void testCreateUser() throws Exception {
		int userId = 1;
		User mockUser = new User (userId, "albertzeap@email.com", "albertpaez", "password123", null, Role.ROLE_USER, true);
		String stringUser = objectMapper.writeValueAsString(mockUser);
		
		when(userService.createUser(Mockito.any(User.class))).thenReturn(mockUser);
		
		mvc.perform(post(STARTING_URI + "/user")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(stringUser))
				.andDo(print())
				.andExpect(status().isCreated());

		verify(userService, times(1)).createUser(Mockito.any(User.class));
//		verifyNoInteractions(userService);
	}
	
	
	@Test
	public void testGetUserById() throws Exception{
		int userId = 1;
		User mockUser = new User (userId, "albertzeap@email.com", "albertpaez", "password123", null, Role.ROLE_USER, true);
		final String uri =  STARTING_URI + "/user/" + userId;
		
		
		when(userService.getUserById(userId)).thenReturn(mockUser);
		
		mvc.perform(get(uri))
		.andDo(print())
		.andExpect(status().isOk());		
		
		verify(userService, times(1)).getUserById(userId);
//		verifyNoInteractions(userService);
		
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		int userId = 1;
		User mockUser = new User (userId, "albertzeap@email.com", "albertpaez", "password123", null, Role.ROLE_USER, true);
		String toJsonUser = objectMapper.writeValueAsString(mockUser);
		
		when(userService.updateUser(Mockito.any(User.class))).thenReturn(mockUser);
		
		mvc.perform(put(STARTING_URI + "/user")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(toJsonUser))
		.andExpect(status().isOk());
		
		
		verify(userService, times(1)).updateUser(Mockito.any(User.class));
//		verifyNoInteractions(userService);
	}
	
	@Test
	public void testDeleteUser() throws Exception{
		int userId = 1;
		User mockUser = new User (userId, "albertzeap@email.com", "albertpaez", "password123", null, Role.ROLE_USER, true);
		
		when(userService.deleteUser(userId)).thenReturn(mockUser);
		
		mvc.perform(delete(STARTING_URI + "/user/" + userId )
				.contentType(MediaType.APPLICATION_JSON_VALUE))
		.andDo(print())
		.andExpect(status().isNoContent());
		
		verify(userService, times(1)).deleteUser(userId);
//		verifyNoInteractions(userService);
		
	}
	
	
	
	
}
