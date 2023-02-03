package TryCatch;

import java.util.regex.Pattern;

import javax.swing.JTextField;

public class PriceEx 
{
    public static boolean PriceInteger(JTextField textField) {
        try {
          Integer.parseInt(textField.getText());
          return true;
        } catch (NumberFormatException e) {
          return false;
        }
      }
}
   


