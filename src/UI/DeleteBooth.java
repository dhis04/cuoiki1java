package UI;

import SQL.ItemsData;
import SQL.ListBoothDatabase;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBooth extends JDialog
{
    JButton btDelete , btExit;
    JTextField txtId, txtName;
    public DeleteBooth(String s)
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
        JLabel lbTitel = new JLabel(" DELETE BOOTH");
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



        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        btDelete= new JButton("Delete");
        btExit=new JButton("Exit");
        panelButton.add(btDelete);
        panelButton.add(btExit);
        panelMain.add(panelButton);

        //lbId.setPreferredSize(lbName.getPreferredSize());

    }
     public void addEvent()
     {

        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBoothEvent();
            }
        });
        btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
     }
     public void deleteBoothEvent()
     {
         ListBoothDatabase listBoothDatabase = new ListBoothDatabase();
         ItemsData itemsData = new ItemsData();
         if(listBoothDatabase.checkIDExists(txtId.getText())==true)
         {
              //System.out.println(txtId.getText());

             int op = JOptionPane.showConfirmDialog(null,"Do you want to detele this booth?\n If you choose YES, we will delete the store and all items of that store\n If you choose NO, we will keep this store. ","Delete Booth",JOptionPane.YES_NO_OPTION);
             if(op==JOptionPane.YES_OPTION)
             {
                 if(itemsData.checkIDBooth(txtId.getText())==true)
                 {
                     if(itemsData.deleteAllItems(txtId.getText())>0)
                     {
                         if(listBoothDatabase.deleteooth(txtId.getText())>0)
                         {
                             JOptionPane.showMessageDialog(null,"Delete successful");
                         }
                     }
                 }
                 else
                 {
                     if(listBoothDatabase.deleteooth(txtId.getText())>0)
                     {
                         JOptionPane.showMessageDialog(null,"Delete successful");
                     }
                 }
             }



         }
         else
         {
             JOptionPane.showMessageDialog(null,"There are no stores with this ID , Please check again");
         }
     }
}
