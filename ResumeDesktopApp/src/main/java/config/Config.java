package config;

import daoInter.EmpDaoInter;
import daoInter.SkillDaoInter;
import daoInter.UserDaoInter;
import daoInter.UserSkillDaoInter;
import java.util.List;
import model.Context;
import model.EmployedHistory;
import model.User;
import model.UserSkill;

public class Config {
    public static UserDaoInter userDaoInter = Context.getInstanceUserDao();
    public static SkillDaoInter skillDaoInter = Context.getInstanceSkillDao();
    public static UserSkillDaoInter userSkillDaoInter = Context.getInstanceUserSkillDao();
    public static User loggedInUser = userDaoInter.getById(3);
    public static EmpDaoInter empDaoInter = Context.getInstanceEmployedHistoryDao();
    
//    public static List<UserSkill> loggedInUserSkill = userSkillDaoInter.getAllSkillByUserId(loggedInUser.getId());
    
}
