package com.example.polishCommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.newsPage", "com.example.polishCommunity", "com.example.skillsPage", "com.example.resourcesPage", "com.example.organisationsPage", "com.example.profilePage"})
public class PolishCommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolishCommunityApplication.class, args);
	}

}
