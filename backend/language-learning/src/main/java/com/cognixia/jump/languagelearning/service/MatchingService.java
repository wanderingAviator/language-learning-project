package com.cognixia.jump.languagelearning.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.languagelearning.exception.ResourceNotFoundException;
import com.cognixia.jump.languagelearning.model.MatchingQuestion;
import com.cognixia.jump.languagelearning.repo.MatchingRepo;

@Service
public class MatchingService {

	
	@Autowired
	MatchingRepo matchingRepo;

	public MatchingQuestion getQuestionsByLanguage(int languageId) throws ResourceNotFoundException {
		
		List<Integer> questionIds = matchingRepo.findIdsByLanguageId(languageId);
		
		if(questionIds.isEmpty()) {
			throw new ResourceNotFoundException("questions within language", languageId);
		}
		
		Random random = new Random();
		int randomIndex = random.nextInt(questionIds.size());
		Integer randomQuestionId = questionIds.get(randomIndex);
		
		Optional<MatchingQuestion> found = matchingRepo.findById(randomQuestionId);
		
		if(found.isEmpty()) {
			throw new ResourceNotFoundException("question", randomQuestionId);
		}
		
		
		
		return found.get();
	}
	
	
}
