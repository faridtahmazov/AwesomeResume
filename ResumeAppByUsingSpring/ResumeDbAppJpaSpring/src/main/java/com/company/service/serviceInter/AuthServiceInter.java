package com.company.service.serviceInter;

import com.company.model.Authority;
import com.company.model.Role;

import java.util.List;

public interface AuthServiceInter {

    Boolean saveGroup(Authority group);

    Boolean updateGroup(Authority group);

    Boolean removeGroup(Authority group);

    List<Authority> findGroups();

    Authority findGroupsById(Integer id);

    List<Authority> findGroupsByRole(Role role);

    Authority findGroupByUser();

    List<Object[]> findGroupsAndRoles();

    List<Object[]> findGroupsAndRolesById(Integer id);

    List<Object[]> findGroupsAndRolesByRoleId(Role role);
}
