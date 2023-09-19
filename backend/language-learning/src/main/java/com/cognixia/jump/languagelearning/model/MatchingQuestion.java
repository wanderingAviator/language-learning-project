package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class MatchingQuestion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@NotBlank
	private String prompt;
	
	@ManyToOne
	@JoinColumn( name = "topic_id", referencedColumnName = "id" )
	private Topic topic;
	
	@OneToMany(mappedBy="matchingQuestion")
//	@OneToMany
//	@JoinColumn( name = "answer_id", referencedColumnName = "id" )
	private List<MatchingAnswer> answers;

	public MatchingQuestion() {}

	public MatchingQuestion(Integer id, @NotBlank String prompt, List<MatchingAnswer> answers) {
		super();
		this.id = id;
		this.prompt = prompt;
		this.answers = answers;
	}
	
	public MatchingQuestion(Integer id, @NotBlank String prompt, Topic topic, List<MatchingAnswer> answers) {
		super();
		this.id = id;
		this.prompt = prompt;
		this.topic = topic;
		this.answers = answers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<MatchingAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<MatchingAnswer> answers) {
		this.answers = answers;
	}
	
	
	
	

	
	
	
	
}
