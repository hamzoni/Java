
package Action;

import Controller.Controller;
import Entities.User;
import java.awt.event.ActionEvent;

public class UserListButtonChat extends Action {

    public UserListButtonChat(Controller c) {
        super(c);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedItem = this.c.getListUserData().getSelectedItem();
        User targetUser = this.c.getData().getUsersSorted().get(selectedItem);
        if (!this.c.isAlreadyChat(targetUser)) {
            if (this.c.getData().checkExistOnline(targetUser)) {
                this.c.client.requestChat(targetUser);
            }
            this.c.showChatBox(targetUser);
        }
    }
    
}
