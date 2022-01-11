package daoClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectToMysql;
import daoInter.UserDaoInter;
import model.Country;
import model.User;

public class UserDaoClass extends ConnectToMysql implements UserDaoInter {

    private User getUser(ResultSet resultSet) throws Exception{
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Date birthDate = resultSet.getDate("birth_date");
        int nationalityId = resultSet.getInt("nationality_id");

        String country = resultSet.getString("country");
        String nationalityStr = resultSet.getString("nationality");
        Country nationality = new Country(nationalityId, country, nationalityStr);

        return new User(id, name, surname, email, phone, birthDate, nationality);
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try(Connection c = connect()){
            Statement statement = c.createStatement();
            statement.execute("SELECT " +
                    "u.id, u.name, u.surname, u.email, u.phone, u.profile_description, u.address, u.birth_date, u.nationality_id, " +
                    "n.country, n.nationality, " +
                    "emp.header, emp.begin_date, emp.end_date, emp.job_description, " +
                    "s.skill_name, " +
                    "us.power  " +
                    "FROM " +
                    "user_skill us " +
                    "LEFT JOIN USER u ON us.user_id = u.id " +
                    "LEFT JOIN employed_history emp ON u.id = emp.user_id " +
                    "LEFT JOIN country n ON u.nationality_id = n.id " +
                    "LEFT JOIN skill s ON us.skill_id = s.id;");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                User u = getUser(resultSet);
                list.add(u);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }


    @Override
    public List<User> getById(int id){
        List<User> list = new ArrayList<>();
        try(Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
                    "u.*, " +
                    "s.*, " +
                    "n.*, " +
                    "emp.*, " +
                    "us.* " +
                    "FROM user_skill us " +
                    "Left JOIN user u on us.user_id = u.user_id " +
                    "Left Join employed_histroy emp on u.employed_id = emp.id " +
                    "LEFT JOIN country n on u.nationality_id = n.id " +
                    "left JOIN skill s on us.skill_id = s.id " +
                    "Where u.id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                User u = getUser(resultSet);
                list.add(u);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean update(String field, int id, String set) {
        try(Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("UPDATE user " +
                    "SET " + field + " = ? " +
                    "WHERE id = ?;");
            preparedStatement.setString(1, set);
            preparedStatement.setInt(2, id);

            return preparedStatement.execute();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try(Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("DELETE FROM user " +
                    "WHERE id = ?;");
            preparedStatement.setInt(1, id);

            return preparedStatement.execute();
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
