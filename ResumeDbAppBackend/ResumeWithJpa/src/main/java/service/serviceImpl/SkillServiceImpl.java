package service.serviceImpl;

import model.Skill;
import model.User;
import repository.repositoryImpl.SkillRepositoryImpl;
import repository.repositoryInter.SkillRepositoryInter;
import service.serviceInter.SkillServiceInter;

import java.util.List;

public class SkillServiceImpl implements SkillServiceInter {
    private SkillRepositoryInter skillRepositoryInter = new SkillRepositoryImpl();

    @Override
    public Boolean saveSkill(Skill skill) {
        return this.skillRepositoryInter.saveSkill(skill);
    }

    @Override
    public Boolean updateSkill(Skill skill) {
        return this.skillRepositoryInter.updateSkill(skill);
    }

    @Override
    public Boolean removeSkill(Skill skill) {
        return this.skillRepositoryInter.removeSkill(skill);
    }

    @Override
    public List<Skill> findSkills() {
        return this.skillRepositoryInter.findSkills();
    }

    @Override
    public Skill findSkillById(Integer skillId) {
        return this.skillRepositoryInter.findSkillById(skillId);
    }

    @Override
    public List<Skill> findSkillsByUser(User user) {
        return this.skillRepositoryInter.findSkillsByUser(user);
    }

    @Override
    public List<Skill> findLikeSkillName(String skillHint) {
        return this.skillRepositoryInter.findLikeSkillName(skillHint);
    }

    @Override
    public List<Skill> findInSkillName(String skillName1, String skillName2) {
        return this.skillRepositoryInter.findInSkillName(skillName1, skillName2);
    }

    @Override
    public List<Skill> findOrderBySkill() {
        return this.skillRepositoryInter.findOrderBySkill();
    }
}
