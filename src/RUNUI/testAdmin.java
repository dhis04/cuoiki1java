package RUNUI;

import SQL.DatabaseConnection;
import UI.Adminnew;

public class testAdmin 
{
    public static void main(String[] args) 
    {
        new DatabaseConnection();
        Adminnew admin = new Adminnew("Administrator");
        admin.showWh();
    }
    
}
