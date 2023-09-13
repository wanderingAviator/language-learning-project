package com.cognixia.jump.languagelearning.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class FillQuestion {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@NotBlank
	private String prompt;
	
	@ManyToOne
	@JoinColumn( name = "topic_id", referencedColumnName = "id" ) // can add nullable = false to make sure dorm id is given for each account (won't b/c we may have commuter students)
	private Topic topic;
	
	public FillQuestion(Integer id, @NotBlank String prompt, Topic topic) {
		super();
		this.id = id;
		this.prompt = prompt;
		this.topic = topic;
	}
	
	public FillQuestion() {
		
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
	
	
}
