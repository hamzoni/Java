
package Action;

import Controller.Controller;
import GUI.DialogLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogLoginEvents <T> extends Event {
    
    private DialogLogin dialog;
    
    public DialogLoginEvents(Controller c, T dialog) {
        super(c);
        this.dialog = (DialogLogin) dialog;
        setEventListeners();
    }

    @Override
    protected void setEventListeners() {
        dialog.getButton_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = dialog.getInput_username().getText();
                c.setNWC(username);
            }
        });
    }

    @Override
    protected void setCompContents() {
    }
    
}
