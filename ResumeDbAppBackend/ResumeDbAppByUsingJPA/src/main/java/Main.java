//import model.Country;
import model.Country;
import model.EmployedHistory;
import model.Skill;
import model.User;
import service.serviceImpl.EmployedHistoryServiceImpl;
import service.serviceImpl.SkillServiceImpl;
import service.serviceImpl.UserServiceImpl;
import service.serviceInter.EmployedHistoryServiceInter;
import service.serviceInter.SkillServiceInter;
import service.serviceInter.UserServiceInter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static EmployedHistoryServiceInter employedHistoryService = new EmployedHistoryServiceImpl();
    private static SkillServiceInter skillService = new SkillServiceImpl();
    private static UserServiceInter userService = new UserServiceImpl();

    public static void main(String[] args) {

//        List<Skill> skills = skillService.findSkills();
//        System.out.println("Skill: " + skills);
//
//        List<User> users = userService.findUsers();
//        System.out.println("User: " + users);
//
//        List<EmployedHistory> employedHistories = employedHistoryService.findEmpHistories();
//        System.out.println("Emp: " + employedHistories);

    }

    public static void insertData(){
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

}
