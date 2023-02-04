package testpass;

import Model.Items;
import SQL.ItemsData;

public class testtrue 
{

    public static void main(String[] args) {
        ItemsData items= new ItemsData();
        if(items.checkIDExists("Ak")==true)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
}
