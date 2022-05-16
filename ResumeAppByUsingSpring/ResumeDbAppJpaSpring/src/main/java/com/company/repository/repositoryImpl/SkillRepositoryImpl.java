package com.company.repository.repositoryImpl;

import com.company.model.Skill;
import com.company.model.User;
import com.company.queries.SkillQuery;
import com.company.repository.repositoryInter.SkillRepositoryInter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SkillRepositoryImpl implements SkillRepositoryInter {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean saveSkill(Skill skill) {
//        try{
            //         this.transaction.begin();
            this.entityManager.persist(skill);
            //        this.transaction.commit();
//        }catch (RuntimeException e){
//            System.out.println("Error: ");
//            try {
//                //            transaction.rollback();
//            }catch (RollbackException e2){
//                System.out.println("Error: " + e2);
//            }
//            return false;
//        }
        return true;
    }

    @Override
    public Boolean updateSkill(Skill skill) {
        try{
            //      this.transaction.begin();
            this.entityManager.merge(skill);
            //     this.transaction.commit();
        }catch (RuntimeException e){
            System.out.println("Error: ");
            try {
                //         transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeSkill(Skill skill) {
        try {
            if (this.entityManager.contains(skill)){
                this.entityManager.remove(skill);
            }else {
                Skill deletedSkill = findSkillById(skill.getSkillId());
                this.entityManager.remove(deletedSkill);
            }
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            try{
                //        this.transaction.rollback();
            }catch (RollbackException e2){
                System.out.println("Error: " + e2);
            }
            return false;
        }
        return true;
    }

    @Override
    public List<Skill> findSkills() {
        List<Skill> skills = null;
        try{
            TypedQuery<Skill> typedQuery = this.entityManager.createQuery(SkillQuery.findSkills, Skill.class);
            skills = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return skills;
    }

    @Override
    public Skill findSkillById(Integer skillId) {
        Skill skill = null;
        try{
            TypedQuery<Skill> typedQuery = this.entityManager.createQuery(SkillQuery.findSkillById, Skill.class);
            typedQuery.setParameter("skillId", skillId);
            skill = typedQuery.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return skill;
    }

    @Override
    public List<Skill> findSkillsByUser(User user) {
        List<Skill> skills = null;
        try{
            TypedQuery<Skill> typedQuery = this.entityManager.createQuery(SkillQuery.findSkillsByUser, Skill.class);
            typedQuery.setParameter("userId", user.getUserId());
            skills = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return skills;
    }

    @Override
    public List<Skill> findLikeSkillName(String skillHint) {
        List<Skill> skills = null;
        try{
            TypedQuery<Skill> typedQuery = this.entityManager.createQuery(SkillQuery.findLikeSkillName, Skill.class);
            typedQuery.setParameter("skillHint", skillHint);
            skills = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return skills;
    }

    @Override
    public List<Skill> findInSkillName(String skillName1, String skillName2) {
        List<Skill> skills = null;
        try{
            TypedQuery<Skill> typedQuery = this.entityManager.createQuery(SkillQuery.findInSkillName, Skill.class);
            typedQuery.setParameter("skillName1", skillName1);
            typedQuery.setParameter("skillName2", skillName2);
            skills = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return skills;
    }

    @Override
    public List<Skill> findOrderBySkill() {
        List<Skill> skills = null;
        try{
            TypedQuery<Skill> typedQuery = this.entityManager.createQuery(SkillQuery.findOrderBySkill, Skill.class);
            skills = typedQuery.getResultList();
        }catch (NoResultException e){
            System.out.println("Error: " + e);
        }
        return skills;
    }
}
