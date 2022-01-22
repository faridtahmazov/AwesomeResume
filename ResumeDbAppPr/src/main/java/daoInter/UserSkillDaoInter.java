package daoInter;

import model.UserSkill;
import model.User;

import java.util.List;

public interface UserSkillDaoInter {
    List<UserSkill> getAll();
    List<Integer> getAllId();
    List<UserSkill> getAllSkillByUserId(int userId);
    boolean update(UserSkill us);
    boolean addUserSkill(UserSkill us);
    boolean deleteUserSkill(int userSkillId);
}
