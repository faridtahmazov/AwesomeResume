package daoClass;

import connection.ConnectToMysql;
import daoInter.EmpDaoInter;
import model.EmployedHistory;
import model.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoClass extends ConnectToMysql implements EmpDaoInter {
    private EmployedHistory getAllEmployedHistory(ResultSet rs) throws Exception{
        Integer id = rs.getInt("id");
        String header = rs.getString("header");
        Date beginDate = rs.getDate("begin_date");
        Date endDate = rs.getDate("end_date");
        String jobDescription = rs.getString("job_description");
        Integer user_id = rs.getInt("user_id");

        return new EmployedHistory(null, header, beginDate, endDate, jobDescription, new User(user_id));
    }

    @Override
    public List<EmployedHistory> getAllEmployedHistoryByUserId(int userId) {
        List<EmployedHistory> result = new ArrayList<>();

        try (Connection c = connect()){
            PreparedStatement preparedStatement = c.prepareStatement("SELECT " +
                    "*  " +
                    "FROM " +
                    "employed_history  " +
                    "WHERE " +
                    "user_id = ?");
            preparedStatement.setInt(1, userId);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()){
                EmployedHistory emp = getAllEmployedHistory(resultSet);
                result.add(emp);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}
