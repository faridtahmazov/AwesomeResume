package com.company.repository.repositoryImpl;

import com.company.model.Authority;
import com.company.model.Role;
import com.company.repository.repositoryInter.RoleRepositoryInter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleRepositoryImpl implements RoleRepositoryInter {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Boolean saveRole(Role role) {
        try {
            this.entityManager.persist(role);
            this.entityManager.flush();
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateRole(Role role) {
        try {
            this.entityManager.merge(role);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean removeRole(Role role) {
        try {
            if (this.entityManager.contains(role)){
                this.entityManager.remove(role);
            }else {
                Role deletedUser = findRolesById(role.getRoleId());
                this.entityManager.remove(deletedUser);
            }
        }catch (RuntimeException e){
            System.out.println("Error: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Role> findRoles() {
        return null;
    }

    @Override
    public Role findRolesById(Integer id) {
        return null;
    }

    @Override
    public List<Role> findRolesByGroup(Authority group) {
        return null;
    }
}
