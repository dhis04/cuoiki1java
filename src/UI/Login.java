package UI;

import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import com.mysql.cj.xdevapi.Statement;

import Model.LoginMl;
import SQL.LoginCheck;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement.*;

public class Login extends JFrame
{
    JTextField txtUser ;
    JPasswordField  txtPassword;
    JButton btLogin,btCancel;
    public Login(String s)
    {
        super(s);
        addControl();
        addEvent();
    }
    public void showWh()
    {
        this.setSize(400,200 );
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\log-in.png"));
        this.setVisible(true);
    }
    public void addEvent()
    {
       btLogin.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
               EventLogin();
           }
       });
       btCancel.addActionListener(new ActionListener()
       {
           @Override
           public void actionPerformed(ActionEvent e)
           {
              System.exit(0);
           }
       });
       
    }
    public void EventLogin()
    {
       LoginCheck check = new LoginCheck();
       String user = txtUser.getText();
       String password = txtPassword.getText();
       boolean n = check.checkCredentials(user, password);
       if(n==true)
       {
          this.dispose();
          Admin ad = new Admin("Admin");
          ad.showWh();
       }
       else
       {
        JOptionPane.showMessageDialog(btLogin, "Login fail");
        txtUser.setText("");
        txtPassword.setText("");
       }
    }
    public void addControl()
    {
        Container con = getContentPane();
        Color color = new Color(225,123,16);
        JPanel pnMain = new JPanel();
        JLabel label = new JLabel();
        label.setBackground(color);
        con.add(pnMain);
        Color mycolor = new Color(93,185,187);
       pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
       JPanel pnTop = new JPanel();
       pnTop.setLayout(new FlowLayout());
       JLabel lbTop = new JLabel();
       lbTop.setText("LOG IN SHOP ");
       lbTop.setFont(new Font("Ariel Signature", Font.BOLD, 20));
       lbTop.setForeground(mycolor);
       pnTop.add(lbTop);
       pnMain.add(pnTop);
    

       JPanel pnCenter = new JPanel();
       pnCenter.setLayout(new BorderLayout());
       JPanel pnRight = new JPanel();
       JPanel pnLeft = new JPanel();
       JLabel lbimg = new JLabel();
       lbimg.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\loginn_64px.png"));
       pnLeft.add(lbimg);
       pnCenter.add(pnLeft,"West");
       
       JPanel pnUser = new JPanel();
       pnUser.setLayout(new FlowLayout());
       JLabel lbuser = new JLabel();
       lbuser.setText("User");
       txtUser = new JTextField(20);
       pnUser.add(lbuser);
       pnUser.add(txtUser);
       pnRight.add(pnUser);

       JPanel pnPassword = new JPanel();
       pnPassword.setLayout(new FlowLayout());
       JLabel lbpass = new JLabel();
       lbpass.setText("Password");
       txtPassword = new JPasswordField(20);
       pnPassword.add(lbpass);
       pnPassword.add(txtPassword);
       pnRight.add(pnPassword);

       pnCenter.add(pnRight,"Center");
       pnMain.add(pnCenter);

       JPanel pnBot = new JPanel();
       pnBot.setLayout(new FlowLayout());
       btLogin = new JButton("Log In");
       btLogin.setBackground(color);
       btLogin.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\loginn.png"));
       pnBot.add(btLogin);
       btCancel= new JButton("Cancel");
       btCancel.setBackground(color);
       btCancel.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\close-16px.png"));
       pnBot.add(btLogin);
       pnBot.add(btCancel);
       pnMain.add(pnBot);

       lbuser.setPreferredSize(lbpass.getPreferredSize());

       


      
    }

}
