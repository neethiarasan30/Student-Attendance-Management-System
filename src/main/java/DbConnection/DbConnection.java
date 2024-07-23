package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static String url = "jdbc:mysql://localhost:3306/SAMS";
    private static String username = "root";
    private static String pass = "80155";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url,username,pass);
    }
}
