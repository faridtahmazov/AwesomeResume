package daoClass;

import connection.ConnectToMysql;
import daoInter.UserSkillDaoInter;
import model.Skill;
import model.User;
import model.UserSkill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoClass extends ConnectToMysql implements UserSkillDaoInter {

    private UserSkill getUserSkill(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        int skillId = rs.getInt("skill_id");
        int userId = rs.getInt("user_id");
        int power = rs.getInt("power");
        String skillName = rs.getString("skill_name");

        return new UserSkill(null, new User(userId), new Skill(skillId, skillName), power);
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT  " +
                    "u.id, u.name, u.surname, u.email, u.phone, u.profile_description, u.address, u.birth_date, " +
                    "s.skill_name, " +
                    "us.* " +
                    "FROM " +
                    "user_skill us " +
                    "LEFT JOIN USER u ON us.user_id = u.id " +
                    "LEFT JOIN Skill s ON us.skill_id = s.id " +
                    "WHERE u.id = ?;");
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                UserSkill u = getUserSkill(resultSet);
                result.add(u);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
