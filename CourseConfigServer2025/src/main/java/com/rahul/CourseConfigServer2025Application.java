package com.rahul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class CourseConfigServer2025Application {

	public static void main(String[] args) {
		SpringApplication.run(CourseConfigServer2025Application.class, args);
	}

}
