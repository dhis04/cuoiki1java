package SQL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.PreparableStatement;

import Model.Items;

public class ItemsData extends DatabaseConnection
{
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public int deleteItems(Items items)
    {
        try
        {
            String sql = "delete from items where IDitems=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,items.getIdItems());
            return preparedStatement.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return -1;
    }
    public int UpdateItems(String id , String name , String num, String size, String price, String importData, String IDbooth )
    {
        try 
        {
            String sql ="UPDATE items SET NameItems = ?, NumberofItems = ?,Size=?,Price=?,importdate=?,IDbooth=? WHERE IDitems = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, num);
            preparedStatement.setString(4, size);
            preparedStatement.setString(5, price);
            preparedStatement.setString(6, importData);
            preparedStatement.setString(7, IDbooth);
            return preparedStatement.executeUpdate();
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return -1;
    }
    public int insertItems(Items items)
    {
        try
        {
            String sql ="insert into items values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,items.getIdItems());
            preparedStatement.setString(2,items.getNameItems());
            preparedStatement.setString(3,Integer.toString(items.getNumberOfItems()));
            preparedStatement.setString(4,Integer.toString(items.getSize()));
            preparedStatement.setString(5,Integer.toString(items.getPriceofItems()));
            preparedStatement.setString(6,items.getImportDateItems());
            preparedStatement.setString(7,items.getIdBooth());
            return preparedStatement.executeUpdate();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return-1;
    }
    public ArrayList<Items>selectItems(String idBooth)
    {
        ArrayList<Items> items = new ArrayList<Items>();
        try 
        {
            String sql = "select * from items where IDbooth=?";
            PreparedStatement preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setString(1, idBooth);
            ResultSet resultSet = preparableStatement.executeQuery();
            while(resultSet.next())
            {
              Items it = new Items();
              it.setIdItems(resultSet.getString(1));
              it.setNameItems(resultSet.getString(2 ));
              it.setNumberOfItems(Integer.parseInt(resultSet.getString(3)));
              it.setSize(Integer.parseInt(resultSet.getString(4)));
              it.setPriceofItems(Integer.parseInt(resultSet.getString(5)));
              it.setImportDateItems(resultSet.getString(6));
              it.setIdBooth(idBooth);
              items.add(it);
            }
        } catch (Exception e) 
        {
           e.printStackTrace();
        }
        return items;
    }
}
