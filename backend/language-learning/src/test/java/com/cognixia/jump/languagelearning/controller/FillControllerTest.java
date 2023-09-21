package com.cognixia.jump.languagelearning.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognixia.jump.languagelearning.model.FillQuestion;

import com.cognixia.jump.languagelearning.service.FillService;
import com.cognixia.jump.languagelearning.service.MyUserDetailsService;
import com.cognixia.jump.languagelearning.util.JwtUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest(value = FillController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class}) // Replace YourController with the actual name of your controller class
public class FillControllerTest {
	
	private static final String STARTING_URI = "http://localhost:8080/api";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FillService fillService;
    
    @MockBean 
    private MyUserDetailsService myUserDetailsService;
    
    @MockBean 
    private JwtUtil jwtUtil;

    @InjectMocks
    private FillController fillController;

    @Test
    public void testGetAllFillQuestions() throws Exception {
        // Create sample data
    	String promptValue = "Blue in Spanish is _____.";
    	FillQuestion sampleQuestion = new FillQuestion(1, promptValue, null, null);
        List<FillQuestion> fillQuestions = new ArrayList<>();
        fillQuestions.add(sampleQuestion);
        // Add more fillQuestions as needed

        // Mock the behavior of fillService.getAllFillQuestions()
        Mockito.when(fillService.getAllFillQuestions()).thenReturn(fillQuestions);

        mockMvc.perform(MockMvcRequestBuilders.get(STARTING_URI + "/fill")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].prompt").value(promptValue));
        // Add more assertions for other properties of FillQuestion as needed
    }

    @Test
    public void testGetRandomFillQuestion() throws Exception {
        // Create a sample language ID
        Integer languageId = 1; // Replace with your language ID
        String promptValue = "Blue in Spanish is _____.";
        // Create a sample FillQuestion
        FillQuestion sampleQuestion = new FillQuestion(1, promptValue, null, null);

        // Mock the behavior of fillService.getRandomFillQuestionByLanguageId()
        Mockito.when(fillService.getRandomFillQuestionByLanguageId(languageId)).thenReturn(Optional.of(sampleQuestion));

        mockMvc.perform(MockMvcRequestBuilders.get(STARTING_URI + "/fill_question/{language_id}", languageId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.prompt").value(promptValue));
        // Add more assertions for other properties of FillQuestion as needed
    }
}

