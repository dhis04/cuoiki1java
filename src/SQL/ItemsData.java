package SQL;

import java.sql.*;
import java.text.ParseException;
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
    public int updateItem(String IDitems, String Nameitems, int Num, int Size, int Price, String importdate,String IDbooth) {
        int result = 0;
        try {
            String query = "UPDATE `items` SET `NameItems` = ?, `NumberofItems` = ?, `Size` =?, `Price` =?, `importdate` = ? WHERE `items`.`IDitems` = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, Nameitems);
            preparedStmt.setInt(2, Num);
            preparedStmt.setInt(3, Size);
            preparedStmt.setInt(4,Price);
            preparedStmt.setString(5, importdate);
            preparedStmt.setString(6, IDitems);
            result = preparedStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteAllItems(String idBooth )
    {

        try {
            String sql = "delete from items where IDbooth=?";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.setString(1,idBooth);
            return  preparedStmt.executeUpdate();
        
        } catch (Exception e) {
           e.printStackTrace();
        }
        return -1;
    }
    public  boolean checkIDBooth(String id) {

        PreparedStatement preparableStatement = null;
        ResultSet resultSet = null;
        try
        {   String sql = "select * from items where IDbooth=?";
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
    public  boolean checkIDExists(String id) {

        PreparedStatement preparableStatement = null;
        ResultSet resultSet = null;
        try 
        {   String sql = "select * from items where IDitems=?";
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
       /* finally {
            try
            {

                if(resultSet!=null)
                {
                    resultSet.close();
                }
                if(preparableStatement!=null)
                {
                    preparableStatement.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return false;
        }*/
        

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
    public ArrayList<Items>Arrage()
    {
        ArrayList<Items> items = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {


            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM items");
            while (resultSet.next()) {
                String id = resultSet.getString("IDitems");
                String name=resultSet.getString("NameItems");
                int num =resultSet.getInt("NumberofItems");
                int size= resultSet.getInt("Size");
                int price = resultSet.getInt("Price");
                String date = resultSet.getString("importdate");
                String idBooth = resultSet.getString("IDbooth");
                items.add(new Items(id,name,num,size,price,date,idBooth));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return items;

    }
}
