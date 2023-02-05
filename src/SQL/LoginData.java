package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginData extends DatabaseConnection
{
    public boolean checkUser(String id)
    {
        PreparedStatement preparableStatement = null;
        ResultSet resultSet = null;
        try
        {   String sql = "select * from login where user = ?";
            preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setString(1, id);
            resultSet = preparableStatement.executeQuery();
            if(resultSet.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }
    public int addUser(String id , String pass)
    {
        try
        {
            String sql ="insert into login values(?,?)";
            PreparedStatement preparedStm = connection.prepareStatement(sql);
            preparedStm.setString(1,id);
            preparedStm.setString(2,pass);
            return preparedStm.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return -1;
    }
}
