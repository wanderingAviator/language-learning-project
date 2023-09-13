package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	public MatchingQuestion(Integer id, @NotBlank String prompt, Topic topic) {
		super();
		this.id = id;
		this.prompt = prompt;
		this.topic = topic;
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

	@Override
	public String toString() {
		return "MatchingQuestion [id=" + id + ", prompt=" + prompt + ", topic=" + topic + "]";
	}
	
	
	
}
