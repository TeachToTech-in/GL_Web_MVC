package com.rahul.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		// anyRequest().authenticated() → All endpoints require authentication

		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())

				// sessionCreationPolicy(STATELESS) → No session is created (good for
				// APIs,especially with JWT)

				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				// httpBasic() → Enables HTTP Basic Auth

				.httpBasic(Customizer.withDefaults())

				// frameOptions().sameOrigin() → Allows iframes from same origin (needed for
				// things like H2 console)

				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))

				// csrf().disable() → Disables CSRF (okay for stateless APIs, but be cautious)

				.csrf(csrf -> csrf.disable());

		return http.build();
	}

	// How to Create Multiple In Memory User name and password
	@Bean
	public UserDetailsService userDetailService() {

		var user = User.withUsername("rahul")
				// .password("{noop}rahul")
				.password(passwordEncoder().encode("rahul")).roles("USER").build();

		var admin = User.withUsername("admin")
				// .password("{noop}admin")
				.password(passwordEncoder().encode("admin")).roles("ADMIN").build();

		var superadmin = User.withUsername("superadmin")
				// .password("{noop}admin")
				.password(passwordEncoder().encode("admin")).roles("ADMIN", "USER").build();

		return new InMemoryUserDetailsManager(user, admin, superadmin);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}