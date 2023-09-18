package com.cognixia.jump.languagelearning.model;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class FillQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@NotBlank
	private String prompt;
	
	@ManyToOne
	@JoinColumn( name = "topic_id", referencedColumnName = "id" ) // can add nullable = false to make sure dorm id is given for each account (won't b/c we may have commuter students)
	private Topic topic;
	
	@OneToMany(mappedBy="question")
//	@OneToMany
//	@JoinColumn( name = "answer_id", referencedColumnName = "id" )
	private List<FillAnswer> answers;

	public FillQuestion() {}

	public FillQuestion(Integer id, @NotBlank String prompt, Topic topic, List<FillAnswer> answers) {
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

	public List<FillAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<FillAnswer> answers) {
		this.answers = answers;
	}
	
	
	
	
	
	
	
	
}
