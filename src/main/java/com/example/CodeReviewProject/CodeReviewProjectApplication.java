package com.example.CodeReviewProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CodeReviewProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeReviewProjectApplication.class, args);
	}

}
