package com.company.resumewebapp;

import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.company.service"})
public class ResumeWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeWebAppApplication.class, args);
	}

}
