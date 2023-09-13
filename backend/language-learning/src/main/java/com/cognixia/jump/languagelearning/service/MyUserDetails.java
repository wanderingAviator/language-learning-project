package com.cognixia.jump.languagelearning.service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognixia.jump.languagelearning.model.User;

// UserDetails class -> used by spring security to find all the necessary info for 
//					    authentication & authorization
public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	// when a new object is created, only the RELEVANT info will be extracted from the User
	public MyUserDetails(User user) {
		
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.enabled = user.isEnabled();
		
		// Granted Authority -> permissions/grants of what a user can do based on their role
		this.authorities = Arrays.asList( new SimpleGrantedAuthority( user.getRole().name() ) );
		
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	// all these methods below:
	// - DON'T NEED to be stored in a user table
	// - store this info if it's worthwhile for your security
	// - have all these methods return true manually if you are NOT storing this 
	//   info in a user table
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}

