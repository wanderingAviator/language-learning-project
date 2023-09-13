package com.cognixia.jump.languagelearning.model;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Topic {
	

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@NotBlank
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", nullable = false, unique = true)
	private Language language;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<FillQuestion> fill_questions;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<MatchingQuestion> match_questions;
	
	public Topic(Integer id, @NotBlank String name, Language language, List<FillQuestion> fill_questions,
			List<MatchingQuestion> match_questions) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.fill_questions = fill_questions;
		this.match_questions = match_questions;
	}
	public Topic() {
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public List<FillQuestion> getFill_questions() {
		return fill_questions;
	}
	public void setFill_questions(List<FillQuestion> fill_questions) {
		this.fill_questions = fill_questions;
	}
	public List<MatchingQuestion> getMatch_questions() {
		return match_questions;
	}
	public void setMatch_questions(List<MatchingQuestion> match_questions) {
		this.match_questions = match_questions;
	}
	
	
	
	
	
}
