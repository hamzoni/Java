
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonCancel extends Action {
    public LoginButtonCancel(Controller c) {
        super(c);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}

