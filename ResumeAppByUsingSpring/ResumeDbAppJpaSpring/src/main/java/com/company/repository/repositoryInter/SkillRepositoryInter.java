package com.company.repository.repositoryInter;

import com.company.model.Skill;
import com.company.model.User;

import java.util.List;

public interface SkillRepositoryInter {
//    EntityFactory entityFactory = new EntityFactoryImpl();

    Boolean saveSkill(final Skill skill);

    Boolean updateSkill(final Skill skill);

    Boolean removeSkill(final Skill skill);

    List<Skill> findSkills();

    Skill findSkillById(final Integer skillId);

    List<Skill> findSkillsByUser(final User user);

    List<Skill> findLikeSkillName(final String skillHint);

    List<Skill> findInSkillName(final String skillName1, final String skillName2);

    List<Skill> findOrderBySkill();
}
