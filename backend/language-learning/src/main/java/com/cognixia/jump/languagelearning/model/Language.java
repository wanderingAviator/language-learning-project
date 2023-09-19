package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Language implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
	private List<Topic> topics;

	public Language(Integer id, @NotBlank String name, List<Topic> topics, List<FillQuestion> fillQuestions,
			List<MatchingQuestion> matchQuestions) {
		super();
		this.id = id;
		this.name = name;
		this.topics = topics;

	}

	public Language() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//fdsg
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

}
