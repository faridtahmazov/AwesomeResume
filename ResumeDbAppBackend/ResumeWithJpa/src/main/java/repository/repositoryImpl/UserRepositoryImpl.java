package repository.repositoryImpl;

import model.Skill;
import model.User;
import queries.UserQuery;
import repository.repositoryInter.UserRepositoryInter;

import javax.persistence.*;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryInter {
    EntityManager entityManager = entityFactory.getEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Boolean saveUser(User user) {
        try {
            this.transaction.begin();
            this.entityManager.persist(user);
            this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try {
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateUser(User user) {
        try {
            this.transaction.begin();
            this.entityManager.merge(user);
            this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try {
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeUser(User user) {
        try {
            if (this.entityManager.contains(user)){
                this.entityManager.remove(user);
            }else {
                User deletedUser = findUserById(user.getUserId());
                this.entityManager.remove(deletedUser);
            }
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try{
                this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public List<User> findUsers() {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findUsers, User.class);
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public User findUserById(Integer userId) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findUserById, User.class);
            typedQuery.setParameter("userId", userId);
            user = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public List<User> findUserDetails() {
        List<User> users = null;
        try{
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findUserDetails, User.class);
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public User findUserDetailById(Integer userId) {
        User user = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findUserDetailsById, User.class);
            typedQuery.setParameter("userId", userId);
            user = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return user;
    }

    @Override
    public List<User> findLikeUserName(String hint) {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findLikeUserName, User.class);
            typedQuery.setParameter("userName", "%" + hint + "%");
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public List<User> findInSkillName(String skillName1, String skillName2) {
        List<User> users = null;
        try{
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findInSkillName, User.class);
            typedQuery.setParameter("skillName1", skillName1);
            typedQuery.setParameter("skillName2", skillName2);
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public List<User> findOrderByUser() {
        List<User> users = null;
        try {
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findOrderByUser, User.class);
            users = typedQuery.getResultList();
        }catch (NoResultException e) {
            System.out.println("Error: " + e);
        }
        return users;
    }

    @Override
    public List<User> findUserBySkill(Skill skill) {
        List<User> users = null;
        try{
            TypedQuery<User> typedQuery = this.entityManager.createQuery(UserQuery.findUserBySkill, User.class);
            typedQuery.setParameter("skillId", skill.getSkillId());
            users = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return users;
    }
}
