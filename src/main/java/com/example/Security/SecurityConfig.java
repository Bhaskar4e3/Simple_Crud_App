package com.example.Security;


import java.rmi.registry.Registry;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	 public UserDetailsService userDetailsService(PasswordEncoder encoder) {
	  UserDetails user1=User
			            .withUsername("bhaskar")
			            .password(encoder.encode("bk123"))
			            .roles("admin")
			            .build();
	  
	   UserDetails user2=User
			   .withUsername("smith")
			   .password(encoder.encode("sm123"))
			   .roles("user")
			   .build();
	   
	return new  InMemoryUserDetailsManager(user1,user2);
	 }
	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	return	  http.authorizeHttpRequests(authorizeRequest->authorizeRequest.requestMatchers("/home/**").permitAll()
				  .requestMatchers("/admin/**").hasRole("admin")
				  .requestMatchers("/user/**").hasRole("user").anyRequest().authenticated())
		  .httpBasic(httpBasic->httpBasic.realmName("bk")).
		  csrf(c->c.disable()).build();
	
		  
	 }
	 @Bean
	 public PasswordEncoder encoder() {
		 return new BCryptPasswordEncoder();
	 }

}
