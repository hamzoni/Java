package Action;

import Controller.Controller;
import Entities.User;
import GUI.Register;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class RegisterController {
    private Controller c;
    private Register vRegister;

    public RegisterController(Register vRegister, Controller c) {
        this.vRegister = vRegister;
        this.c = c;
        vRegister.getButton_cancle().addActionListener(new RegisterButtonCancel());
        vRegister.getButton_register().addActionListener(new RegisterButtonSubmit());
    }

    public class RegisterButtonCancel extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            c.getvRegister().setVisible(false);
            c.getvLogin().setVisible(true);
            c.getvRegister().setLocationRelativeTo(null);
            c.getvLogin().setLocationRelativeTo(null);
        }

    }
    public class RegisterButtonSubmit extends Action {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = c.getvRegister().getInput_fullName().getText();
            String login = c.getvRegister().getInput_login().getText();
            String pwd = new String(c.getvRegister().getInput_password().getPassword());
            String rpwd = new String(c.getvRegister().getInput_retypePassword().getPassword());
            JLabel errorTxt = c.getvRegister().getLabel_error();

            if (!pwd.equals(rpwd)) {
                c.getvRegister().getInput_fullName().setText("");
                c.getvRegister().getInput_login().setText("");
                c.getvRegister().getInput_password().setText("");
                c.getvRegister().getInput_retypePassword().setText("");
                errorTxt.setText("Password does not match");
            } else {
                User user = new User();
                user.setFullName(name);
                user.setLogin(login);
                user.setPassword(pwd);

                c.getData().addUser(user);
                c.getData().setaUser(user);
                errorTxt.setText("");

                // nagivate back to login frame
                c.getvLogin().getInput_login().setText(user.getLogin());
                c.getvLogin().getInput_password().setText(user.getPassword());
                c.getvRegister().getButton_cancle().doClick();
            }
        }

    }
}
