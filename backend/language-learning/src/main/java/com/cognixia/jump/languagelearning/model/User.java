package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "language_id", referencedColumnName = "id")
	private Language language;

	public User(Integer id, @NotBlank String email, @NotBlank String username, @NotBlank String password,
			Language language) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.language = language;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", language=" + language + "]";
	}
	
	
	
	
	
	

	
	
	
}
