package com.company.service.serviceInter;

import com.company.model.Authority;
import com.company.model.Role;

import java.util.List;

public interface RoleServiceInter {

    Boolean saveRole(Role role);

    Boolean updateRole(Role role);

    Boolean removeRole(Role role);

    List<Role> findRoles();

    Role findRolesById(Integer id);

    List<Role> findRolesByGroup(Authority group);
}
