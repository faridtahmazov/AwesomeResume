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

        return new UserSkill(id, new User(userId), new Skill(skillId, skillName), power);
    }
    
    @Override
    public List<UserSkill> getAll(){
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
                                    "s.skill_name," +
                                    "us.* " +
                                    "FROM " +
                                    "	user_skill us " +
                                    "LEFT JOIN skill s on us.skill_id = s.id;");
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                result.add(getUserSkill(rs));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
                                            "s.skill_name, " +
                                            "us.*  " +
                                            "FROM " +
                                            "user_skill us " +
                                            "LEFT JOIN Skill s ON us.skill_id = s.id " +
                                            "WHERE " +
                                            "user_id = ?;");
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                UserSkill us = getUserSkill(resultSet);
                result.add(us);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(UserSkill userSkill) {
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("UPDATE user_skill \n" +
                                                            "skill_id = ?, " +
                                                            "power = ? " +
                                                            "WHERE " +
                                                            "user_id =?;");
            
            preparedStatement.setInt(1, userSkill.getSkill().getId());
            preparedStatement.setInt(2, userSkill.getPower());
            preparedStatement.setInt(3, userSkill.getUser().getId());
            
            return preparedStatement.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUserSkill(int userSkillId) {
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM user_skill where id = ?");
            preparedStatement.setInt(1, userSkillId);
            return preparedStatement.execute();
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO "
                    + "user_skill(user_id, skill_id, power) "
                    + "VALUES(?, ?, ?);");
     System.out.println("Skill Id: " + us.getSkill().getId());
            preparedStatement.setInt(1, us.getUser().getId());
            preparedStatement.setInt(2, us.getSkill().getId());
            
            preparedStatement.setInt(3, us.getPower());
            
            return preparedStatement.execute();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Integer> getAllId() {
        List<Integer> result = new ArrayList<>();
        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
                                    "us.id " +
                                    "FROM " +
                                    "	user_skill us ");
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()){
                Integer id = rs.getInt("id");
                result.add(id);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
