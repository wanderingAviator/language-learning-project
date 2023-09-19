package com.cognixia.jump.languagelearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.languagelearning.model.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {
    
    // You can add custom query methods here if needed
    
}

