package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck 
{
    public static boolean checkCredentials(String username, String password) {
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
    
          Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/shopshoemanager", "root", "");
    
          String sql = "SELECT COUNT(*) FROM login WHERE user = ? AND password = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
    
          stmt.setString(1, username);
          stmt.setString(2, password);
          ResultSet rs = stmt.executeQuery();
          rs.next();
          int count = rs.getInt(1);
    
          rs.close();
          stmt.close();
          conn.close();
    
          return count > 0;
        } catch (ClassNotFoundException e) 
        {
          return false;
        } catch (SQLException e) {
         
          return false;
        }
      }
}
