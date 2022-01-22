package daoClass;

import connection.ConnectToMysql;
import daoInter.SkillDaoInter;
import model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import model.User;

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
    
    @Override
    public List<Skill> getSkillUserById(User user){
        List<Skill> result = new ArrayList<>();
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("select s.* from user_skill us " +
                                        "LEFT JOIN skill s on us.skill_id = s.id " +
                                        "where us.user_id = ?");

            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                Skill skill = getSkill(resultSet);
                result.add(skill);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
       
    }
    
    @Override
    public Skill getSkillById(User user){
        Skill result = null;
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("select * from skill" +
                                        "where id = ?");
            preparedStatement.setInt(1, user.getId());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()){
                String skill = resultSet.getString("skill_name");
                
                result = getSkill(resultSet);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
       
    }

    @Override
    public boolean insertSkill(Skill s) {
        boolean bool = true;
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO skill (skill_name) " +
                                                                    "VALUES (?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, s.getName());
            bool = preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()){
                s.setId(generatedKeys.getInt(1));
            }
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return bool;
    }
}
