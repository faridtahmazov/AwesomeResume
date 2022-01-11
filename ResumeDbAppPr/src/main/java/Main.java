import daoInter.EmpDaoInter;
import daoInter.SkillDaoInter;
import daoInter.UserDaoInter;
import daoInter.UserSkillDaoInter;
import model.EmployedHistory;
import model.Skill;
import model.User;
import model.UserSkill;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoInter userDaoClass = Context.getInstanceUserDao();
        UserSkillDaoInter userSkillDaoInter = Context.getInstanceUserSkillDao();
        EmpDaoInter empDaoInter = Context.getInstanceEmployedHistoryDao();
        SkillDaoInter skillDaoInter = Context.getInstanceSkillDao();

        List<User> user = userDaoClass.getAll();
        List<UserSkill> userSkill = userSkillDaoInter.getAllSkillByUserId(1);
        List<EmployedHistory> emp = empDaoInter.getAllEmployedHistoryByUserId(1);
        List<Skill> skill = skillDaoInter.getAllSkill();

        System.out.println(skill);
    }
}
