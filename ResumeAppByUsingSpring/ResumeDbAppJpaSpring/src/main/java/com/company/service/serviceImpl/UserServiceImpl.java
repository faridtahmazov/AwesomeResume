package com.company.service.serviceImpl;

import com.company.model.Skill;
import com.company.model.User;
import com.company.repository.repositoryInter.UserRepositoryCustom;
import com.company.service.serviceInter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@Qualifier("userService")
public class UserServiceImpl implements UserServiceInter {

    @Autowired(required = false)
    @Qualifier("userRepositoryCustomImpl")
    private UserRepositoryCustom userRepositoryInter;

    @Override
    public Boolean saveUser(User user) {
        return this.userRepositoryInter.saveUser(user);
    }

    @Override
    public Boolean updateUser(User user) {
        return this.userRepositoryInter.updateUser(user);
    }

    @Override
    public Boolean removeUser(User user) {
        return this.userRepositoryInter.removeUser(user);
    }

    @Override
    public List<User> findUsers() {
        return this.userRepositoryInter.findUsers();
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepositoryInter.findUserByUsername(username);
    }

    @Override
    public User findUserById(Integer userId) {
        return this.userRepositoryInter.findUserById(userId);
    }

    @Override
    public List<User> findUserDetails() {
        return this.userRepositoryInter.findUserDetails();
    }

    @Override
    public User findUserDetailById(Integer userId) {
        return this.userRepositoryInter.findUserDetailById(userId);
    }

    @Override
    public List<User> findLikeUserName(String hint) {
        return this.userRepositoryInter.findLikeUserName(hint);
    }

    @Override
    public List<User> findUserBySkill(Skill skill) {
        return this.userRepositoryInter.findUserBySkill(skill);
    }

    @Override
    public List<User> findInSkillName(String skillName1, String skillName2) {
        return this.userRepositoryInter.findInSkillName(skillName1, skillName2);
    }

    @Override
    public List<User> findOrderByUser() {
        return this.userRepositoryInter.findOrderByUser();
    }
}
