
package Action;

import Controller.Controller;
import Entities.User;
import GUI.Chat;
import java.awt.event.ActionEvent;

public class ChatboxButtonSend extends Action {
    private Chat chat;
    public ChatboxButtonSend(Controller c, Chat chat) {
        super(c);
        this.chat = chat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User target = this.chat.receiver;
        User source = this.c.getData().getaUser();
        String message = this.chat.getInput_message().getText();
        this.chat.getInput_message().setText("");
        if (this.chat.isOnline) {
            // Send online message
            this.c.client.sendMessage(source, target, message);
        } else {
            this.c.getData().addOfflineMessage(source.getLogin(), target.getLogin(), message);
        }
    }
    
}
