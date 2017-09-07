
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonRegister extends Action {

    public LoginButtonRegister(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.c.getvRegister().setVisible(true);
        this.c.getvLogin().setVisible(false);
        this.c.getvRegister().setLocationRelativeTo(null);
        this.c.getvLogin().setLocationRelativeTo(null);
    }
    
}
