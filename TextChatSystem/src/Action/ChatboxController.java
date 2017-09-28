package Action;

import Controller.Controller;
import Entities.User;
import GUI.Chat;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChatboxController {
    private Controller c;
    
    public ChatboxController(Controller c) {
        this.c = c;
    }
    
    public class ChatboxMessageListing {

        private Controller c;
        private Chat chat;

        public ChatboxMessageListing(Controller c, Chat chat) {
            this.c = c;
            this.chat = chat;

            chat.getInput_message().addKeyListener(new ChatboxMessageKey(chat));

            // Set title
            String userA = c.getData().getaUser().getFullName();
            String userB = chat.receiver.getFullName();
            String title = userA + " (me) chatting with " + userB;
            chat.getSendFrom().setText(userA);
            chat.getSendTo().setText(userB);
            this.chat.setTitle(title);

        }
        // Use in Controller
        public void updateMessagesList(User userTurn, String newMessage) {
            this.chat.setVisible(true);
            this.chat.getTextarea_chatbox().append(userTurn.getFullName() + ": " + newMessage + "\n");
        }

        public Chat getChat() {
            return chat;
        }

    }
    public class ChatboxButtonSend extends Action {

        private Chat chat;

        public ChatboxButtonSend(Chat chat) {
            this.chat = chat;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            User target = this.chat.receiver;
            User source = c.getData().getaUser();
            String message = this.chat.getInput_message().getText();
            this.chat.getInput_message().setText("");
            // push current chat to UI
            chat.getTextarea_chatbox().append(source.getFullName() +"(me): " + message + "\n");
            if (this.chat.isOnline) {
                c.client.sendMessage(target, message);
            } else {
                c.getData().addOfflineMessage(source.getLogin(), target.getLogin(), message);
            }
        }

    }
    public class ChatboxMessageKey implements KeyListener {

        private Chat c;

        public ChatboxMessageKey(Chat c) {
            this.c = c;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                c.getButton_sendMessage().doClick();
            }
        }

    }

}
