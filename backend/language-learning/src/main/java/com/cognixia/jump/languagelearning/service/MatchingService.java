package com.cognixia.jump.languagelearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.languagelearning.model.MatchingQuestion;
import com.cognixia.jump.languagelearning.repo.MatchingRepo;

@Service
public class MatchingService {

	
	@Autowired
	MatchingRepo matchingRepo;

	public MatchingQuestion getQuestion(int id) {
		
		MatchingQuestion question = matchingRepo.getMatchQuestion(id);
		return question;
	}

	public List<MatchingQuestion> getQuestionsByLanguage(int languageId) {
		
		
		
		
		return null;
	}
	
	
}
