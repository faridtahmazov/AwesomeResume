package com.company;

import com.company.model.*;
import com.company.model.util.AuthUtil;
import com.company.model.util.RoleUtil;
import com.company.service.serviceInter.*;
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

	@Autowired
	@Qualifier("authService")
	private AuthServiceInter authService;

	@Autowired
	@Qualifier("roleService")
	private RoleServiceInter roleService;

    public static void main(String[] args) {
        SpringApplication.run(ResumeDbAppJpaSpringApplication.class, args);
    }

	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {}
		};

		return clr;
	}

	public void insertData(){
		Country country = new Country("Azerbaijan", "Azerbaijani");
		User user = new User("Farid", "Tahmazov", "tahmazovfarid7@gmail.com",
				"055-977-32-37", "Hii", "Baku", new Date());
		LoginUser loginUser = new LoginUser("tahmazovfarid", "1234");
		user.setLoginUsers(loginUser);
		Skill skill = new Skill("Java");

		User user2 = new User("Beyim", "Mehreliyeva", "ruslanguliyev@gmail.com",
				"055-555-55-55", "Hii", "Ganja", new Date());

		LoginUser loginUser2 = new LoginUser("mehbeyim", "0000");
		user2.setLoginUsers(loginUser2);
		Skill skill2 = new Skill("Php");

		EmployedHistory employedHistory = new EmployedHistory("Java Software Developer", new Date(),
				new Date(), "Im very ability!");

		EmployedHistory employedHistory2 = new EmployedHistory("Php Software Developer", new Date(),
				new Date(), "Hah!");

		Authority adminGroup = new Authority(AuthUtil.ADMIN.name());
		Authority userGroup = new Authority(AuthUtil.USER.name());

		Role adminRole = new Role(RoleUtil.SEE_USERS.name());
		Role userRole = new Role(RoleUtil.SEE_USER.name());

		List<Role> adminRoles = new ArrayList<>();
		adminRoles.add(adminRole);
		adminGroup.setRoles(adminRoles);

		List<Role> userRoles = new ArrayList<>();
		userRoles.add(userRole);
		userGroup.setRoles(userRoles);

		user.setAuthority(adminGroup);
		user2.setAuthority(userGroup);

		List<Country> countries = new ArrayList<>();
		countries.add(country);

		user.setCountry(countries);
		employedHistory.setUser(user);

		List<Skill> skills = new ArrayList<>();
		skills.add(skill);
		user.setSkills(skills);

		List<Country> countries2 = new ArrayList<>();
		countries2.add(country);

		user2.setCountry(countries2);
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


