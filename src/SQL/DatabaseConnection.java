package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static final String MYSQL_HOSTNAME = "localhost";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = " ";

   
    private static final String MYSQL_DATABASE = "shopshoemanager";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
               
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://" + MYSQL_HOSTNAME + "/" + MYSQL_DATABASE + "?autoReconnect=true&useSSL=false";
                connection = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
