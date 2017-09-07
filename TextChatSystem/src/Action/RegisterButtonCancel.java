
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterButtonCancel extends Action {

    public RegisterButtonCancel(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.c.getvRegister().setVisible(false);
        this.c.getvLogin().setVisible(true);
        this.c.getvRegister().setLocationRelativeTo(null);
        this.c.getvLogin().setLocationRelativeTo(null);
    }
    
}
