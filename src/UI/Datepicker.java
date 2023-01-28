package UI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Datepicker extends JFrame 
{
    String date ;
    JButton choose ;
    JCalendar calendar;
    
   
    public Datepicker(String s)
    {
        super(s);
        addControl();
        Event();

    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void showWh()
     {
        this.setSize(300, 250);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\CuoiKiI\\CuoiKi\\src\\Icon\\adminicon.png"));
        this.setVisible(true);
    }
    
    public void addControl()
    {
        Container con = getContentPane();
       JPanel panelMain = new JPanel();
       panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
       con.add(panelMain);


       JPanel panelTop = new JPanel();
       calendar = new JCalendar();
       panelTop.add(calendar);
       panelMain.add(panelTop);


       JPanel panelBot = new JPanel();
       panelBot.setLayout(new FlowLayout());
       choose = new JButton("Choose");
       //ok= new JButton("OK");

      
       panelBot.add(choose);
       //panelBot.add(ok);
       panelMain.add(panelBot);

        
    }
    public void Event()
    {
        choose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Admin ad = new Admin("Administrator");
                Calendar selectedDate = calendar.getCalendar();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                setDate(dateFormat.format(selectedDate.getTime()));
                ad.setTextFieldText();
                //ad.setTextdate(getDate());
                //ad.setTextFieldText(getDate());
                //ad.setTextFieldText(getDate());
                //System.out.println(ad.getTextdate());
               
            }
        });
    }
}
