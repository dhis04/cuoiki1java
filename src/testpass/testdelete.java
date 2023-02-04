package testpass;

import SQL.ItemsData;
import SQL.ListBoothDatabase;

public class testdelete
{
    public static void main(String[] args) {
        ListBoothDatabase listBoothDatabase = new ListBoothDatabase();
        ItemsData itemsData = new ItemsData();
        if(itemsData.checkIDBooth("hk2")==true)
        {
            if( itemsData.deleteAllItems("hk2")>0)
            {

                if(listBoothDatabase.deleteooth("hk2")>0)
                {
                    System.out.println("successful");
                }
            }
            else
            {
                System.out.println("not successful");
            }
        }
        else
        {
            if(listBoothDatabase.deleteooth("hk2")>0)
            {
                System.out.println("successful");
            }
        }
    }
}
