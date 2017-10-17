
package Action;

import Controller.Controller;
import GUI.JFrameLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameLoginEvents <T> extends Event {
    
    private JFrameLogin frame;
    
    public JFrameLoginEvents(Controller c, T frame) {
        super(c);
        this.frame = (JFrameLogin) frame;
        setEventListeners();
    }

    @Override
    protected void setEventListeners() {
        frame.getButton_login().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = frame.getInput_username().getText();
                c.setNWC(username);
            }
        });
    }

    @Override
    protected void setCompContents() {
    }
    
}
