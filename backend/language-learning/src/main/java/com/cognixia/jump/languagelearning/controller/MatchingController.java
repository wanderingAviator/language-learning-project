package com.cognixia.jump.languagelearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.languagelearning.model.MatchingQuestion;
import com.cognixia.jump.languagelearning.service.MatchingService;

@RestController
@RequestMapping("/api")
public class MatchingController {

	
	@Autowired
	MatchingService matchingService;
	
	@GetMapping("/match_card/language/{languageId}")
	public ResponseEntity<?> getQuestionsByLanguage(@PathVariable int languageId){
		
		List<MatchingQuestion> question = matchingService.getQuestionsByLanguage(languageId);
		return ResponseEntity.status(HttpStatus.OK).body(question);
	}
	
	@GetMapping("/match_card/{id}")
	public ResponseEntity<?> getQuestionById(@PathVariable int id){
		
		MatchingQuestion question = matchingService.getQuestion(id);
		return ResponseEntity.status(HttpStatus.OK).body(question);
	}
}
