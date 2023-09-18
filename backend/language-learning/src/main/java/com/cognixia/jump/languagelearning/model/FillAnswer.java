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
public class FillAnswer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@NotBlank
	private String answer;
	
	@ManyToOne
	@JoinColumn( name = "question_id", referencedColumnName = "id" ) // can add nullable = false to make sure dorm id is given for each account (won't b/c we may have commuter students)
	private FillQuestion question;
	
	public FillAnswer(Integer id, String answer, FillQuestion question) {
		super();
		this.id = id;
		this.answer = answer;
		this.question = question;
	}
	
	public FillAnswer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public FillQuestion getQuestion() {
		return question;
	}

	public void setQuestion(FillQuestion question) {
		this.question = question;
	}
	
	
}
