package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToMysql {
    public Connection connect() throws Exception{
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String passw = "root";
        Connection c = DriverManager.getConnection(url, username, passw);

        return c;
    }
}
