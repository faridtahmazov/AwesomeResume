package com.company;

import com.company.model.EmployedHistory;
import com.company.model.Skill;
import com.company.model.User;
import com.company.service.serviceInter.EmployedHistoryServiceInter;
import com.company.service.serviceInter.SkillServiceInter;
import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

    @Autowired //Hansı classı new user... olarağ yazacağsa o olacağ, yəni bu interface-i impl etmiş classın yaradıb
                // buna inject edəcək
    @Qualifier("userServiceImpl") //Deqiq olarag hansi class olacagin ifade edirik.
    private UserServiceInter userService;

	@Autowired
	@Qualifier("employedHistoryServiceImpl")
	private EmployedHistoryServiceInter employedHistoryService;

	@Autowired
	@Qualifier("skillServiceImpl")
	private SkillServiceInter skillService;


	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {
				List<User> users = userService.findUsers();

				for (User user: users) {
					System.out.println("User: " + user);
				}

				System.out.println("-----------");

				List<EmployedHistory> employedHistories = employedHistoryService.findEmpHistories();

				for (EmployedHistory emp: employedHistories) {
					System.out.println("Employed History: " + emp);
				}

				System.out.println("-----------");

				List<Skill> skills = skillService.findSkills();

				for (Skill skill: skills) {
					System.out.println("Skill: " + skill);
				}

				System.out.println("-----------");
			}
		};

		return clr;
	}

}
