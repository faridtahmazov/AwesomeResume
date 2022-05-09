package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static controller.UsersController.connectToMysql;

public class UserDao {
    public PreparedStatement searchBy(String query) throws SQLException {
        Connection connection = connectToMysql();
        PreparedStatement data = connection.prepareStatement(
        "SELECT id, name, surname, email " +
            "FROM user " +
            "WHERE id LIKE '%"+ query +"%' OR NAME LIKE '%"+ query +"%' OR surname LIKE '%"+ query +"%' OR email LIKE '%"+ query +"%';");
        data.execute();

        return data;
    }

    public PreparedStatement printAll() throws SQLException {
        Connection connection = connectToMysql();
        PreparedStatement data = connection.prepareStatement("SELECT id, name, surname, email FROM user");
        data.execute();

        return data;
    }

    public ResultSet getAll(Integer id) throws SQLException {
        Connection connection = connectToMysql();
        PreparedStatement data = connection.prepareStatement(
                "SELECT u.id, u.name, u.surname, u.email, u.phone, u.profile_description, u.address, " +
                "    u.birth_date, country_id, u.nationality_id, c.country, n.nationality, emp.header," +
                "    temp.begin_date, emp.end_date, emp.job_description, s.skill_name, us.power  " +
                "FROM user_skill us " +
                "LEFT JOIN USER u ON us.user_id = u.id " +
                "LEFT JOIN employed_history emp ON u.id = emp.user_id " +
                "LEFT JOIN country n ON u.nationality_id = n.id " +
                "LEFT JOIN country c on u.country_id = c.id " +
                "LEFT JOIN skill s ON us.skill_id = s.id " +
                "WHERE u.id=?;");
        data.setInt(1, id);
        data.execute();

        ResultSet resultSet = data.getResultSet();
        return resultSet;
    }

    public PreparedStatement getSkillsByUserID(Integer userId) throws SQLException{
        Connection connect = connectToMysql();
        PreparedStatement data = connect.prepareStatement("SELECT us.user_id, s.skill_name, us.power " +
                "FROM user_skill us " +
                "LEFT JOIN Skill s ON us.skill_id = s.id " +
                "WHERE user_id = ?;");
        data.setInt(1, userId);
        data.execute();

        return data;
    }


}
