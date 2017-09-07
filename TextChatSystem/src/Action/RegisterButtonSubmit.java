
package Action;

import Controller.Controller;
import Entities.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class RegisterButtonSubmit extends Action {

    public RegisterButtonSubmit(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = this.c.getvRegister().getInput_fullName().getText();
        String login = this.c.getvRegister().getInput_login().getText();
        String pwd = new String(this.c.getvRegister().getInput_password().getPassword());
        String rpwd = new String(this.c.getvRegister().getInput_retypePassword().getPassword());
        System.out.println(pwd + " " + rpwd);
        JLabel errorTxt = this.c.getvRegister().getLabel_error();
        
        if (!pwd.equals(rpwd)) {
            this.c.getvRegister().getInput_fullName().setText("");
            this.c.getvRegister().getInput_login().setText("");
            this.c.getvRegister().getInput_password().setText("");
            this.c.getvRegister().getInput_retypePassword().setText("");
            errorTxt.setText("Password does not match");
        } else {
            User user = new User();
            user.setFullName(name);
            user.setLogin(login);
            user.setPassword(pwd);
            
            this.c.getData().addUser(user);
            this.c.getData().setaUser(user);
            errorTxt.setText("");
            
            // nagivate back to login frame
            this.c.getvLogin().getInput_login().setText(user.getLogin());
            this.c.getvLogin().getInput_password().setText(user.getPassword());
            this.c.getvRegister().getButton_cancle().doClick();
        }
    }
    
}