package com.cognixia.jump.languagelearning.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.languagelearning.model.FillQuestion;

@Repository
public interface FillRepo extends JpaRepository<FillQuestion, Integer>{
	long count(); // Count the total number of fill-in-the-blank questions

	Optional<FillQuestion> findById(Integer id); // Retrieve a question by its ID

//	@Query("SELECT fq.id FROM FillQuestion fq WHERE fq.language.id = :languageId")
//	List<Integer> findIdsByLanguageId(Integer languageId);
	
	@Query("SELECT fq.id FROM FillQuestion fq JOIN fq.topic t WHERE t.language.id = :languageId")
	List<Integer> findIdsByLanguageId(@Param("languageId") Integer languageId);


}