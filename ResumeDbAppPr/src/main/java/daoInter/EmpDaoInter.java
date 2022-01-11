package daoInter;

import model.EmployedHistory;

import java.util.List;

public interface EmpDaoInter {
    List<EmployedHistory> getAllEmployedHistoryByUserId(int userId);
}
