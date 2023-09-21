package com.cognixia.jump.languagelearning.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.cognixia.jump.languagelearning.model.Language;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.model.User.Role;
import com.cognixia.jump.languagelearning.service.MatchingService;
import com.cognixia.jump.languagelearning.service.MyUserDetailsService;
import com.cognixia.jump.languagelearning.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = MatchingController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
@AutoConfigureMockMvc(addFilters = false)
public class MatchingControllerTest {
	
	
	private static final String STARTING_URI = "http://localhost:8080/api";
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private MatchingService matchingService;
	
	@MockBean 
	private PasswordEncoder encoder;
	
	@MockBean
	private MyUserDetailsService userDetailsService;
	
	@MockBean
	private JwtUtil jwtUtil;
	
	@InjectMocks
	private MatchingController matchingController;
	
	
	@Test
	public void testGetQuestion() throws Exception{
		int userId = 1;
		Language language = new Language(1, "Spanish", null);
		User mockUser = new User (userId, "albertzeap@email.com", "albertpaez", "password123", null, Role.ROLE_USER, true);
		final String uri =  STARTING_URI + "/user/" + userId;
		
		
//		when(matchingService.getQuestion(language.getId())).thenReturn(mockUser);
//		
//		mvc.perform(get(uri))
//		.andDo(print())
//		.andExpect(status().isOk());		
//		
//		verify(matchingService, times(1)).getQuestion(language.getId());
//		verifyNoInteractions(userService);
		
	}
}
