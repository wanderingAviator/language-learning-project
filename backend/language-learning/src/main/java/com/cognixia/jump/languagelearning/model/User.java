package com.cognixia.jump.languagelearning.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public static enum Role {
		ROLE_USER, ROLE_ADMIN
	}

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
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition="default 'ROLE_USER'")
	private Role role;

	public User(Integer id, @NotBlank String email, @NotBlank String username, @NotBlank String password,
			Language language, Role role) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.language = language;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", language=" + language + ", role=" + role + "]";
	}
	
	
	

	
	
	
	
	
	
	

	
	
	
}
