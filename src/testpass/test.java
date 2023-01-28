package testpass;

import java.sql.*;
import java.util.Scanner;

public class test
{
    public static Connection getConnection(){
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String url = "jdbc:mysql://localhost:3306/login";
            String username ="root";
            String password = "";
            connection = DriverManager.getConnection(url,username,password);
            if(connection!=null) System.out.println("Connected");
        } catch (SQLException e){
            e.getStackTrace();
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        try {
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e){
            e.getStackTrace();
        }
    }


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = test.getConnection();
            String sql = "select * from admin";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
           while (resultSet.next())
           {
               String user = resultSet.getString("user");
               String password = resultSet.getString("password");
               String u;
               System.out.println("Enter user: ");
               u = sc.nextLine();
               String p;
               System.out.println("Enter password");
               p = sc.nextLine();
               if(u.equals(user)&&p.equals(password))
               {
                   System.out.println("Successfully");
               }
               else
               {
                   System.out.println("no Successfully");
               }
           }

            test.closeConnection(connection);
        } catch (SQLException e){
            e.getStackTrace();
        }
    }
}
