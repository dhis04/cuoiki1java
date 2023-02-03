package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import Model.Booth;

public class ListBoothDatabase extends DatabaseConnection
{
    public int Savenew(Booth booth)
    {
        try
        {
            String sql = "insert into booth values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, booth.getIdBooth());
            preparedStatement.setString(2, booth.getNameBooth());
            // trả về giá trị số lần insert thành công
            return preparedStatement.executeUpdate();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    public ArrayList<Booth>selectList()
    {

        ArrayList<Booth> list = new ArrayList<Booth>();
        try 
        {
            String sql ="Select * from booth";
            PreparedStatement preparableStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparableStatement.executeQuery(sql);

            while(resultSet.next())
            {
                Booth listBooth = new Booth();
                listBooth.setIdBooth(resultSet.getString(1));
                listBooth.setNameBooth(resultSet.getString(2));
                list.add(listBooth);

            }
        } catch (Exception e)  
        {
           
        }
        return list;
    }
}
