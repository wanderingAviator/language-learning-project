package com.cognixia.jump.languagelearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.languagelearning.model.MatchingAnswer;
import com.cognixia.jump.languagelearning.model.MatchingQuestion;

@Repository
public interface MatchingRepo extends JpaRepository<MatchingQuestion, Integer>{
	
	// select ma.id, ma.question_id, mq.prompt, left_match, right_match from matching_answer ma JOIN matching_question mq ON mq.id = ma.question_id  where question_id = 6 and ma.id = ?;	
	
	@Query(value = "SELECT mq.id, prompt, topic_id, ma.id as answer_id, left_match, right_match FROM matching_question mq JOIN matching_answer ma ON ma.question_id = mq.id WHERE ma.question_id = :questionId", nativeQuery = true)
	public MatchingQuestion getMatchQuestion(@Param("questionId") int questionId);
	
}
