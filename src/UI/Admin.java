package UI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.toedter.calendar.JCalendar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Admin extends JFrame {
    Datepicker dt = new Datepicker("Datepicker");
   
    JTextField txtID, txtName, txtNum, txtPrice, txtImport, txtSize;

    JButton btAdd, btSave, btDelete, btArr, btLogOut, btUp, btSearch;
    JMenuItem menuNew, menuEdit, menuDelete;
    JPopupMenu popup;
    JButton chosedate;

    DefaultTableModel dtmListItems;
    JTable itemsJTable;

    DefaultMutableTreeNode root;
    JTree ListBooth;

    String textdate ;

    public Admin(String s) 
    {
        super(s);
        addControl();
        addEvent();
        setTextFieldText();
    }

    public void showWh() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\adminicon.png"));
        this.setVisible(true);
    }

    public void setTextFieldText()
    {
        txtImport.setText(dt.getDate());
    }
    
  
    
    public void addControl() {
        Color mycolor = new Color(45, 156, 175);
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        JPanel panelLeft = new JPanel();
        JLabel lbLeft = new JLabel();
        panelLeft.add(lbLeft);
        lbLeft.setOpaque(true);
        panelLeft.setPreferredSize(new Dimension(300, 0));
        JPanel panelRight = new JPanel();
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
        con.add(sp, BorderLayout.CENTER);

        panelLeft.setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("List Booth");
        ListBooth = new JTree(root);
        JScrollPane scTree = new JScrollPane(ListBooth, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelLeft.add(scTree, BorderLayout.CENTER);

        panelRight.setLayout(new BorderLayout());
        JPanel panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(0, 300));
        panelTop.setLayout(new BorderLayout());
        JPanel panelBottom = new JPanel();

        JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTop, panelBottom);
        panelRight.add(sp2, BorderLayout.CENTER);

        dtmListItems = new DefaultTableModel();
        dtmListItems.addColumn("ID Items");
        dtmListItems.addColumn("Name Items");
        dtmListItems.addColumn("Number of Items");
        dtmListItems.addColumn("Price of Items");
        dtmListItems.addColumn("Import date Items");
        itemsJTable = new JTable(dtmListItems);
        JScrollPane scTable = new JScrollPane(itemsJTable,
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelTop.add(scTable, BorderLayout.CENTER);

        panelBottom.setLayout(new BorderLayout());
        JPanel panelBotLeft = new JPanel();
        JPanel panelRightBot = new JPanel();
        panelRightBot.setLayout(new BoxLayout(panelRightBot, BoxLayout.Y_AXIS));
        JLabel lbImg = new JLabel();
        JLabel lbText = new JLabel();
        lbText.setText("H & H shop");
        lbText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        lbImg.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\shoe.png"));
        panelRightBot.add(lbImg);
        panelRightBot.add(lbText);
        panelBottom.add(panelRightBot, "Center");

        panelBottom.add(panelBotLeft, "West");
        panelBotLeft.setLayout(new BoxLayout(panelBotLeft, BoxLayout.Y_AXIS));
        JPanel panelID = new JPanel();
        panelID.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbMa = new JLabel();
        lbMa.setText("ID");

        txtID = new JTextField(20);
        panelID.add(lbMa);
        panelID.add(txtID);
        panelBotLeft.add(panelID);

        JPanel panelNameItems = new JPanel();
        panelNameItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbN = new JLabel();
        lbN.setText("Name Items");

        txtName = new JTextField(20);
        panelNameItems.add(lbN);
        panelNameItems.add(txtName);
        panelBotLeft.add(panelNameItems);

        JPanel panelNumberItems = new JPanel();
        panelNumberItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbN2 = new JLabel();
        lbN2.setText("Number of Items");
        txtNum = new JTextField(20);
        panelNumberItems.add(lbN2);
        panelNumberItems.add(txtNum);
        panelBotLeft.add(panelNumberItems);

        JPanel panelSize = new JPanel();
        panelSize.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbS = new JLabel();
        lbS.setText("Size");
        txtSize = new JTextField(20);
        panelSize.add(lbS);
        panelSize.add(txtSize);
        panelBotLeft.add(panelSize);

        JPanel panelPriceItems = new JPanel();
        panelPriceItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbP = new JLabel();
        lbP.setText("Price of Items");
        txtPrice = new JTextField(20);
        panelPriceItems.add(lbP);
        panelPriceItems.add(txtPrice);
        panelBotLeft.add(panelPriceItems);

        JPanel panelDateItems = new JPanel();
        panelDateItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbD = new JLabel();
        lbD.setText("Import date Items");
        txtImport = new JTextField(20);
        //setTextFieldText(dt.getDate());
        //txtImport.setEditable(false);
        chosedate = new JButton("Chosse date");
        panelDateItems.add(lbD);
        panelDateItems.add(txtImport);
        panelDateItems.add(chosedate);
        panelBotLeft.add(panelDateItems);

        lbMa.setPreferredSize(lbD.getPreferredSize());
        lbN.setPreferredSize(lbD.getPreferredSize());
        lbN2.setPreferredSize(lbD.getPreferredSize());
        lbS.setPreferredSize(lbD.getPreferredSize());
        lbP.setPreferredSize(lbD.getPreferredSize());

        Color make = new Color(172, 232, 243);
        JPanel panelBotRight = new JPanel();
        panelBotLeft.add(panelBotRight);
        panelBotRight.setLayout(new BoxLayout(panelBotRight, BoxLayout.X_AXIS));
        btAdd = new JButton("Insert");
        btAdd.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\file.png"));
        btAdd.setBackground(make);
        panelBotRight.add(btAdd);

        btSave = new JButton("Save");
        btSave.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\save.png"));
        btSave.setBackground(make);
        panelBotRight.add(btSave);

        btDelete = new JButton("Delete");
        btDelete.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\delete.png"));
        btDelete.setBackground(make);
        panelBotRight.add(btDelete);

        btUp = new JButton(" Update ");
        btUp.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\captcha.png"));
        btUp.setBackground(make);
        panelBotRight.add(btUp);

        btArr = new JButton("Arrange");
        btArr.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\arrange.png"));
        btArr.setBackground(make);
        panelBotRight.add(btArr);

        btSearch = new JButton("Search");
        btSearch.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\search.png"));
        btSearch.setBackground(make);
        panelBotRight.add(btSearch);

        btLogOut = new JButton("Log Out");
        btLogOut.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\logout.png"));
        btLogOut.setBackground(make);
        panelBotRight.add(btLogOut);

        Menu();

    }

    public void Menu() {
        menuNew = new JMenuItem("Add new Booth");
        menuNew.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\add.png"));
        menuEdit = new JMenuItem("Edit");
        menuEdit.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\editt.png"));
        menuDelete = new JMenuItem("Delete");
        menuDelete.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\dele.png"));
        popup = new JPopupMenu();
        popup.add(menuNew);
        popup.add(menuEdit);
        popup.addSeparator();
        popup.add(menuDelete);
    }

    public void addEvent() {
       // txtImport.setText(dt.getDate());
        btLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login lg = new Login("Login");
                dispose();
                lg.showWh();
            }
        });
        chosedate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dt.showWh();
                
            }
        });

        ListBooth.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    int row = ListBooth.getClosestRowForLocation(e.getX(), e.getY());
                    ListBooth.setSelectionRow(row);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }

}
