package com.company.service.serviceImpl;

import com.company.model.Authority;
import com.company.model.Role;
import com.company.repository.repositoryInter.AuthorityRepositoryInter;
import com.company.service.serviceInter.AuthServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Qualifier("authService")
public class AuthorityServiceImpl implements AuthServiceInter {

    @Autowired(required = false)
    @Qualifier("authorityRepositoryImpl")
    private AuthorityRepositoryInter groupRepositoryInter;

    @Override
    public Boolean saveGroup(Authority group) {
        return this.groupRepositoryInter.saveGroup(group);
    }

    @Override
    public Boolean updateGroup(Authority group) {
        return this.groupRepositoryInter.updateGroup(group);
    }

    @Override
    public Boolean removeGroup(Authority group) {
        return this.groupRepositoryInter.removeGroup(group);
    }

    @Override
    public List<Authority> findGroups() {
        return this.groupRepositoryInter.findGroups();
    }

    @Override
    public Authority findGroupsById(Integer id) {
        return this.groupRepositoryInter.findGroupsById(id);
    }

    @Override
    public List<Authority> findGroupsByRole(Role role) {
        return this.groupRepositoryInter.findGroupsByRole(role);
    }

    @Override
    public Authority findGroupByUser() {
        return this.groupRepositoryInter.findGroupByUser();
    }

    @Override
    public List<Object[]> findGroupsAndRoles() {
        return this.groupRepositoryInter.findGroupsAndRoles();
    }

    @Override
    public List<Object[]> findGroupsAndRolesById(Integer id) {
        return this.groupRepositoryInter.findGroupsAndRolesById(id);
    }

    @Override
    public List<Object[]> findGroupsAndRolesByRoleId(Role role) {
        return this.groupRepositoryInter.findGroupsAndRolesByRoleId(role);
    }
}
