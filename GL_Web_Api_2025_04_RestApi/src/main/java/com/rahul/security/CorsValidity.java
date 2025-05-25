package com.rahul.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//How you define a global configuration Global Configuration for the Cors
@Configuration
public class CorsValidity {
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addcorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // All request to All URLS
						.allowedMethods("*") // Any Request Method
						.allowedOrigins("http://localhost:3000");
			}
		};
	}
}
