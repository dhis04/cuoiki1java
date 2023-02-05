package UI;

import SQL.LoginData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame
{
    JButton btSign,btExit;
    JTextField txtUser ;
    JPasswordField txtpassword ,txtpass2;
    public SignUp(String s)
    {
        super(s);
        addControl();
        addEvent();
    }
    public void showWh()
    {
        this.setSize(350, 230);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\signup.png"));
        this.setVisible(true);
    }
    public void addControl()
    {
        Container con = getContentPane();
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain,BoxLayout.Y_AXIS));
        con.add(panelMain);

        JPanel panLb = new JPanel();
        panLb.setLayout(new FlowLayout());
        JLabel lbSig = new JLabel("Sign Up");
        panLb.add(lbSig);
        panelMain.add(panLb);

        JPanel panelTxt = new JPanel();
        panelTxt.setLayout(new BoxLayout(panelTxt,BoxLayout.Y_AXIS));
        panelMain.add(panelTxt);

        JPanel panelTxtUser = new JPanel();
        panelTxtUser.setLayout(new FlowLayout());
        JLabel lbUser = new JLabel("User");
        txtUser = new JTextField(20);
        panelTxtUser.add(lbUser);
        panelTxtUser.add(txtUser);
        panelTxt.add(panelTxtUser);

        JPanel panelTxtPass = new JPanel();
        panelTxtPass.setLayout(new FlowLayout());
        JLabel lbPass = new JLabel(" Password");
        txtpassword = new JPasswordField(20);
        panelTxtPass.add(lbPass);
        panelTxtPass.add(txtpassword);
        panelTxt.add(panelTxtPass);

        JPanel panelTxtPass2 = new JPanel();
        panelTxtPass2.setLayout(new FlowLayout());
        JLabel lbPass2 = new JLabel("Re-enter");
        txtpass2 = new JPasswordField(20);
        panelTxtPass2.add(lbPass2);
        panelTxtPass2.add(txtpass2);
        panelTxt.add(panelTxtPass2);

        lbUser.setPreferredSize(lbPass2.getPreferredSize());
        lbPass2.setPreferredSize(lbPass.getPreferredSize());

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelMain.add(panelButton);
        btSign=new JButton("Sign Up");
        btSign.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\add-user.png"));
        btExit=new JButton("Exit");
        btExit.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\error2.png"));
        panelButton.add(btSign);
        panelButton.add(btExit);



    }
    public  void addEvent()
    {

        btSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpEvent();
            }
        });
        btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginorCreate loginorCreate = new LoginorCreate("Welcome");
                loginorCreate.showWh();
            }
        });
    }
    public void SignUpEvent()
    {
        LoginData lg = new LoginData();
        if(txtUser.getText()!=null)
        {
            if(lg.checkUser(txtUser.getText())==true)
            {
                JOptionPane.showMessageDialog(null,"User name already exists.\n Please choose a different name.");
                txtUser.setText("");
                txtpassword.setText("");
                txtpass2.setText("");
            }
            else
            {
                char[] password1 = txtpassword.getPassword();
                char[] password2 = txtpass2.getPassword();
                String str1 = new String(password1);
                String str2 = new String(password2);

                if(str1.equals(str2))
                {
                    if(lg.addUser(txtUser.getText(),txtpassword.getText())>0)
                    {
                        int op = JOptionPane.showConfirmDialog(null,"Do you want to Log In now","Sign Up ",JOptionPane.YES_NO_OPTION);
                        if(op==JOptionPane.YES_OPTION)
                        {
                            dispose();
                            Login log = new Login("Log In");
                            log.showWh();
                        }
                        else
                        {
                            dispose();
                            LoginorCreate lc = new LoginorCreate("Welcome");
                            lc.showWh();
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password and re-entered password do not match.\n Please re-enter.");
                    txtpassword.setText("");
                    txtpass2.setText("");
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"User name cannot be empty.");
        }

    }
}
