package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.company"})
public class ResumeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeRestApiApplication.class, args);
	}

}
