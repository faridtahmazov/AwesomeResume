package com.company.repository.repositoryImpl;

import com.company.model.Authority;
import com.company.model.Role;
import com.company.repository.repositoryInter.AuthorityRepositoryInter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AuthorityRepositoryImpl implements AuthorityRepositoryInter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean saveGroup(Authority group) {
        if (this.entityManager.contains(group)){
            this.entityManager.merge(group);
        }else{
            this.entityManager.persist(group);
        }

        return true;
    }

    @Override
    public Boolean updateGroup(Authority group) {
        try {
            this.entityManager.merge(group);
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeGroup(Authority authority) {
        try {
            if (this.entityManager.contains(authority)){
                this.entityManager.remove(authority);
            }else {
                Authority deletedUser = findGroupsById(authority.getAuthId());
                this.entityManager.remove(deletedUser);
            }
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Authority> findGroups() {
        return null;
    }

    @Override
    public Authority findGroupsById(Integer id) {
        return null;
    }

    @Override
    public List<Authority> findGroupsByRole(Role role) {
        return null;
    }

    @Override
    public Authority findGroupByUser() {
        return null;
    }

    @Override
    public List<Object[]> findGroupsAndRoles() {
        return null;
    }

    @Override
    public List<Object[]> findGroupsAndRolesById(Integer id) {
        return null;
    }

    @Override
    public List<Object[]> findGroupsAndRolesByRoleId(Role role) {
        return null;
    }
}
