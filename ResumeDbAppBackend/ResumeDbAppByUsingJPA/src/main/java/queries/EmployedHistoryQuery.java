package queries;

public class EmployedHistoryQuery {
    public static final String findEmpHistories = "SELECT e FROM EmployedHistory e";

    public static final String findEmpHistoriesById = "SELECT e FROM EmployedHistory e WHERE e.employeeId = :employeeId";

    public static final String findEmpHistoriesByUser = "SELECT e.header, u.name, u.surname, u.userId FROM EmployedHistory e " +
            "LEFT JOIN e.user u WHERE u.userId=:userId";

    public static final String findLikeEmpHistory = "SELECT e FROM EmployedHistory e WHERE e.header LIKE :headerHint";

    public static final String findOrderByEmpHistory= "SELECT e FROM EmployedHistory e ORDER BY e.header DESC"; //qiymete gore kicikden boyuye
}
