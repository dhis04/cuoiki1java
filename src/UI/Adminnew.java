package UI;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.cj.xdevapi.Table;
import com.toedter.calendar.JCalendar;

import Model.Booth;
import Model.Items;
import SQL.ItemsData;
import SQL.ListBoothDatabase;
import TryCatch.PriceEx;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;




public class Adminnew  extends JFrame
{
        JTextField txtID, txtName, txtNum, txtPrice, txtImport, txtSize;

        JButton btAdd, btSave, btDelete, btArr, btLogOut, btUp, btSearch,btExcel;
        JMenuItem menuNew, menuEdit, menuDelete;
        JPopupMenu popup;
        JButton chosedate;
        JCalendar calendar;
        DefaultTableModel dtmListItems;
        JTable itemsJTable;
    
        DefaultMutableTreeNode root;
        JTree ListBooth;

        String date ;

        ListBoothDatabase datalist ;
        ArrayList<Booth> boothList;
        Booth selectBooth;

        ItemsData dataItems;
        ArrayList<Items> itemsList;
        Items selectedItem;
       

    public Adminnew(String s) 
    {
        super(s);
        addControl();
        addEvent();
        showListBooth();

    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void showWh() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\adminicon.png"));
        this.setVisible(true);
    }
    public void addControl()
    {
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
        dtmListItems.addColumn("Size");
        dtmListItems.addColumn("Price of Items");
        dtmListItems.addColumn("Import date Items");
        itemsJTable = new JTable(dtmListItems);
        JScrollPane scTable = new JScrollPane(itemsJTable,
         JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelTop.add(scTable, BorderLayout.CENTER);

        panelBottom.setLayout(new BoxLayout(panelBottom, BoxLayout.Y_AXIS));
        //con.add(panelBottom);
        JPanel panelBotOn = new JPanel();
        panelBotOn.setLayout(new BoxLayout(panelBotOn, BoxLayout.X_AXIS));
        panelBottom.add(panelBotOn);

        JPanel panelBotOnLbTf = new JPanel();
        panelBotOnLbTf.setLayout(new BoxLayout(panelBotOnLbTf, BoxLayout.Y_AXIS));
        panelBotOn.add(panelBotOnLbTf);

        JPanel panelID = new JPanel();
        panelID.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbMa = new JLabel();
        lbMa.setText("ID");
        txtID = new JTextField(20);
        panelID.add(lbMa);
        panelID.add(txtID);
        panelBotOnLbTf.add(panelID);

        JPanel panelNameItems = new JPanel();
        panelNameItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbN = new JLabel();
        lbN.setText("Name Items");
        txtName = new JTextField(20);
        panelNameItems.add(lbN);
        panelNameItems.add(txtName);
        panelBotOnLbTf.add(panelNameItems);

        JPanel panelNumberItems = new JPanel();
        panelNumberItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbN2 = new JLabel();
        lbN2.setText("Number of Items");
        txtNum = new JTextField(20);
        panelNumberItems.add(lbN2);
        panelNumberItems.add(txtNum);
        panelBotOnLbTf.add(panelNumberItems);

        JPanel panelSize = new JPanel();
        panelSize.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbS = new JLabel();
        lbS.setText("Size");
        txtSize = new JTextField(20);
        panelSize.add(lbS);
        panelSize.add(txtSize);
        panelBotOnLbTf.add(panelSize);

        JPanel panelPriceItems = new JPanel();
        panelPriceItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbP = new JLabel();
        lbP.setText("Price of Items");
        txtPrice = new JTextField(20);
        panelPriceItems.add(lbP);
        panelPriceItems.add(txtPrice);
        panelBotOnLbTf.add(panelPriceItems);

        JPanel panelDateItems = new JPanel();
        panelDateItems.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbD = new JLabel();
        lbD.setText("Import date Items");
        txtImport = new JTextField(20);
        txtImport.setEditable(false);
        chosedate = new JButton("Chosse date");
        panelDateItems.add(lbD);
        panelDateItems.add(txtImport);
        panelDateItems.add(chosedate);
        panelBotOnLbTf.add(panelDateItems);

        lbMa.setPreferredSize(lbD.getPreferredSize());
        lbN.setPreferredSize(lbD.getPreferredSize());
        lbN2.setPreferredSize(lbD.getPreferredSize());
        lbS.setPreferredSize(lbD.getPreferredSize());
        lbP.setPreferredSize(lbD.getPreferredSize());

        JPanel panelBotOncalendar = new JPanel();
        panelBotOncalendar.setLayout(new FlowLayout());
        panelBotOn.add(panelBotOncalendar);
        calendar = new JCalendar();
        panelBotOncalendar.setPreferredSize(new Dimension(150, 150));
        panelBotOncalendar.add(calendar,FlowLayout.LEFT);
       


        JPanel panelRightBot = new JPanel();
        panelRightBot.setLayout(new BoxLayout(panelRightBot, BoxLayout.Y_AXIS));
        JLabel lbImg = new JLabel();
        JLabel lbText = new JLabel();
        lbText.setText("H & H shop");
        lbText.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
        lbImg.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\shoe.png"));
        panelRightBot.add(lbImg);
        panelRightBot.add(lbText);
        panelBotOn.add(panelRightBot);


        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout());
        panelBottom.add(panelButton);

        Color make = new Color(172, 232, 243);

        btAdd = new JButton("Insert");
        btAdd.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\file.png"));
        btAdd.setBackground(make);
        panelButton.add(btAdd);


        btDelete = new JButton("Delete");
        btDelete.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\delete.png"));
        btDelete.setBackground(make);
        panelButton.add( btDelete);

        btUp = new JButton(" Update ");
        btUp.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\captcha.png"));
        btUp.setBackground(make);
        panelButton.add( btUp);

        btArr = new JButton("Arrange");
        btArr.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\arrange.png"));
        btArr.setBackground(make);
        panelButton.add( btArr);

        btSearch = new JButton("Search");
        btSearch.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\search.png"));
        btSearch.setBackground(make);
        panelButton.add( btSearch);


        btExcel = new JButton("Excel");
        btExcel.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\excel24px.png"));
        btExcel.setBackground(make);
        panelButton.add(btExcel);

        btLogOut = new JButton("Log Out");
        btLogOut.setIcon(new ImageIcon("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\logout.png"));
        btLogOut.setBackground(make);
        panelButton.add( btLogOut);


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
        btExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Save as");
                chooser.setSelectedFile(new File("Data.xlsx"));
                int option = chooser.showSaveDialog(Adminnew.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    exportToExcel(itemsJTable, chooser.getSelectedFile());
                }

            }
        });
        btArr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectBooth=null;
                ArragEvent();
            }
        });
        btSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArragEvent();
            }
        });
        btUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateEvent();
                showListBooth();
                ListBooth.updateUI();
            }
        });
        btSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LookForUI lk = new LookForUI("Look For Items");
                lk.showWh();
            }
        });
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!PriceEx.PriceInteger(txtPrice)||!PriceEx.PriceInteger(txtSize)||!PriceEx.PriceInteger(txtNum))
                {
                    JOptionPane.showMessageDialog(null, " Price,Size and Number of item  is an integer type please re-enter.", "Error", JOptionPane.ERROR_MESSAGE);
                    txtPrice.setText("");
                    txtNum.setText("");
                    txtSize.setText("");
                }
               else
                {
                    addItemsEvent();
                }
            }
        });
        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEvent();
            }
        });
        menuDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                DeleteBooth deleteBooth = new DeleteBooth("Delete Booth");
                deleteBooth.showWh();
                showListBooth();
                ListBooth.updateUI();
            }
        });
        menuNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBooth adbt= new AddBooth("Add new booth");
                adbt.showWh();
                showListBooth();
                ListBooth.updateUI();
            }
        });
        menuEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatBooth up = new UpdatBooth("Update booth");
                up.showWh();
                showListBooth();
                ListBooth.updateUI();
            }
        });
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
                Calendar selectedDate = calendar.getCalendar();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                setDate(dateFormat.format(selectedDate.getTime()));
                txtImport.setText(getDate());
                 
             }
         });
 
         ListBooth.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
 
                DefaultMutableTreeNode nodeSelect
                 = (DefaultMutableTreeNode) ListBooth.getLastSelectedPathComponent();
                if(nodeSelect==null) return;
                if(dataItems==null)
                dataItems=new ItemsData();
                selectBooth = (Booth) nodeSelect.getUserObject();
                if(selectBooth!=null) 
                itemsList= dataItems.selectItems(selectBooth.getIdBooth());
                showListItems();

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
 

         itemsJTable.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                 int row = itemsJTable.getSelectedRow();
                 if(row ==-1) return ;
                 selectedItem = itemsList.get(row);
                 txtID.setText(selectedItem.getIdItems());
                 txtName.setText(selectedItem.getNameItems());
                 txtNum.setText(Integer.toString(selectedItem.getNumberOfItems()));
                 txtSize.setText(Integer.toString(selectedItem.getSize()));
                 txtPrice.setText(Integer.toString(selectedItem.getPriceofItems()));
                 txtImport.setText(selectedItem.getImportDateItems());
             }

             @Override
             public void mousePressed(MouseEvent e) {

             }

             @Override
             public void mouseReleased(MouseEvent e) {

             }

             @Override
             public void mouseEntered(MouseEvent e) {

             }

             @Override
             public void mouseExited(MouseEvent e) {

             }
         });
     }
     public void showListItems()
     {
        dtmListItems.setRowCount(0);
        for(Items item : itemsList)
        {
            Vector<Object> vec = new Vector<Object>();
            vec.add(item.getIdItems());
            vec.add(item.getNameItems());
            vec.add(item.getNumberOfItems());
            vec.add(item.getSize());
            vec.add(item.getPriceofItems());
            vec.add(item.getImportDateItems());
            dtmListItems.addRow(vec);
        }
     }

    
     public void showListBooth()
     {
       if(datalist==null)
       datalist= new ListBoothDatabase();
       boothList=datalist.selectList();
       root.removeAllChildren();
       for(Booth booth : boothList)
       {
        DefaultMutableTreeNode nodeListBooth = new DefaultMutableTreeNode(booth);
        root.add(nodeListBooth);
       }
       ListBooth.expandRow(0);


     }
     public void ArragEvent()
     {
         ItemsData itemsData = new ItemsData();
         ArrayList<Items> itemslistsort = itemsData.Arrage();
         Collections.sort(itemslistsort, (o1, o2) -> Integer.compare(o1.getPriceofItems(), o2.getPriceofItems()));
         for(Items item :itemslistsort)
         {
             dtmListItems.addRow(new Object[]{item.getIdItems(),item.getNameItems(),item.getNumberOfItems(),item.getSize(),item.getPriceofItems(),item.getImportDateItems()});
         }
         itemsJTable.setModel(dtmListItems);
         itemsJTable.repaint();
     }
     public void deleteEvent()
     {
         if(selectedItem==null) return;
         int op = JOptionPane.showConfirmDialog(null,"Do you want to detele this items?","Delete",JOptionPane.YES_NO_OPTION);
         if(op==JOptionPane.YES_OPTION)
         {
             txtID.setText(null);
             txtImport.setText(null);
             txtName.setText(null);
             txtNum.setText(null);
             txtPrice.setText(null);
             txtSize.setText(null);
             if(dataItems==null)
                 dataItems=new ItemsData();
             if(dataItems.deleteItems(selectedItem)>0)
             {
                 if(selectBooth!=null) itemsList= dataItems.selectItems(selectBooth.getIdBooth());
                 showListItems();
             }
         }
     }
     public void  addItemsEvent()
     {

         ItemsData itemsData = new ItemsData();
         if(itemsData.checkIDExists(txtID.getText())==true)
         {
             JOptionPane.showMessageDialog(null,"It's have ID: "+txtID.getText()+" You can't add items");

         }
         else
         {
             try
             {
                 Items items = new Items();
                 items.setIdItems(txtID.getText());
                 items.setNameItems(txtName.getText());
                 items.setNumberOfItems(Integer.parseInt(txtNum.getText()));
                 items.setSize(Integer.parseInt(txtSize.getText()));
                 items.setPriceofItems(Integer.parseInt(txtPrice.getText()));
                 items.setImportDateItems(txtImport.getText());
                 items.setIdBooth(selectBooth.getIdBooth());
                 ItemsData itdata = new ItemsData();
                 int x= itdata.insertItems(items);
                 int op = JOptionPane.showConfirmDialog(null
                         ,"Do you want to insert this items?"
                         ,"Insert Items",JOptionPane.OK_OPTION);
                 if(op==JOptionPane.OK_OPTION)
                 {
                     txtID.setText(null);
                     txtImport.setText(null);
                     txtName.setText(null);
                     txtNum.setText(null);
                     txtPrice.setText(null);
                     txtSize.setText(null);
                     if(dataItems==null)
                         dataItems=new ItemsData();
                     if(x>0)
                     {
                         if(selectBooth!=null)
                             itemsList= dataItems.selectItems(selectBooth.getIdBooth());
                         showListItems();
                     }

                 }



             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
         }
     }
     public void UpdateEvent()
     {
         ItemsData itemsData=new ItemsData();
         if(itemsData.checkIDExists(txtID.getText())==true)
         {
             try
             {
                 Items items = new Items();
                 items.setIdItems(txtID.getText());
                 items.setNameItems(txtName.getText());
                 items.setNumberOfItems(Integer.parseInt(txtNum.getText()));
                 items.setSize(Integer.parseInt(txtSize.getText()));
                 items.setPriceofItems(Integer.parseInt(txtPrice.getText()));
                 items.setImportDateItems(txtImport.getText());
                 items.setIdBooth(selectBooth.getIdBooth());

                 ItemsData itdata = new ItemsData();
                 int x= itdata.updateItem(items.getIdItems(),items.getNameItems(),items.getNumberOfItems(),items.getSize(),items.getPriceofItems(),items.getImportDateItems(),items.getIdBooth());

                 int op = JOptionPane.showConfirmDialog(null
                         ,"Do you want to update this items?"
                         ,"Update Items",JOptionPane.OK_OPTION);
                 if(op==JOptionPane.OK_OPTION)
                 {

                     if(dataItems==null)
                         dataItems=new ItemsData();
                     if(x>0)
                     {
                         txtID.setText(null);
                         txtImport.setText(null);
                         txtName.setText(null);
                         txtNum.setText(null);
                         txtPrice.setText(null);
                         txtSize.setText(null);
                         System.out.println("Update successful");
                         if(selectBooth!=null)
                             itemsList= dataItems.selectItems(selectBooth.getIdBooth());
                         showListItems();
                     }

                 }



             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }

         }
         else
         {
             JOptionPane.showMessageDialog(null
                     ,"Don't have ID: " + txtID.getText());
         }
     }
    public void exportToExcel(JTable table, File file) {
        try {
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }

            excel.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }

            excel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
