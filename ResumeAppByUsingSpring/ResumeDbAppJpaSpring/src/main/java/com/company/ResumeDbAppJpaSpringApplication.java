package com.company;

import com.company.model.Country;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableCaching
public class ResumeDbAppJpaSpringApplication {

	@Autowired //Hansı classı new user... olarağ yazacağsa o olacağ, yəni bu interface-i impl etmiş classın yaradıb
	// buna inject edəcək
	@Qualifier("userService") //Deqiq olarag hansi class olacagin ifade edirik.
	private UserServiceInter userService;

	@Autowired
	@Qualifier("employedHistoryServiceImpl")
	private EmployedHistoryServiceInter employedHistoryService;

	@Autowired
	@Qualifier("skillServiceImpl")
	private SkillServiceInter skillService;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				getAllData();
			}
		};

		return clr;
	}

	public void insertData(){
		Country country = new Country("Azerbaijan", "Azerbaijani");
		User user = new User("Farid", "Tahmazov", "tahmazovfarid7@gmail.com",
				"055-977-32-37", "Hii", "Baku", new Date());
		Skill skill = new Skill("Java");

		User user2 = new User("Ruslan", "Guliyev", "ruslanguliyev@gmail.com",
				"055-555-55-55", "Hii", "Ganja", new Date());

		Skill skill2 = new Skill("Php");

		EmployedHistory employedHistory = new EmployedHistory("Java Software Developer", new Date(),
				new Date(), "Im very ability!");

		EmployedHistory employedHistory2 = new EmployedHistory("Php Software Developer", new Date(),
				new Date(), "Hah!");

		user.setCountry(country);
		employedHistory.setUser(user);

		List<Skill> skills = new ArrayList<>();
		skills.add(skill);
		user.setSkills(skills);

		user2.setCountry(country);
		employedHistory2.setUser(user2);

		List<Skill> skills2 = new ArrayList<>();
		skills2.add(skill2);
		user2.setSkills(skills2);

		skillService.saveSkill(skill);
		userService.saveUser(user);
		employedHistoryService.saveEmpHistory(employedHistory);

		skillService.saveSkill(skill2);
		userService.saveUser(user2);
		employedHistoryService.saveEmpHistory(employedHistory2);


	}

	public void getAllData(){
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
}


