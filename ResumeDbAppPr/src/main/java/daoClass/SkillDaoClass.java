package daoClass;

import connection.ConnectToMysql;
import daoInter.SkillDaoInter;
import model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoClass extends ConnectToMysql implements SkillDaoInter {

    private Skill getSkill(ResultSet rs) throws Exception{
        int id = rs.getInt("id");
        String skillName = rs.getString("skill_name");

        return new Skill(id, skillName);
    }

    @Override
    public List<Skill> getAllSkill() {
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
                    "*  " +
                    "FROM " +
                    "skill");


            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                Skill s = getSkill(resultSet);
                result.add(s);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
