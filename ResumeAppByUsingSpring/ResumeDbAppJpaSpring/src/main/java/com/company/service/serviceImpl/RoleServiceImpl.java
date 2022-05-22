package com.company.service.serviceImpl;

import com.company.model.Authority;
import com.company.model.Role;
import com.company.repository.repositoryInter.RoleRepositoryInter;
import com.company.service.serviceInter.RoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Qualifier("roleService")
public class RoleServiceImpl implements RoleServiceInter {

    @Autowired(required = false)
    @Qualifier("roleRepositoryImpl")
    private RoleRepositoryInter roleRepositoryInter;

    @Override
    public Boolean saveRole(Role role) {
        return this.roleRepositoryInter.saveRole(role);
    }

    @Override
    public Boolean updateRole(Role role) {
        return this.roleRepositoryInter.updateRole(role);
    }

    @Override
    public Boolean removeRole(Role role) {
        return this.roleRepositoryInter.removeRole(role);
    }

    @Override
    public List<Role> findRoles() {
        return this.roleRepositoryInter.findRoles();
    }

    @Override
    public Role findRolesById(Integer id) {
        return this.roleRepositoryInter.findRolesById(id);
    }

    @Override
    public List<Role> findRolesByGroup(Authority group) {
        return this.roleRepositoryInter.findRolesByGroup(group);
    }
}
