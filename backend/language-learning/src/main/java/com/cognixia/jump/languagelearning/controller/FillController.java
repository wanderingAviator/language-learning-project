package com.cognixia.jump.languagelearning.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.languagelearning.exception.ResourceNotFoundException;
import com.cognixia.jump.languagelearning.exception.UserExistsException;
import com.cognixia.jump.languagelearning.model.FillQuestion;
import com.cognixia.jump.languagelearning.model.User;
import com.cognixia.jump.languagelearning.service.FillService;
import com.cognixia.jump.languagelearning.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class FillController {

	@Autowired
	private FillService fillService;

	@GetMapping("/fill")
	public List<FillQuestion> getAllFillQuestions() {
		return fillService.getAllFillQuestions();
	}

	@GetMapping("/fill_question/{language_id}")
	public ResponseEntity<FillQuestion> getRandomFillQuestion(@PathVariable Integer language_id) {
		// Call the service method to get a random fill-in-the-blank question for the
		// specified language_id
		Optional<FillQuestion> randomQuestion = fillService.getRandomFillQuestionByLanguageId(language_id);

		if (randomQuestion.isPresent()) {
			return ResponseEntity.ok(randomQuestion.get());
		} else {
			// Return a 404 Not Found response if no question is found for the specified
			// language_id
			return ResponseEntity.notFound().build();
		}
	}
}
