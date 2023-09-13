package com.cognixia.jump.languagelearning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognixia.jump.languagelearning.filter.JwtRequestFilter;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Bean
	protected UserDetailsService userDetailsService() {
		
		return userDetailsService;
	}
	
	@Bean
	protected SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		http
	    .csrf().disable()
	    .authorizeRequests()

	        .requestMatchers("/authenticate").permitAll()// tokens
	        // swagger
	        .requestMatchers("/v3/api-docs/swagger-config").permitAll()
	        .requestMatchers("/v3/api-docs").permitAll()
	        .requestMatchers("/swagger-ui/**").permitAll()
//	        .requestMatchers(HttpMethod.POST, "/api/statistics/").hasRole("ADMIN") // Allow only ADMIN to POST 
	        .requestMatchers("/api/user").permitAll()// allow creation of      
	        .anyRequest().authenticated()
	    .and()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	// Exception handling begins here
    http.exceptionHandling()
        .authenticationEntryPoint((request, response, ex) -> {
            // Handle authentication-related exceptions here
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Not able to authenticate token");
        })
        .accessDeniedHandler((request, response, ex) -> {
            // Handle access denied exceptions here
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Not authorized.  Only ADMIN can POST statistics");
        });
	
	return http.build();
	
	}
	
	@Bean
	protected PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());

		return authProvider;
	}

	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	
	
}
