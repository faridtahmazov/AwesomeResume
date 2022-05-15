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
        String profDesc = resultSet.getString("profile_description");
        String address = resultSet.getString("address");
        Date birthDate = resultSet.getDate("birth_date");
        int nationalityId = resultSet.getInt("nationality_id");
        int countryId = resultSet.getInt("country_id");

        String countryStr = resultSet.getString("country");
        String nationalityStr = resultSet.getString("nationality");
        
        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country country = new Country(countryId, countryStr, null);

        return new User(id, name, surname, email, phone, profDesc, address, birthDate, country, nationality);
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        try(Connection c = connect()){
            Statement statement = c.createStatement();
            statement.execute("SELECT " +
                    "u.id, u.name, u.surname, u.email, u.phone, u.profile_description, u.address, u.birth_date, country_id, u.nationality_id, " +
                    "c.country, n.nationality, " +
                    "emp.header, emp.begin_date, emp.end_date, emp.job_description, " +
                    "s.skill_name, " +
                    "us.power  " +
                    "FROM " +
                    "user_skill us " +
                    "LEFT JOIN USER u ON us.user_id = u.id " +
                    "LEFT JOIN employed_history emp ON u.id = emp.user_id " +
                    "LEFT JOIN country n ON u.nationality_id = n.id " +
                    "LEFT JOIN country c on u.country_id = c.id " +
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
    public User getById(int id){
        User result = null;
        try(Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
"	u.*, " +
"	n.nationality, " +
"       c.country, " +
"	emp.*, " +
"	s.*, " +
"	us.*  " +
"FROM " +
"	user_skill us " +
"	LEFT JOIN USER u ON us.user_id = u.id " +
"	LEFT JOIN employed_history emp ON u.id = emp.user_id " +
"	LEFT JOIN country n ON u.nationality_id = n.id " +
"       LEFT JOIN country c on u.country_id = c.id " +
"	LEFT JOIN skill s ON us.skill_id = s.id "
                    + "Where u.id = ?;");
            preparedStatement.setInt(1, id);
            System.out.println("id:"+id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                result = getUser(resultSet);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean update(User u) {
        try(Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("UPDATE user " +
                    "SET name=?, surname=?, email=?, phone=?, profile_description=?, "
                    + "address = ?, birth_date=?, country_id=? ,nationality_id=? " +
                    "WHERE id = ?;");
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getSurname());
            preparedStatement.setString(3, u.getEmail());
            preparedStatement.setString(4, u.getPhone());
            preparedStatement.setString(5, u.getProfileDescription());
            preparedStatement.setString(6, u.getAddress());
            preparedStatement.setDate(7, u.getBirthdate());
            preparedStatement.setInt(8, u.getCountry().getId());
            preparedStatement.setInt(9, u.getNationality().getId());
            preparedStatement.setInt(10, u.getId());
                
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
