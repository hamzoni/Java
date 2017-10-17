
package Event;

import Controller.Calculator;
import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ButtonEvent implements ActionListener {
    
    private JButton b;
    private Controller c;
    
    public ButtonEvent(JButton b, Controller c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Match number
        new Calculator(b.getText(), c);
    }
    
}
