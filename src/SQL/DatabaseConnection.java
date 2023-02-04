package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private String MYSQL_HOSTNAME = "localhost";
    private String MYSQL_USERNAME = "root";
    private  String MYSQL_PASSWORD = " ";

   
    private String MYSQL_DATABASE = "shopshoemanager";

    public   Connection connection;

    public DatabaseConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://" + MYSQL_HOSTNAME + "/" + MYSQL_DATABASE;
            connection=DriverManager.getConnection(url, "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
