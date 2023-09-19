package com.cognixia.jump.languagelearning.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.languagelearning.model.FillQuestion;
import com.cognixia.jump.languagelearning.repo.FillRepo;

@Service
public class FillService {
	@Autowired
	private FillRepo fillRepo;

	public List<FillQuestion> getAllFillQuestions() {
		return fillRepo.findAll();
	}

	public Optional<FillQuestion> getRandomFillQuestionByLanguageId(Integer languageId) {
		// Get a list of IDs of all questions with the specified language_id
		List<Integer> questionIds = fillRepo.findIdsByLanguageId(languageId);

		if (questionIds.isEmpty()) {
			return Optional.empty(); // No questions in the database for the specified language
		}

		// Generate a random index to choose a question ID from the list
		Random random = new Random();
		int randomIndex = random.nextInt(questionIds.size());
		Integer randomQuestionId = questionIds.get(randomIndex);

		// Retrieve the question with the randomly chosen ID
		return fillRepo.findById(randomQuestionId);
	}
}
