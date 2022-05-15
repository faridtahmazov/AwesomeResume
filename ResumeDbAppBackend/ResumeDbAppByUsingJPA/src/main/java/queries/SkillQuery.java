package queries;

public class SkillQuery {
    public static final String findSkills = "SELECT s FROM Skill s";

    public static final String findSkillById = "SELECT s FROM Skill s WHERE s.skillId = :skillId";

    public static final String findSkillsByUser = "SELECT s.skill, u.name, u.surname, u.userId FROM Skill s " +
            "LEFT JOIN s.user u WHERE u.userId=:userId";

    public static final String findLikeSkillName = "SELECT s FROM Skill s WHERE s.skill LIKE :skillHint";

    public static final String findInSkillName = "SELECT u.userId, u.name, u.surname, s.skill FROM User u LEFT JOIN u.skills s " +
            "WHERE s.skill IN(:skillName1, :skillName2)"; //Parametre daxil olan butun categoryleri getir

    public static final String findOrderBySkill = "SELECT s FROM Skill s ORDER BY s.skill DESC"; //qiymete gore kicikden boyuye
}
