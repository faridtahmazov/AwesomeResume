package daoInter;

import model.EmployedHistory;

import java.util.List;
import model.User;

public interface EmpDaoInter {
   List<EmployedHistory> getAllEmployedHistoryByUserId(User loggedInUser);
   boolean updateEmployedHistory(EmployedHistory emp);
}
