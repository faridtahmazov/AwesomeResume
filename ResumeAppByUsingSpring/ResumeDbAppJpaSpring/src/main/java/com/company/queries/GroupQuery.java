package com.company.queries;

public class GroupQuery {
    public static String findGroups = "SELECT g FROM Group g";

    public static String findGroupsByRole = "SELECT g FROM Group g WHERE g.role.roleId = :roleId";

    public static String findGroupsById = "SELECT g FROM Group g WHERE g.groupId = :groupId";

    public static String findGroupByUser = "SELECT g FROM Group g WHERE g.users.userId = :userId";

    public static String findGroupsAndRoles = "SELECT g.groupName, r.roleName FROM Group g " +
            "LEFT JOIN g.role r";

    public static String findGroupsAndRolesById = "SELECT g.groupId, g.groupName, r.role, r.roleId FROM Group g " +
            "LEFT JOIN g.role r WHERE g.groupId = :groupId";

    public static String findGroupsAndRolesByRoleId = "SELECT g.groupId, g.groupName, r.role, r.roleId FROM Group g " +
            "LEFT JOIN g.role r WHERE r.roleId = :roleId";

}
