package testpass;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class EnterKeyToClickButton {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JButton button = new JButton("Click me");
    frame.add(button);

    button.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "clickButton");
    button.getActionMap().put("clickButton", new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        button.doClick();
      }
    });

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
