package UI;

import Model.Items;
import SQL.SearchDataItems;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class LookForUI extends JFrame
{
    JTextField txtsearch;
    JButton btsearch;
    JTable tbItems;
    DefaultTableModel dtmItems;


    public LookForUI(String s)
    {
        super(s);
        addControl();
        addEvent();
    }

    private void addEvent()
    {
        btsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLook();
            }
        });
    }
    public void showLook()
    {
        SearchDataItems searchDataItems = new SearchDataItems();
        ArrayList<Items> itemsList = searchDataItems.selectItems(txtsearch.getText());
      dtmItems.setRowCount(0);
        for(Items item : itemsList)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(item.getIdItems());
            vec.add(item.getNameItems());
            vec.add(item.getNumberOfItems());
            vec.add(item.getSize());
            vec.add(item.getPriceofItems());
            vec.add(item.getImportDateItems());
            dtmItems.addRow(vec);
        }
    }

    private void addControl()
    {
        Container container = getContentPane();
        JPanel panelMain = new JPanel();
        container.add(panelMain);
        panelMain.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbLook = new JLabel("What do you want to search?");
        txtsearch= new JTextField(25);
        btsearch= new JButton("Search");
        panelTop.add(lbLook);
        panelTop.add(txtsearch);
        panelTop.add(btsearch);
        panelMain.add(panelTop,BorderLayout.NORTH);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());
        panelMain.add(panelCenter,BorderLayout.CENTER);

        dtmItems=new DefaultTableModel();
        dtmItems.addColumn("ID");
        dtmItems.addColumn("Name Items");
        dtmItems.addColumn("Number of items");
        dtmItems.addColumn("Size");
        dtmItems.addColumn("Price of items");
        dtmItems.addColumn("Import date Items");
        tbItems=new JTable(dtmItems);
        JScrollPane scItems = new JScrollPane(tbItems,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelCenter.add(scItems,BorderLayout.CENTER);
    }
    public void showWh() {
        this.setSize(700,450);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\adminicon.png"));
        this.setVisible(true);
    }
}
