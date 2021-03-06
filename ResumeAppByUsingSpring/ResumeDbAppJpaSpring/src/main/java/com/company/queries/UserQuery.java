package com.company.queries;

public class UserQuery {
    public static final String findUsers = "SELECT u FROM User u";

    public static final String findUserById = "SELECT u FROM User u WHERE u.userId = :userId";

    public static final String findByLoginUserUsername = "SELECT u FROM User u WHERE u.loginUsers.username = :username";

    public static final String findUserDetails = "Select new model.User" +
            "(u.name, u.surname, u.email, u.phone, e.header, s.skill) " +
            "FROM User u LEFT JOIN u.employedHistories e LEFT JOIN u.skills s";

    public static final String findUserDetailsById = "Select new model.User" +
            "(u.name, u.surname, u.email, u.phone, e.header, s.skill) " +
            "FROM User u LEFT JOIN u.employedHistories e LEFT JOIN u.skills s WHERE u.userId = :userId";

    public static final String findUserDetailsByUsername = "Select new model.User" +
            "(u.name, u.surname, u.email, u.phone, e.header, s.skill) " +
            "FROM User u LEFT JOIN u.employedHistories e LEFT JOIN u.skills s WHERE u.username = :username";

    public static final String findUserBySkill = "SELECT u.userId, u.name, u.surname, s.skill FROM User u " +
            "LEFT JOIN u.skills s WHERE s.skillId = :skillId";

    public static final String findLikeUserName = "SELECT u FROM User u WHERE u.name LIKE :userName";


    public static final String findLikeUsername = "SELECT u FROM User u WHERE u.username LIKE :username";

    public static final String findInSkillName = "SELECT u.userId, u.name, u.surname, s.skill FROM User u LEFT JOIN u.skills s " +
            "WHERE s.skill IN(:skillName1, :skillName2)"; //Parametre daxil olan butun categoryleri getir

    public static final String findOrderByUser = "SELECT u FROM User u ORDER BY u.name DESC"; //qiymete gore kicikden boyuye


    public static final String findOrderByUsername = "SELECT u FROM User u ORDER BY u.username DESC"; //qiymete gore kicikden boyuye

    public static String findUsersByGroup = "SELECT g, u FROM User u " +
            "LEFT JOIN u.group g WHERE g.groupId = :groupId";

    public static String findUsersAndGroups = "SELECT g, u FROM User u " +
            "LEFT JOIN u.group g";

    public static String findRoleAndUsers = "SELECT r, u FROM User u " +
            "LEFT JOIN u.group.roles r";

    public static String findRolesByUser = "SELECT r, u FROM User u " +
            "LEFT JOIN u.group.roles r WHERE u.userId = :userId";
}
