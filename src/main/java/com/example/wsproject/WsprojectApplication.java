package com.example.wsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class, scanBasePackages = {"com.example.wsproject", "com.example.wsproject.Service", "com.example.wsproject.Config", "com.example.wsproject.Dto", "com.example.wsproject.Entity", "com.example.wsproject.Repo",  "com.example.wsproject.UserController" })
public class WsprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsprojectApplication.class, args);
	}

}
