
package Action;

import Controller.Controller;
import Entities.OfflineMessage;
import Entities.User;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class OffMsgButtonRead extends Action {

    public OffMsgButtonRead(Controller c) {
        super(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int idx = this.c.getvOffMsg().getList_offlineMessage().getSelectedIndex();
        String sender = (String) OffMsgListing.senders.get(idx).getKey();
        ArrayList<OfflineMessage> msgs = (ArrayList<OfflineMessage>) OffMsgListing.senders.get(idx).getValue();
        
        User targetUser = null;
        for (User user : this.c.getData().getUsersSorted()) {
            if (user.getLogin().equals(sender)) {
                targetUser = user;
                break;
            }
        }
        
        if (!this.c.isAlreadyChat(targetUser)) {
            if (this.c.getData().checkExistOnline(targetUser)) {
                this.c.client.requestChat(targetUser);
            }
            this.c.showChatBox(targetUser, msgs);
        }
    }
    
}
