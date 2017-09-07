
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;

public class LoginButtonSubmit extends Action {

    public LoginButtonSubmit(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String login = this.c.getvLogin().getInput_login().getText();
        String pwd = this.c.getvLogin().getInput_password().getText();
        
        if (!this.c.getData().checkLogin(login, pwd)) {
            this.c.getvLogin().getLabel_announce().setText("Username or password wrong");
        } else {
            this.c.getvLogin().setVisible(false);
            this.c.getvListUser().getLabel_fullName().setText(this.c.getData().getaUser().getFullName());
            this.c.getvListUser().setVisible(true);
        }
    }
    
}
