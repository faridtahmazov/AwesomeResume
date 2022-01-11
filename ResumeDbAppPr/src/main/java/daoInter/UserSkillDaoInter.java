package daoInter;

import model.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAllSkillByUserId(int userId);
}
