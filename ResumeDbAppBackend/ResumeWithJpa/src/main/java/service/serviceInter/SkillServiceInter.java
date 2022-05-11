package service.serviceInter;

import factory.impl.EntityFactoryImpl;
import factory.inter.EntityFactory;
import model.Skill;
import model.User;

import java.util.List;

public interface SkillServiceInter {

    Boolean saveSkill(final Skill skill);

    Boolean updateSkill(final Skill skill);

    Boolean removeSkill(final Skill skill);

    List<Skill> findSkills();

    Skill findSkillById(final Integer skillId);

    List<Skill> findSkillsByUser(final User user);

    List<Skill> findLikeSkillName(final String skillHint);

    List<Skill> findInSkillName(final String skillName1, String skillName2);

    List<Skill> findOrderBySkill();
}
