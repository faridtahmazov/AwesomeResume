package com.company.queries;

public class RoleQuery {
    public static String findRoles = "SELECT r FROM Role r";

    public static String findRolesByGroup = "SELECT r FROM Role r WHERE r.groups.groupId = :groupId";

    public static String findRolesById = "SELECT r FROM Role r WHERE r.roleId = :roleId";

}
