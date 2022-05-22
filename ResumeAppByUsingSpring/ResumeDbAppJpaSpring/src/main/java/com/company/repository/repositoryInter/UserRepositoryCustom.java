package com.company.repository.repositoryInter;

import com.company.model.Skill;
import com.company.model.User;

import java.util.List;

public interface UserRepositoryCustom {
//    EntityFactory entityFactory = new EntityFactoryImpl();

    Boolean saveUser(final User user);

    Boolean updateUser(final User user);

    Boolean removeUser(final User user);

    List<User> findUsers();

    User findUserById(final Integer userId);

    User findUserByUsername(final String username);

    List<User> findUserDetails();

    User findUserDetailById(final Integer userId);

    User findUserDetailByUsername(final String username);

    List<User> findLikeUserName(final String hint);

    List<User> findLikeUsername(final String usernameHint);

    List<User> findUserBySkill(final Skill skill);

    List<User> findInSkillName(final String skillName1, final String skillName2);

    List<User> findOrderByUser();

    List<User> findOrderByUsername();

    List<User> findUsersByGroup();

    List<Object[]> findUsersAndGroups();

    List<Object[]> findRoleAndUsers();

    List<Object[]> findRolesByUser();
}
