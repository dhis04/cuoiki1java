package SQL;

import Model.Items;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SearchDataItems extends DatabaseConnection
{

    public ArrayList<Items> selectItems(String idItems)
    {
        ArrayList<Items> items = new ArrayList<Items>();
        try
        {
            String sql = "select * from items where IDitems=?";
            PreparedStatement preparableStatement = connection.prepareStatement(sql);
            preparableStatement.setString(1, idItems);
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
                //it.setIdBooth(idBooth);
                items.add(it);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return items;
    }
}
