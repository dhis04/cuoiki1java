package testpass;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalendarGUI {
    protected JFrame calendarFrame;
    private JTextField dateField;
    private String selectedDate;

    public CalendarGUI() {
        calendarFrame = new JFrame("Calendar");
        JPanel calendarPanel = new JPanel();
        dateField = new JTextField();
        JButton okButton = new JButton("OK");

       okButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               selectedDate = dateField.getText();
               calendarFrame.dispose();
           }
       });
        calendarPanel.add(dateField);
        calendarPanel.add(okButton);
        calendarFrame.add(calendarPanel);
        calendarFrame.pack();
        calendarFrame.setVisible(true);
    }

    public String getSelectedDate() {
        return selectedDate;
    }
}

class MainGUI {
    private JFrame mainFrame;
    private JTextField mainTextField;

    public MainGUI() {
        mainFrame = new JFrame("Main GUI");
        JPanel mainPanel = new JPanel();
        mainTextField = new JTextField();
        JButton calendarButton = new JButton("Select Date");

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarGUI calendarGUI = new CalendarGUI();
                // Wait for the calendar GUI to be closed
                calendarGUI.calendarFrame.dispose();
                mainTextField.setText(calendarGUI.getSelectedDate());
            }
        });

        mainPanel.add(mainTextField);
        mainPanel.add(calendarButton);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}

public class Main {
    public static void main(String[] args) {
        MainGUI mainGUI = new MainGUI();
    }
}
