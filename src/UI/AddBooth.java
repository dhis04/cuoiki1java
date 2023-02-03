package UI;

import Model.Booth;
import Model.Items;
import SQL.ListBoothDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddBooth extends JDialog
{

    JButton btSave , btExit;
    JTextField txtId, txtName;
    public AddBooth(String s)
    {
        this.setTitle(s);
        addcontrol();
        addEvent();
    }
    public void showWh()
    {
        this.setSize(300, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(true);
        
    }
    public void addcontrol()
    {
        Container con = getContentPane();
        JPanel panelMain = new JPanel();
        con.add(panelMain);
        panelMain.setLayout(new BoxLayout(panelMain,BoxLayout.Y_AXIS));

        JPanel panelTitel = new JPanel();
        JLabel lbTitel = new JLabel("  ADD NEW BOOTH");
        panelTitel.add(lbTitel);
        panelMain.add(panelTitel);

        JPanel panelTextfield = new JPanel();
        panelTextfield.setLayout(new BoxLayout(panelTextfield,BoxLayout.Y_AXIS));
        panelMain.add(panelTextfield);

        JPanel panelID = new JPanel();
        panelID.setLayout(new FlowLayout());
        JLabel lbId  = new JLabel("ID booth");
        txtId=new JTextField(20);
        panelID.add(lbId);
        panelID.add(txtId);
        panelTextfield.add(panelID);

        JPanel panelName = new JPanel();
        panelName.setLayout(new FlowLayout());
        JLabel lbName = new JLabel("Name booth");
        txtName= new JTextField(20);
        panelName.add(lbName);
        panelName.add(txtName);
        panelTextfield.add(panelName);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        btSave= new JButton("Save");
        btExit=new JButton("Exit");
        panelButton.add(btSave);
        panelButton.add(btExit);
        panelMain.add(panelButton);

    }
    public void addEvent()
    {
     btExit.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             dispose();
         }
     });
     btSave.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             EventSave();
         }
     });
    }
    public void EventSave()
    {
     try
     {

         Booth booth = new Booth();
         booth.setIdBooth(txtId.getText());
         booth.setNameBooth(txtName.getText());
         ListBoothDatabase listBoothDatabase = new ListBoothDatabase();
         int x = listBoothDatabase.Savenew(booth);
         if(x>0)
         {
             JOptionPane.showMessageDialog(null,"Add successful ");
         }
     }
     catch(Exception e)
     {
         e.printStackTrace();
     }
    }
}
