
package Action;

import Controller.Controller;
import java.awt.event.ActionEvent;

public class UserListButtonClose extends Action {

    public UserListButtonClose(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
