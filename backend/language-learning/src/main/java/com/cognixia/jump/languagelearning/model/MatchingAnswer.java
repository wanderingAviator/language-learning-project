package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "matchinganswer") // Specify the table name
public class MatchingAnswer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String leftMatch;
	
	@NotBlank
	private String rightMatch;
	
	@ManyToOne
	@JoinColumn( name = "question_id", referencedColumnName = "id" )
	private MatchingQuestion matchingQuestion;

	public MatchingAnswer(Integer id, @NotBlank String leftMatch, @NotBlank String rightMatch,
			MatchingQuestion matchingQuestion) {
		super();
		this.id = id;
		this.leftMatch = leftMatch;
		this.rightMatch = rightMatch;
		this.matchingQuestion = matchingQuestion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeftMatch() {
		return leftMatch;
	}

	public void setLeftMatch(String leftMatch) {
		this.leftMatch = leftMatch;
	}

	public String getRightMatch() {
		return rightMatch;
	}

	public void setRightMatch(String rightMatch) {
		this.rightMatch = rightMatch;
	}

	public MatchingQuestion getMatchingQuestion() {
		return matchingQuestion;
	}

	public void setMatchingQuestion(MatchingQuestion matchingQuestion) {
		this.matchingQuestion = matchingQuestion;
	}

	@Override
	public String toString() {
		return "MatchingAnswer [id=" + id + ", leftMatch=" + leftMatch + ", rightMatch=" + rightMatch
				+ ", matchingQuestion=" + matchingQuestion + "]";
	}
	
	
}
