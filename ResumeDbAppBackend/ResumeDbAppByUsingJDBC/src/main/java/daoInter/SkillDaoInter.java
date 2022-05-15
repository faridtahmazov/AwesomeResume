package daoInter;

import model.Skill;

import java.util.List;
import model.User;

public interface SkillDaoInter {
    List<Skill> getAllSkill();
    List<Skill> getSkillUserById(User id);
    Skill getSkillById(User id);
    boolean insertSkill(Skill s);
    
}
