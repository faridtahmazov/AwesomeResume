package com.company.service.serviceInter;

import com.company.model.Skill;
import com.company.model.User;

import java.util.List;

public interface UserServiceInter {

    Boolean saveUser(final User user);

    Boolean updateUser(final User user);

    Boolean removeUser(final User user);

    List<User> findUsers();

    User findUserByUsername(final String username);

    User findUserById(final Integer userId);

    List<User> findUserDetails();

    User findUserDetailById(final Integer userId);

    List<User> findLikeUserName(final String hint);

    List<User> findUserBySkill(final Skill skill);

    List<User> findInSkillName(final String skillName1, final String skillName2);

    List<User> findOrderByUser();
}
