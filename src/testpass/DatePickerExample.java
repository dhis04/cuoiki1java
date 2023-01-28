package testpass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import com.toedter.calendar.JCalendar;

public class DatePickerExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                JPanel panel = new JPanel();
                final JCalendar calendar = new JCalendar();
                final JTextField dateField = new JTextField(10);
                dateField.setEditable(false);

                JButton showDateButton = new JButton("Show Selected Date");
                showDateButton.addActionListener(new ActionListener() 
                {
                    public void actionPerformed(ActionEvent e) {
                        Calendar selectedDate = calendar.getCalendar();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        dateField.setText(dateFormat.format(selectedDate.getTime()));
                    }
                });

                panel.add(calendar);
                panel.add(showDateButton);
                panel.add(dateField);

                frame.add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
