package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String email;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	
	
	private Integer languageId;

	public User(Integer id, @NotBlank String email, @NotBlank String username, @NotBlank String password,
			Integer languageId) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.languageId = languageId;
	}
	
	
}
