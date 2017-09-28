package Action;

import Controller.Controller;
import GUI.Login;
import java.awt.event.ActionEvent;

public class LoginController {
    private Controller c;
    private Login vLogin;
    
    public LoginController(Login vLogin, Controller c) {
        c.getvLogin().getButton_login().addActionListener(new LoginButtonSubmit());
        c.getvLogin().getButton_cancel().addActionListener(new LoginButtonCancel());
        c.getvLogin().getButton_register().addActionListener(new LoginButtonRegister());
        this.vLogin = vLogin;
        this.c = c;
    }

    class LoginButtonSubmit extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            String login = c.getvLogin().getInput_login().getText();
            String pwd = c.getvLogin().getInput_password().getText();

            if (!c.getData().checkLogin(login, pwd)) {
                c.getvLogin().getLabel_announce().setText("Username or password wrong");
            } else {
                c.getvLogin().setVisible(false);
                c.getvListUser().getLabel_fullName().setText(c.getData().getaUser().getFullName());
                c.getvListUser().setVisible(true);
                // Attempt to create server
                c.initServer();
            }
        }

    }
    
    class LoginButtonRegister extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            c.getvRegister().setVisible(true);
            c.getvLogin().setVisible(false);
            c.getvRegister().setLocationRelativeTo(null);
            c.getvLogin().setLocationRelativeTo(null);
        }

    }
    class LoginButtonCancel extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }
}
