package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginorCreate extends JFrame
{
    JButton btLogin , btsigup,btcancel;

    public LoginorCreate(String s)
    {
        super(s);
        addControl();
        addEvent();

    }
    public void showWh()
    {
        this.setSize(350, 230);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\welcome.png"));
        this.setVisible(true);
    }
    public void addControl()
    {

        Color mycl = new Color(92,176,143);
        Container con = getContentPane();
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain,BoxLayout.Y_AXIS));
        con.add(panelMain);

        JPanel panelLabel = new JPanel();
        JLabel lbWel = new JLabel("Welcome to my shop!");
        panelLabel.setBackground(mycl);
        panelLabel.setLayout(new FlowLayout());
        JLabel lbchao = new JLabel(" If you have an account, please select the Login option.");
        JLabel lblog = new JLabel(" If you're new here, please choose Sign Up ");
        JLabel lbsignup = new JLabel("Thank you and looking forward to your visit!");
        panelLabel.add(lbWel);
        panelLabel.add(lbchao);
        panelLabel.add(lblog);
        panelLabel.add(lbsignup);
        panelLabel.setBackground(mycl);
        panelMain.add(panelLabel);

        JPanel panelbutton = new JPanel();
        panelbutton.setLayout(new FlowLayout());
        panelbutton.setBackground(mycl);
        panelMain.add(panelbutton);
        btLogin= new JButton("Log In");
        btLogin.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\logwel.png"));
        btsigup= new JButton("Sign Up");
        btsigup.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\addwel.png"));
        btcancel = new JButton("Cancel");
        btcancel.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\error2.png"));
        panelbutton.add(btLogin);
        panelbutton.add(btsigup);
        panelbutton.add(btcancel);


    }
    public void addEvent()
    {

        btLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login log = new Login("Log In");
                log.showWh();
            }
        });
        btcancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        btsigup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUp signUp = new SignUp("Sign Up");
                signUp.showWh();
            }
        });
    }
}
