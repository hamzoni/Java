
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;

public class UserListButtonOffMsg extends Action {

    public UserListButtonOffMsg(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.c.getvOffMsg().setVisible(true);
    }
    
}
